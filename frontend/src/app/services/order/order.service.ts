import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Order } from '../../models/Order/Order';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  private apiUrl = 'http://localhost:8080/modlab/order'; // Ajusta según tu entorno

  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  /** GET - Mensaje de prueba */
  getHola(): Observable<string> {
    return this.http.get<string>(`${this.apiUrl}/`);
  }

  /** GET - Obtener una orden por ID */
  getOrderById(orderId: string): Observable<Order> {
    return this.http.get<Order>(`${this.apiUrl}/${orderId}`);
  }

  /** POST - Crear una nueva orden */
  addOrder(order: Order): Observable<Order> {
    return this.http.post<Order>(this.apiUrl, JSON.stringify(order), this.httpOptions);
  }

  /** PUT - Actualizar una orden existente */
  updateOrder(orderId: string, order: Order): Observable<Order> {
    return this.http.put<Order>(`${this.apiUrl}/${orderId}`, JSON.stringify(order), this.httpOptions);
  }

  /** DELETE - Eliminar una orden por ID */
  deleteOrder(orderId: string): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${orderId}`);
  }
}
