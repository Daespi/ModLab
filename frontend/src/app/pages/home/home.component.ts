import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  slides = [
    'https://via.placeholder.com/600x300/FF5733/ffffff?text=Slide+1',
    'https://via.placeholder.com/600x300/33C1FF/ffffff?text=Slide+2',
    '../../../assets/img/Logo-ModLab.svg'
  ];

  currentIndex = 0;
  startX: number | null = null;
  transformStyle = 'translateX(0%)';

  startDrag(event: MouseEvent | TouchEvent) {
    const clientX = (event instanceof TouchEvent) ? event.touches[0].clientX : event.clientX;
    this.startX = clientX;
  }

  endDrag(event: MouseEvent | TouchEvent) {
    if (this.startX === null) return;

    const clientX = (event instanceof TouchEvent) ? event.changedTouches[0].clientX : event.clientX;
    const deltaX = clientX - this.startX;

    if (deltaX > 50) {
      this.prevSlide();
    } else if (deltaX < -50) {
      this.nextSlide();
    }

    this.startX = null;
  }

  onDrag(event: MouseEvent | TouchEvent) {
    // Opcional: podrías mostrar una preview del movimiento, pero aquí no lo hacemos para que sea simple
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
}
