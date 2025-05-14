import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CpuService } from '../../services/cpu/cpu.service';
import { Cpu } from '../../models/Cpu/Cpu';

@Component({
  selector: 'app-cpu',
  standalone: true, // important!
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
      error: () => {
        this.error = 'Failed to load CPUs';
        this.isLoading = false;
      }
    });
  }
}
