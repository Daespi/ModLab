import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ShopCart } from '../../models/ShopCart/ShopCart';
import { environment } from '../../../environments/environment';


  const baseUrl = environment.apiUrlShopCart; // Ajusta según tu backend

@Injectable({
  providedIn: 'root'
})
export class ShopCartService {


  constructor(private http: HttpClient) {}

  getCartByUser(userId: string): Observable<ShopCart[]> {
    return this.http.get<ShopCart[]>(`${baseUrl}/user/${userId}`);
  }

  removeFromCart(cartId: number): Observable<void> {
    return this.http.delete<void>(`${baseUrl}/remove/${cartId}`);
  }

  addToCart(cart: ShopCart): Observable<ShopCart> {
    return this.http.post<ShopCart>(`${baseUrl}/add`, cart);
  }

  clearCart(userId: string): Observable<void> {
    return this.http.delete<void>(`${baseUrl}/clear/${userId}`);
  }
}
