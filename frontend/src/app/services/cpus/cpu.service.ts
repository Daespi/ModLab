import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CPU } from '../../models/Cpu/Cpu';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CPUService {
  private apiUrl = 'http://localhost:8080/modlab/CPU'; // Ajusta el puerto si es necesario

  constructor(private http: HttpClient) {}

  // Obtener todas las CPUs
  getAllCPUs(): Observable<CPU[]> {
    return this.http.get<CPU[]>(this.apiUrl);
  }

  // Obtener CPU por ID
  // Obtener CPU por ID
  getCPUById(productId: string): Observable<CPU> {
    return this.http.get<CPU>(`${this.apiUrl}/${productId}`);
  }
  
  
  // Actualizar CPU existente
  updateCPU(productId: number, cpu: CPU): Observable<CPU> {
    return this.http.put<CPU>(`${this.apiUrl}/${productId}`, cpu, {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    });
  }
  
  // Eliminar CPU por ID
  deleteCPU(productId: number): Observable<any> {
    return this.http.delete(`${this.apiUrl}/${productId}`);
  }
}  