import { Component } from '@angular/core';
import { UserService } from '../../services/user/user.service';
import { User } from '../../models/User/User';
import { Router } from '@angular/router';  // Asegúrate de tener el Router importado
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  standalone: true, // Este es el indicador de un componente standalone
  imports: [FormsModule],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  user: User = new User(); // Aquí no necesitas asignar el `userId`
  confirmPassword: string = '';

  constructor(private userService: UserService, private router: Router) {}

  onSubmit(): void {
    if (this.user.passwordHash && this.user.passwordHash === this.confirmPassword) {
      // Creamos un objeto solo con los datos necesarios para el POST
      const userToSend = {
        "userId": this.user.userId,
        username: this.user.username,
        firstName: this.user.firstName,
        lastName: this.user.lastName,
        passwordHash: this.user.passwordHash,
        email: this.user.email,
        phone: this.user.phone,
        "0": this.user.roleName, // Si es necesario
      };

      // Enviar solo los datos necesarios al backend
      this.userService.newUser(userToSend).subscribe(
        (response) => {
          console.log('Usuario registrado exitosamente', response);
          // Redirige a la página de login después de un registro exitoso
          this.router.navigate(['/login']);
        },
        (error) => {
          console.error('Error al registrar el usuario', error);
        }
      );
    } else {
      alert('Las contraseñas no coinciden');
    }
  }
}

