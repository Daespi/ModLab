import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CpuService } from '../../services/cpu/cpu.service';
import { Cpu } from '../../models/Cpu/Cpu';

@Component({
  selector: 'app-cpu',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cpu.component.html',
  styleUrls: ['./cpu.component.css']
})
export class CpuComponent implements OnInit {
  cpus: Cpu[] = [];
  isLoading = true;
  error: string = '';

  constructor(private cpuService: CpuService) {}

  ngOnInit(): void {
    this.cpuService.getAllCpus().subscribe({
      next: (data) => {
        this.cpus = data;
        this.isLoading = false;
      },
      error: (err) => {
        console.error('Error fetching CPUs:', err);
        this.error = 'Error al cargar las CPUs';
        this.isLoading = false;
      }
    });
  }
}
