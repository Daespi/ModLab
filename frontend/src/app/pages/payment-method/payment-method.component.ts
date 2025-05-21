import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { PaymentService } from '../../services/paymentMethod/paymentMethod.service';
import { PaymentMethod } from '../../models/PaymentMethod/PaymentMethod';
import { AuthService } from '../../services/auth.service';
import { UserService } from '../../services/user/user.service';

@Component({
  selector: 'app-payment-method',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './payment-method.component.html',
  styleUrls: ['./payment-method.component.css']
})
export class PaymentMethodComponent implements OnInit {
  paymentForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private paymentService: PaymentService,
    private authService: AuthService,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    const email = this.authService.getUserEmail();
    if (!email) {
      alert('No se ha encontrado el email del usuario.');
      return;
    }

    this.userService.getUserByEmail(email).subscribe({
      next: (user) => {
        const userId = user.userId;

        // Inicializa el formulario con el userId recuperado
        this.paymentForm = this.fb.group({
          paymentMethod: ['', Validators.required],
          cardNumber: ['', [Validators.required, Validators.minLength(16)]],
          cardExpiry: ['', Validators.required],
          cardCvv: ['', [Validators.required, Validators.minLength(3)]],
          userId: [userId, Validators.required]
        });
      },
      error: (err) => {
        console.error('Error al obtener usuario:', err);
        alert('No se pudo obtener la información del usuario.');
      }
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
