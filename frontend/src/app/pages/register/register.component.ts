import { Component } from '@angular/core';
import { UserService } from '../../services/user.service';
import { User } from '../../models/User/User';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  user: User = new User(); // Objeto vacío de tipo User
  confirmPassword: string = '';  // Campo solo para confirmar la contraseña

  constructor(private userService: UserService) {}

  onSubmit(): void {
    if (this.user.passwordHash === this.confirmPassword) {
      this.userService.newUser(this.user).subscribe(
        (response) => {
          console.log('Usuario registrado exitosamente', response);
          // Aquí podrías redirigir al usuario o mostrar un mensaje de éxito
        },
        (error) => {
          console.error('Error al registrar el usuario', error);
          // Mostrar un mensaje de error
        }
      );
    } else {
      alert('Las contraseñas no coinciden');
    }
  }
}
