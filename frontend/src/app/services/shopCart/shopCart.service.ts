import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { ShopCart } from '../../models/ShopCart/ShopCart';

@Injectable({
  providedIn: 'root'
})
export class ShopCartService {

  private apiUrl = 'http://localhost:8080/modlab/ShopCart';

  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) {}

  /** Obtener carrito por userId */
  getCartByUser(userId: string): Observable<ShopCart[]> {
    return this.http.get(`${this.apiUrl}/${userId}`, { responseType: 'text' }).pipe(
      map(json => JSON.parse(json))
    );
  }

  /** Añadir producto al carrito (recibe objeto ShopCart en JSON) */
  addProductToCart(cartItem: ShopCart): Observable<ShopCart> {
    return this.http.post<ShopCart>(this.apiUrl, JSON.stringify(cartItem), this.httpOptions);
  }

  /** Actualizar cantidad de producto en carrito por cartId */
  updateCartItem(cartId: number, cartItem: ShopCart): Observable<ShopCart> {
    return this.http.put<ShopCart>(`${this.apiUrl}/${cartId}`, JSON.stringify(cartItem), this.httpOptions);
  }

  /** Eliminar un producto del carrito por cartId */
  deleteItem(cartId: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${cartId}`);
  }

  /** Vaciar carrito completo de un usuario */
  clearUserCart(userId: string): Observable<any> {
    return this.http.delete(`${this.apiUrl}/user/${userId}`);
  }
}
