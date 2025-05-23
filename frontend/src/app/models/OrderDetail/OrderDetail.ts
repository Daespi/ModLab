// src/app/models/OrderDetail/OrderDetail.ts
export interface OrderDetail {
  orderDetailId?: string; // Opcional, ya que se genera en backend
  orderId: string;
  productId: string;
  quantity: number;
  price: number;

  // Método adicional si necesitas calcularlo en el cliente:
  getSubtotal?: () => number;
}
