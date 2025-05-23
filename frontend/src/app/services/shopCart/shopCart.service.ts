import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { ShopCart } from '../../models/ShopCart/ShopCart';

@Injectable({
  providedIn: 'root'
})
export class ShopCartService {

  private apiUrl = 'http://localhost:8080/modlab/ShopCart';

  constructor(private http: HttpClient) {}

  // 🔐 Obtener token del localStorage
  private getToken(): string | null {
    return localStorage.getItem('token');
  }

  // 🔐 Crear headers con token
  private createAuthorizationHeader(): HttpHeaders {
    const token = this.getToken();
    return token
      ? new HttpHeaders({
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`
        })
      : new HttpHeaders({ 'Content-Type': 'application/json' });
  }

  /** Obtener carrito por userId */
  getCartByUser(userId: string): Observable<ShopCart[]> {
    return this.http.get(`${this.apiUrl}/${userId}`, {
      responseType: 'text',
      headers: this.createAuthorizationHeader()
    }).pipe(
      map(json => JSON.parse(json))
    );
  }

  /** Añadir producto al carrito (recibe objeto ShopCart en JSON) */
  addProductToCart(cartItem: ShopCart): Observable<ShopCart> {
    return this.http.post<ShopCart>(this.apiUrl, JSON.stringify(cartItem), {
      headers: this.createAuthorizationHeader()
    });
  }

  /** Actualizar cantidad de producto en carrito por cartId */
  updateCartItem(cartId: number, cartItem: ShopCart): Observable<ShopCart> {
    return this.http.put<ShopCart>(`${this.apiUrl}/${cartId}`, JSON.stringify(cartItem), {
      headers: this.createAuthorizationHeader()
    });
  }

  /** Eliminar un producto del carrito por cartId */
  deleteItem(cartId: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${cartId}`, {
      headers: this.createAuthorizationHeader()
    });
  }

  /** Vaciar carrito completo de un usuario */
  clearUserCart(userId: string): Observable<any> {
    return this.http.delete(`${this.apiUrl}/user/${userId}`, {
      headers: this.createAuthorizationHeader()
    });
  }
}
