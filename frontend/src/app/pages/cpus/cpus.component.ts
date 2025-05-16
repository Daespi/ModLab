import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CPUService } from '../../services/cpus/cpu.service';
import { CPU } from '../../models/Cpu/Cpu';

@Component({
  selector: 'app-cpus',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cpus.component.html',
  styleUrl: './cpus.component.css'
})
export class CpusComponent implements OnInit {
  cpus: CPU[] = [];
  errorMessage: string = '';

  constructor(private cpuService: CPUService) {}

  ngOnInit(): void {
    this.cpuService.getAllCPUs().subscribe({
      next: (data: CPU[]) => {
        this.cpus = data;
      },
      error: (err: any) => {
        this.errorMessage = 'Error al obtener las CPUs';
        console.error(err);
      }
    });
  }
}
