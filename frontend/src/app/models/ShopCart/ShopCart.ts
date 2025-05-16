export interface ShopCart {
  cartId?: number; // autogenerado por la base de datos
  userId: string;
  productId: string;
  quantity: number;
  dateAdded?: Date;
}
