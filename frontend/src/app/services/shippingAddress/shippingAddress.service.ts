import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';
import { ShippingAddress } from '../../models/ShippingAddress/ShippingAddress';

const baseUrl = environment.apiUrlShippingAddress;

@Injectable({
  providedIn: 'root'
})
export class ShippingAddressService {

  constructor(private http: HttpClient) {}

  getById(addressId: number): Observable<ShippingAddress> {
    return this.http.get<ShippingAddress>(`${baseUrl}/${addressId}`);
  }

  newAddress(address: ShippingAddress): Observable<ShippingAddress> {
    return this.http.post<ShippingAddress>(
      environment.apiUrlShippingAddress,
      address,
      { withCredentials: true }
    );
  }
  

  updateAddress(addressId: number, address: ShippingAddress): Observable<ShippingAddress> {
    return this.http.put<ShippingAddress>(`${baseUrl}/${addressId}`, address);
  }

  deleteById(addressId: number): Observable<void> {
    return this.http.delete<void>(`${baseUrl}/${addressId}`);
  }
}
