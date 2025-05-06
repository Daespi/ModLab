import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { Location } from '@angular/common';
import { CommonModule } from '@angular/common'; // Necesario para ngIf
import { AuthService } from '../../services/auth.service'; // Asegúrate que la ruta sea correcta
import { UserService } from '../../services/user/user.service'; // Importa el servicio UserService
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  currentRoute: string = '';
  isLoggedIn$: any;
  username$: any;
  userEmail$: any;
  userData: any;

  constructor(
    private router: Router,
    private location: Location,
    private authService: AuthService, // Inyectar el servicio de autenticación
    private userService: UserService // Inyectar el servicio de usuario
  ) {}

  ngOnInit(): void {
    // Inicializar los observables después de que el componente se haya inicializado
    this.isLoggedIn$ = this.authService.isLoggedIn$;
    this.userEmail$ = this.authService.isLoggedIn$.pipe(
      map(loggedIn => loggedIn ? this.authService.getUserEmail() : null)
    );
  
    // Obtener los detalles del usuario cuando esté logueado
    this.isLoggedIn$.subscribe((loggedIn: boolean) => {
      if (loggedIn) {
        const email = this.authService.getUserEmail();

        if (email) {
          this.userService.getUserByEmail(email).subscribe(user => {
            this.userData = user;
            this.username$ = user.username; // O cualquier campo que necesites
          });
        }
      }
    });
  
    // Detectar la ruta actual cada vez que la navegación cambia
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.currentRoute = event.url;
      }
    });
  }
  
  

  isLoginOrRegister() {
    return this.currentRoute === '/login' || this.currentRoute === '/register';
  }

  goBack() {
    this.location.back();
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/home']);
  }
}
