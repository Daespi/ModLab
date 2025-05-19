import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { environment } from '../../../environments/environment';
import { PaymentMethod } from '../../models/PaymentMethod/PaymentMethod';

const baseUrl = environment.apiUrlPaymentMethod;

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  constructor(private http: HttpClient) {}

  createPayment(payment: PaymentMethod): Observable<PaymentMethod> {
    return this.http.post<PaymentMethod>(`${baseUrl}/create`, payment);
  }

  getPaymentsByUser(userId: string): Observable<PaymentMethod[]> {
    return this.http.get<PaymentMethod[]>(`${baseUrl}/user/${userId}`);
  }
}
