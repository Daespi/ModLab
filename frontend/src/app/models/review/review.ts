export interface Review {
  reviewId: number;
  productId: string;    // si usas productId para relacionar la review
  rating: number;       // valor entero de 1 a 5
  comment: string;      // texto del comentario
  reviewDate: string;   // fecha en formato 'dd-MM-yyyy HH:mm:ss' (o ISO si prefieres)
  userId?: string;      // ID del usuario que envía la review (opcional)
}
