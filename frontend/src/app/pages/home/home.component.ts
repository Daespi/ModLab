import { Component, OnInit } from '@angular/core';
import { CPU } from '../../models/Cpu/Cpu';
import { CPUService } from '../../services/cpus/cpu.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';



@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent implements OnInit {
  cpus: CPU[] = [];
  filteredCpus: CPU[] = [];
  errorMessage: string = '';

  featuredCPUs: CPU[] = [];

  slides = [
    'https://via.placeholder.com/600x300/FF5733/ffffff?text=Slide+1',
    'https://via.placeholder.com/600x300/33C1FF/ffffff?text=Slide+2',
    '../../../assets/img/Logo-ModLab.svg'
  ];

  currentIndex = 0;
  startX: number | null = null;
  transformStyle = 'translateX(0%)';

  constructor(private cpuService: CPUService, private router: Router) {}

  startDrag(event: MouseEvent | TouchEvent) {
    const clientX = event instanceof TouchEvent ? event.touches[0].clientX : event.clientX;
    this.startX = clientX;
  }

  endDrag(event: MouseEvent | TouchEvent) {
    if (this.startX === null) return;

    const clientX = event instanceof TouchEvent ? event.changedTouches[0].clientX : event.clientX;
    const deltaX = clientX - this.startX;

    if (deltaX > 50) {
      this.prevSlide();
    } else if (deltaX < -50) {
      this.nextSlide();
    }

    this.startX = null;
  }

  onDrag(event: MouseEvent | TouchEvent) {
    // Opcional: puedes implementar vista previa del drag aquí
  }

  nextSlide() {
    if (this.currentIndex < this.slides.length - 1) {
      this.currentIndex++;
    }
    this.updateTransform();
  }

  prevSlide() {
    if (this.currentIndex > 0) {
      this.currentIndex--;
    }
    this.updateTransform();
  }

  goToSlide(index: number) {
    this.currentIndex = index;
    this.updateTransform();
  }

  updateTransform() {
    this.transformStyle = `translateX(-${this.currentIndex * 100}%)`;
  }

  ngOnInit(): void {
    this.cpuService.getAllCPUs().subscribe({
      next: (data: CPU[]) => {
        // Asignamos las primeras 4 como destacadas
        this.featuredCPUs = data.slice(0, 4);

        // Asignamos todas a cpus y filteredCpus
        this.cpus = data;
        this.filteredCpus = [...this.cpus];

        // Chequeo CPUs sin id ni productId
        this.filteredCpus.forEach(cpu => {
          if (!cpu.productId) {
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
