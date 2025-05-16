import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ShippingAddressService } from '../../services/shippingAddress/shippingAddress.service';
import { ShippingAddress } from '../../models/ShippingAddress/ShippingAddress';
import { UserService } from '../../services/user/user.service';
import { User } from '../../models/User/User';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-address',
  standalone: true, // Este es el indicador de un componente standalone
  imports: [FormsModule],
  templateUrl: './add-address.component.html',
  styleUrls: ['./add-address.component.css']
})
export class AddAddressComponent implements OnInit {
  userId?: string; // ← ahora es opcional para evitar error de tipo

  constructor(
    private shippingAddressService: ShippingAddressService,
    private userService: UserService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const email = localStorage.getItem('userEmail');
    if (email) {
      this.userService.getUserByEmail(email).subscribe({
        next: (user: User) => {
          this.userId = user.userId;
        },
        error: (err: any) => {
          console.error('Error al obtener el usuario:', err);
        }
      });
    } else {
      console.error('Email no encontrado en localStorage');
    }
  }

  

  onSubmit(addressForm: any): void {
    if (!this.userId) {
      console.error('userId no está definido. No se puede enviar la dirección.');
      return;
    }

    const newAddress: ShippingAddress = {
      userId: this.userId,
      address: addressForm.value.address,
      zipCode: addressForm.value.zipCode,
      city: addressForm.value.city,
      state: addressForm.value.state,
      country: addressForm.value.country
    };

    this.shippingAddressService.newAddress(newAddress).subscribe({
      next: (response: ShippingAddress) => {
        console.log('Dirección añadida correctamente', response);
        this.router.navigate(['/user-profile', this.userId!]); // usamos ! porque ya validamos
      },
      error: (err: any) => {
        console.error('Error adding address', err);
      }
    });
  }
}
