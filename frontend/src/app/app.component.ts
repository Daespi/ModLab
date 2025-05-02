import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './pages/header/header.component';
import { FooterComponent } from './pages/footer/footer.component';

@Component({
  selector: 'app-root',
  standalone: true, // 👈 ¡ESTO FALTA!
  imports: [RouterOutlet, HeaderComponent, FooterComponent], // 👈 Aquí luego metes también el HeaderComponent
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'] // 👈 también tenías mal escrito "styleUrl"
})

export class AppComponent {
  title = 'frontend';
}
