
// src/app/models/PaymentMethod/payment-method.ts

export interface PaymentMethod {
    paymentId?: string;       // Opcional porque será generado en backend
    paymentMethod: string;
    cardNumber: string;
    cardExpiry: string;
    cardCvv: string;
    userId: string;
    cardHolder: string;
  }

