import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { environment } from '../../../environments/environment';
import { ShippingAddress } from '../../models/ShippingAddress/ShippingAddress';

@Injectable({
  providedIn: 'root'
})
export class ShippingAddressService {

  private apiUrl = environment.apiUrlShippingAddress;

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

  /** Obtener dirección por addressId */
  getById(addressId: number): Observable<ShippingAddress> {
    return this.http.get(`${this.apiUrl}/${addressId}`, {
      responseType: 'text',
      headers: this.createAuthorizationHeader()
    }).pipe(
      map(json => JSON.parse(json))
    );
  }

  getByUserId(userId: string): Observable<ShippingAddress[]> {
    return this.http.get(`${this.apiUrl}/user/${userId}`, {
      responseType: 'text',
      headers: this.createAuthorizationHeader()
    }).pipe(
      map(json => JSON.parse(json) as ShippingAddress[])
    );
  }
  
  

  /** Crear nueva dirección */
  newAddress(address: ShippingAddress): Observable<ShippingAddress> {
    return this.http.post<ShippingAddress>(`${this.apiUrl}/add`, JSON.stringify(address), {
      headers: this.createAuthorizationHeader()
    });
  }

  /** Actualizar dirección por addressId */
  updateAddress(addressId: number, address: ShippingAddress): Observable<ShippingAddress> {
    return this.http.put<ShippingAddress>(`${this.apiUrl}/${addressId}`, JSON.stringify(address), {
      headers: this.createAuthorizationHeader()
    });
  }

  /** Eliminar dirección por addressId */
  deleteById(addressId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${addressId}`, {
      headers: this.createAuthorizationHeader()
    });
  }
}
