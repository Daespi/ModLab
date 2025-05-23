import { Component, OnInit } from '@angular/core';
import { PaymentMethodService } from '../../services/paymentMethod/paymentMethod.service';
import { PaymentMethod } from '../../models/PaymentMethod/PaymentMethod';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-payment',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './show-payment.component.html',
  styleUrls: ['./show-payment.component.css']
})
export class ShowPaymentComponent implements OnInit {

  payments: PaymentMethod[] = [];
  loading = false;
  error = '';

  constructor(
    private paymentMethodService: PaymentMethodService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const userId = localStorage.getItem('userId');
    if (!userId) {
      this.error = 'Usuario no autenticado.';
      return;
    }

    this.loading = true;
    this.paymentMethodService.getByUserId(userId).subscribe({
      next: (items: PaymentMethod[]) => {
        this.payments = items;
        this.loading = false;
      },
      error: () => {
        this.error = 'No se pudieron cargar los métodos de pago.';
        this.loading = false;
      }
    });
  }

  selectPayment(payment: PaymentMethod): void {
    localStorage.setItem('selectedPayment', JSON.stringify(payment));
    this.router.navigate(['/user/order-summary']);  // Ajusta la ruta siguiente a donde quieras ir
  }
}
