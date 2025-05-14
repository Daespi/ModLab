// src/app/pages/cpu/cpu-detail.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CpuService } from '../../services/cpu/cpu.service';
import { Cpu } from '../../models/Cpu/Cpu';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cpu-details',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cpu-details.component.html'
})
export class CpuDetailComponent implements OnInit {
  cpu: Cpu | null = null;
  isLoading = true;
  error: string | null = null;

  constructor(
    private route: ActivatedRoute,
    private cpuService: CpuService
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.cpuService.getCpuById(id).subscribe({
      next: (data) => {
        console.log('CPU cargada:', data);
        this.cpu = data;
        this.isLoading = false;
      },
      error: () => {
        this.error = 'No se pudo cargar la CPU';
        this.isLoading = false;
      }
    });
  }
}
