import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { PaymentService } from '../../services/paymentMethod/paymentMethod.service';
import { PaymentMethod } from '../../models/PaymentMethod/PaymentMethod';


@Component({
  selector: 'app-payment-method',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './payment-method.component.html',
  styleUrls: ['./payment-method.component.css']
})
export class PaymentMethodComponent {
  paymentForm: FormGroup;

  constructor(private fb: FormBuilder, private paymentService: PaymentService) {
    this.paymentForm = this.fb.group({
      paymentMethod: ['', Validators.required],
      cardNumber: ['', [Validators.required, Validators.minLength(16)]],
      cardExpiry: ['', Validators.required],
      cardCvv: ['', [Validators.required, Validators.minLength(3)]],
      userId: ['usuario-demo', Validators.required]
    });
  }

  submitPayment(): void {
    if (this.paymentForm.invalid) return;

    const payment: PaymentMethod = this.paymentForm.value;

    this.paymentService.createPayment(payment).subscribe({
      next: () => {
        alert('Pago registrado correctamente.');
        this.paymentForm.reset();
      },
      error: (err: unknown) => {
        if (err instanceof Error) {
          console.error('Error al procesar el pago:', err.message);
        } else {
          console.error('Error desconocido:', err);
        }
        alert('Error al procesar el pago.');
      }
    });
  }
}
