import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true, // Este es el indicador de un componente standalone
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  email: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private router: Router, private authService: AuthService) {}

  ngOnInit(): void {
    // Inicialización si es necesario
  }

  onSubmit(): void {
    this.authService.login(this.email, this.password).subscribe({
        next: (token) => {  // <-- Ahora recibe el token directamente
            if (token) {  
                this.router.navigate(['/home']); // Redirige al usuario
            } else {
                this.errorMessage = 'Error: No se recibió token del servidor.';
            }
        },
        error: (error) => {
            console.error('Login fallido', error);
            this.errorMessage = 'Credenciales incorrectas';
        }
    });
}


}
