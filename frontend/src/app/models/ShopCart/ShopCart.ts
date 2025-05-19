export interface ShopCart {
    cartId: number;            // id del carrito o línea de carrito
    userId: string;    // usuario dueño del carrito
    productId: string;         // id del producto
    quantity: number;          // cantidad en el carrito
  }