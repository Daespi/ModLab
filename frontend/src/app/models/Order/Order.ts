import { OrderDetail } from "../OrderDetail/OrderDetail";

export interface Order {
  orderId: string;
  orderDate: string;       // o Date si lo manejas como objeto
  status: string;
  userId: string;
  paymentId: string;
  addressId: number;
  orderDetails: OrderDetail[]; // ahora usa los detalles en lugar de products
}
