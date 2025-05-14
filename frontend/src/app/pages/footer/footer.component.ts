import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { NavigationEnd, Router } from '@angular/router';
import { Location } from '@angular/common';


@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.css'
})
export class FooterComponent {
  currentRoute: string = '';

  constructor(private router: Router, private location: Location) {
    // Detectar la ruta actual cada vez que la navegación cambia
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.currentRoute = event.url; // Obtiene la ruta actual cuando termina la navegación
      }
    });
  }

}
