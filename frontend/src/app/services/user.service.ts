import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/User/User';

const baseUrl = 'http://localhost:8080/api/users'; // ajusta según tu backend

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
    return this.http.put<User>(baseUrl, user);
  }

  deleteById(id: string): Observable<void> {
    return this.http.delete<void>(`${baseUrl}/${id}`);
  }

  
}
