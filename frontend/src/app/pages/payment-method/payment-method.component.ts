
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule, FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { PaymentMethodService } from '../../services/paymentMethod/paymentMethod.service';
import { PaymentMethod } from '../../models/PaymentMethod/PaymentMethod';
import { AuthService } from '../../services/auth.service';
import { UserService } from '../../services/user/user.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-payment-method',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule,FormsModule],
  templateUrl: './payment-method.component.html',
  styleUrls: ['./payment-method.component.css']
})
export class PaymentMethodComponent implements OnInit {
  paymentForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private paymentMethodService: PaymentMethodService,
    private authService: AuthService,
    private userService: UserService,
    private router: Router
  ) {}

  ngOnInit(): void {
    const userId = localStorage.getItem('userId');
    if (!userId) {
      alert('No se ha encontrado el ID del usuario.');
      return;
    }
  
    this.paymentForm = this.fb.group({
      paymentMethod: ['', Validators.required],
      cardNumber: ['', [Validators.required, Validators.minLength(16)]],
      cardHolder: ['', Validators.required],    // <--- Agrega este campo
      cardExpiry: ['', Validators.required],
      cardCvv: ['', [Validators.required, Validators.minLength(3)]],
      userId: [userId, Validators.required]
    });
    
  }
  
  
  submitPayment(): void {
    if (this.paymentForm.invalid) return;
  
    const { paymentMethod, cardNumber, cardExpiry, cardCvv, cardHolder } = this.paymentForm.value;
  
    const userId = localStorage.getItem('userId');
    if (!userId) {
      alert('No se encontró el usuario autenticado');
      return;
    }
  
    const payment: PaymentMethod = {
      paymentMethod,
      cardNumber,
      cardExpiry,
      cardCvv,
      cardHolder,
      userId
    };
  
    this.paymentMethodService.create(payment).subscribe({
      next: () => {
        alert('Pago registrado correctamente.');
        this.paymentForm.reset();
        this.router.navigate(['/user/show-payment']); // <--- Redirección aquí
      },
      error: (err: unknown) => {
        if (err instanceof Error) {
          console.error('Error al agregar el método de pago:', err.message);
        } else {
          console.error('Error desconocido:', err);
        }
        alert('Error al agregar el método de pago.');
      }
    });
  }
  
  
  
  
  
}