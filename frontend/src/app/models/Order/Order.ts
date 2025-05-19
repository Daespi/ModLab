import { Product } from "../Product/Product";

export interface Order {
    orderId: string;
    orderDate: string;          // para simplificar usar string, o Date si parseas bien
    status: string;
    userId: string;
    paymentId: string;
    products: Product[];        // lista de productos en la orden
  }