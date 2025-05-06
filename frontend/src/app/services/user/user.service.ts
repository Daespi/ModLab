import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../../models/User/User';
import { environment } from '../../../environments/environment';

const baseUrl = environment.apiUrl; // Usar la URL del entorno

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient ) {}

  getById(id: string): Observable<User> {
    return this.http.get<User>(`${baseUrl}/${id}`);
  }

  newUser(user: User): Observable<User> {
    return this.http.post<User>(baseUrl, user);
  }

  updateUser(user: User): Observable<User> {
    return this.http.put<User>(`${baseUrl}/${user.userId}`, user); // Corregido para incluir el id
  }

  deleteById(id: string): Observable<void> {
    return this.http.delete<void>(`${baseUrl}/${id}`);
  }

  login(email: string, password: string): Observable<any> {
    const credentials = { email, password };
    return this.http.post<any>(`${baseUrl}/login`, credentials);
  }

  getUserByEmail(email: string): Observable<User> {
    return this.http.get<User>(`${baseUrl}/email/${email}`);
  }
  
  


}
