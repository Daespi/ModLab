import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './pages/header/header.component';

@Component({
  selector: 'app-root',
  standalone: true, // 👈 ¡ESTO FALTA!
  imports: [RouterOutlet, HeaderComponent], // 👈 Aquí luego metes también el HeaderComponent
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'] // 👈 también tenías mal escrito "styleUrl"
})

export class AppComponent {
  title = 'frontend';
}
