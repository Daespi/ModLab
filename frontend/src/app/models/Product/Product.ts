// product.model.ts
export interface Product {
    productId: string;
    name: string;
    description: string;
    price: number;
    stockQuantity: number;
    rating: number;
    imageUrl: string[]; // en backend es Set<String>, aquí lo usas array
    brand: string;
    // No incluyo reviews aquí para simplificar, pero podrías tenerlo también
  }
  