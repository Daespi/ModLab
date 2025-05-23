
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { PaymentMethod } from '../../models/PaymentMethod/PaymentMethod';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PaymentMethodService {

  private apiUrl = environment.apiUrlPaymentMethod;

  constructor(private http: HttpClient) {}

  /** 🔐 Obtener token desde localStorage */
  private getToken(): string | null {
    return localStorage.getItem('token');
  }

  /** 🔐 Crear cabeceras con Authorization */
  private createAuthorizationHeader(): HttpHeaders {
    const token = this.getToken();
    return token
      ? new HttpHeaders({
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`
        })
      : new HttpHeaders({ 'Content-Type': 'application/json' });
  }

  /** 🔍 Obtener método de pago por ID */
  getById(paymentId: string): Observable<PaymentMethod> {
    return this.http.get(`${this.apiUrl}/${paymentId}`, {
      responseType: 'text',
      headers: this.createAuthorizationHeader()
    }).pipe(
      map(json => JSON.parse(json))
    );
  }

  /** ➕ Añadir nuevo método de pago */
  create(paymentMethod: PaymentMethod): Observable<PaymentMethod> {
    return this.http.post(`${this.apiUrl}`, JSON.stringify(paymentMethod), {
      responseType: 'text',
      headers: this.createAuthorizationHeader()
    }).pipe(
      map(json => JSON.parse(json))
    );
  }

  /** ✏️ Actualizar método de pago existente */
  update(paymentId: string, paymentMethod: PaymentMethod): Observable<PaymentMethod> {
    return this.http.put(`${this.apiUrl}/${paymentId}`, JSON.stringify(paymentMethod), {
      responseType: 'text',
      headers: this.createAuthorizationHeader()
    }).pipe(
      map(json => JSON.parse(json))
    );
  }

  /** ❌ Eliminar método de pago */
  delete(paymentId: string): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${paymentId}`, {
      headers: this.createAuthorizationHeader(),
      responseType: 'text'
    });
  }

  /** 🔍 Obtener métodos de pago por userId */
getByUserId(userId: string): Observable<PaymentMethod[]> {
    return this.http.get(`${this.apiUrl}/user/${userId}`, {
      responseType: 'text',
      headers: this.createAuthorizationHeader()
    }).pipe(
      map(json => JSON.parse(json) as PaymentMethod[])
    );
  }
  
}
