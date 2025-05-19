import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { CPUService } from '../../services/cpus/cpu.service';
import { CPU } from '../../models/Cpu/Cpu';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-cpus',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './cpus.component.html',
  styleUrl: './cpus.component.css'
})
export class CpusComponent implements OnInit {
  cpus: CPU[] = [];
  filteredCpus: CPU[] = [];
  errorMessage: string = '';

  // Filtros
  filterName: string = '';
  maxPrice: number | null = null;
  minCores: number | null = null;

  constructor(private cpuService: CPUService, private router: Router) {}

  ngOnInit(): void {
    this.cpuService.getAllCPUs().subscribe({
      next: (data: CPU[]) => {
        this.cpus = data;
        this.filteredCpus = [...this.cpus]; // inicializamos con todos
  
        // Comprobamos si hay CPUs sin id ni product_id
        this.filteredCpus.forEach(cpu => {
          if (!cpu.productId && !cpu.productId) {
            console.warn('CPU sin ID:', cpu);
          }
        });
      },
      error: (err: any) => {
        this.errorMessage = 'Error al obtener las CPUs';
        console.error(err);
      }
    });
  }
  

  applyFilters(): void {
    this.filteredCpus = this.cpus.filter(cpu => {
      const nameMatch = cpu.model.toLowerCase().includes(this.filterName.toLowerCase()) || 
                        cpu.brand.toLowerCase().includes(this.filterName.toLowerCase());

      const priceMatch = this.maxPrice === null || (cpu.price !== undefined && cpu.price <= this.maxPrice);

      const coreMatch = this.minCores === null || cpu.processorCore >= this.minCores;

      return nameMatch && priceMatch && coreMatch;
    });
  }

  // En el .ts:
  goToDetail(id: string | undefined): void {
    if (id) {
      this.router.navigate(['/cpus', id]);  // <-- Usar this.router
    } else {
      console.error('ID inválido o indefinido');
    }
  }


  addToCart(cpu: CPU) {
    // Aquí puedes implementar la lógica para añadir al carrito
    console.log('Añadir al carrito:', cpu);
  }

  
}
