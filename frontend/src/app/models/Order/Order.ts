import { OrderDetail } from "../OrderDetail/OrderDetail";

export interface Order {
  orderId: string;
  orderDate: string;       // o Date si prefieres manejarlo como objeto Date
  status: string;
  userId: string;
  paymentId: string;
  addressId: number;
  totalPrice: number;      // <-- agregado totalPrice
}
