import { Component } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { Location } from '@angular/common';
import { CommonModule } from '@angular/common'; // Necesario para ngIf

@Component({
  selector: 'app-header',
  standalone: true, // Esto permite que sea un componente independiente
  imports: [CommonModule], // Agregar CommonModule para directivas como *ngIf
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  currentRoute: string = '';

  constructor(private router: Router, private location: Location) {
    // Detectar la ruta actual cada vez que la navegación cambia
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.currentRoute = event.url; // Obtiene la ruta actual cuando termina la navegación
      }
    });
  }

  isLoginOrRegister() {
    return this.currentRoute === '/login' || this.currentRoute === '/register';
  }

  goBack() {
    this.location.back();
  }
}
