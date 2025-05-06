import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user/user.service';
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

  constructor(private userService: UserService, private router: Router, private authService: AuthService ) {}

  ngOnInit(): void {
    // Inicialización si es necesario
  }

  onSubmit(): void {
    // Llamar al servicio de login
    this.userService.login(this.email, this.password).subscribe({
      next: (response) => {
        console.log(response.message);
        
        // Al hacer login, actualizamos el estado en AuthService
        this.authService.login(this.email);  // Esto guarda el email en el localStorage
        
        // Redirigir al usuario a la página de inicio
        this.router.navigate(['/home']);
      },
      error: (error) => {
        console.error('Login fallido', error);
        this.errorMessage = 'Credenciales incorrectas';
      }
    });
  }
}
