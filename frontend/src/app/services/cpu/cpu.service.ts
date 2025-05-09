// cpu.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cpu } from '../../models/Cpu/Cpu';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CpuService {
  private baseUrl = environment.apiUrlCpu;

  constructor(private http: HttpClient) {}


  getAllCpus(): Observable<Cpu[]> {
    return this.http.get<Cpu[]>(this.baseUrl);
  }

  getCpuById(id: number): Observable<Cpu> {
    return this.http.get<Cpu>(`${this.baseUrl}/${id}`);
  }
}
