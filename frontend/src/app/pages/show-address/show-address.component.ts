import { Component, OnInit } from '@angular/core';
import { ShippingAddressService } from '../../services/shippingAddress/shippingAddress.service';
import { ShippingAddress } from '../../models/ShippingAddress/ShippingAddress';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-address',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './show-address.component.html',
  styleUrls: ['./show-address.component.css']
})
export class ShowAddressComponent implements OnInit {

  addresses: ShippingAddress[] = [];
  loading = false;
  error = '';

  constructor(
    private shippingAddressService: ShippingAddressService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const userId = localStorage.getItem('userId');
    if (!userId) {
      this.error = 'Usuario no autenticado.';
      return;
    }

    this.loading = true;
    this.shippingAddressService.getByUserId(userId).subscribe({
      next: (items: ShippingAddress[]) => {
        this.addresses = items;
        this.loading = false;
      },
      error: () => {
        this.error = 'No se pudieron cargar las direcciones.';
        this.loading = false;
      }
    });
  }

  selectAddress(address: ShippingAddress): void {
    // Guardar en localStorage la dirección seleccionada como JSON string
    localStorage.setItem('selectedAddress', JSON.stringify(address));

    // Navegar a la ruta siguiente (ajusta la ruta según tu necesidad)
    this.router.navigate(['/user/show-payment']);
  }
}
