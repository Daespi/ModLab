export interface PaymentMethod {
  paymentId?: string;
  paymentMethod: string;
  cardNumber: string;
  cardExpiry: string;
  cardCvv: string;
  userId: string;
}