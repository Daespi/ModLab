import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cpu } from '../../models/Cpu/Cpu';
import { environment } from '../../../environments/environment';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CpuService {
  private baseUrl = environment.apiUrlCpu;

  constructor(private http: HttpClient) {}

  getAllCpus(): Observable<Cpu[]> {
    console.log('Llamando a la API de CPUs...');
    // const headers = { Authorization: `Bearer ${token}` };
    return this.http.get<Cpu[]>(this.baseUrl).pipe(
      catchError(error => {
        console.error('Error fetching CPUs', error);
        return of([]);
      })
    );
  }

  getCpuById(id: number): Observable<Cpu | null> {
    return this.http.get<Cpu>(`${this.baseUrl}/${id}`).pipe(
      catchError(error => {
        console.error(`Error fetching CPU with id ${id}`, error);
        return of(null); // Retorna null en caso de error
      })
    );
  }


}
