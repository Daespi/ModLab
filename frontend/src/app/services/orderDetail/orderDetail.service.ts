import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { OrderDetail } from '../../models/OrderDetail/OrderDetail';
import { environment } from '../../../environments/environment';


const baseUrl = environment.apiUrlOrderDetail;


@Injectable({
  providedIn: 'root'
})
export class OrderDetailService {
   // Ajusta según backend

  constructor(private http: HttpClient) {}

  createOrderDetail(detail: OrderDetail): Observable<OrderDetail> {
    return this.http.post<OrderDetail>(`${baseUrl}/create`, detail);
  }

  getOrderDetailsByOrderId(orderId: string): Observable<OrderDetail[]> {
    return this.http.get<OrderDetail[]>(`${baseUrl}/order/${orderId}`);
  }
}
