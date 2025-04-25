import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/User/User';


const baseUrl = 'http';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient ) {}

    getDTO(id: String): Observable<User>{
        return this.http.get(`${baseUrl}/{id}`);
    };

    findById(id: String): Observable<User>{
        return this.http.get(`${baseUrl}/{id}`);
    };

    getById(id: String): Observable<User>{
        return this.http.get(`${baseUrl}/{id}`);
    };

    checkInputData(json: String): Observable<User>{
        return this.http.get(`${baseUrl}`);
    };

    newUser(json: String): Observable<User>{
        return this.http.post(`${baseUrl}`);
    };








}
