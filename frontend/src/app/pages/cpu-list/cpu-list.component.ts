// src/app/pages/cpu/cpu-list.component.ts
import { Component, OnInit } from '@angular/core';
import { CpuService } from '../../services/cpu/cpu.service';
import { Cpu } from '../../models/Cpu/Cpu';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cpu-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cpu-list.component.html',
})
export class CpuListComponent implements OnInit {
  cpus: Cpu[] = [];
  isLoading = true;
  error: string | null = null;

  constructor(private cpuService: CpuService) {}

  ngOnInit(): void {
    this.cpuService.getAllCpus().subscribe({
      next: (data: Cpu[]) => {
        console.log('CPUs recibidas:', data);
        this.cpus = data;
        this.isLoading = false;
      },
      error: (error: any) => {
        console.error(error);
        this.error = 'Error al cargar CPUs';
        this.isLoading = false;
      }
    });
  }
}

