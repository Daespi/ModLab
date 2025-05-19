import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

// Modelo OrderDetail que ya deberías tener creado
import { OrderDetail } from '../../models/OrderDetail/OrderDetail';

@Injectable({
  providedIn: 'root'
})
export class OrderDetailService {

  private apiUrl = 'http://localhost:8080/modlab/orderdetail';  // Ajusta la URL a tu backend

  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  /** GET - Mensaje de prueba */
  getHola(): Observable<string> {
    return this.http.get<string>(`${this.apiUrl}/`);
  }

  /** GET - Obtener OrderDetail por ID */
  getOrderDetailById(orderDetailId: string): Observable<OrderDetail> {
    return this.http.get<OrderDetail>(`${this.apiUrl}/${orderDetailId}`);
  }

  /** GET - Obtener todos los OrderDetails de una orden */
  getOrderDetailsByOrderId(orderId: string): Observable<OrderDetail[]> {
    return this.http.get<OrderDetail[]>(`${this.apiUrl}/order/${orderId}`);
  }

  /** POST - Crear un nuevo OrderDetail */
  addOrderDetail(orderDetail: OrderDetail): Observable<OrderDetail> {
    return this.http.post<OrderDetail>(this.apiUrl, JSON.stringify(orderDetail), this.httpOptions);
  }

  /** PUT - Actualizar un OrderDetail existente */
  updateOrderDetail(orderDetailId: string, orderDetail: OrderDetail): Observable<OrderDetail> {
    return this.http.put<OrderDetail>(`${this.apiUrl}/${orderDetailId}`, JSON.stringify(orderDetail), this.httpOptions);
  }

  /** DELETE - Eliminar un OrderDetail por ID */
  deleteOrderDetail(orderDetailId: string): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${orderDetailId}`);
  }

  /** DELETE - Eliminar todos los detalles de una orden */
  deleteAllOrderDetailsByOrderId(orderId: string): Observable<any> {
    return this.http.delete(`${this.apiUrl}/order/${orderId}`);
  }
}
