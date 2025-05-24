import { Component, OnInit } from '@angular/core';
import { ShopCartService } from '../../services/shopCart/shopCart.service';
import { PaymentMethodService } from '../../services/paymentMethod/paymentMethod.service';
import { ProductService } from '../../services/product/product.service';
import { OrderService } from '../../services/order/order.service';
import { ShopCart } from '../../models/ShopCart/ShopCart';
import { PaymentMethod } from '../../models/PaymentMethod/PaymentMethod';
import { Order } from '../../models/Order/Order';
import { Router } from '@angular/router';
import { Product } from '../../models/Product/Product';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common'; 
import { forkJoin } from 'rxjs';
import { OrderDetailService } from '../../services/orderDetail/orderDetail.service';

@Component({
  selector: 'app-order-summary',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './order-summary.component.html',
  styleUrls: ['./order-summary.component.css']
})
export class OrderSummaryComponent implements OnInit {

  userId: string | null = null;
  cartItems: (ShopCart & { product?: Product })[] = [];
  paymentMethod: PaymentMethod | null = null;
  address: any = null;
  totalPrice: number = 0;
  loading: boolean = true;
  errorMessage: string | null = null;

  constructor(
    private shopCartService: ShopCartService,
    private paymentMethodService: PaymentMethodService,
    private productService: ProductService,
    private orderService: OrderService,
    private orderDetailService: OrderDetailService,
    private router: Router
  ) { }

  async ngOnInit(): Promise<void> {
    this.userId = localStorage.getItem('userId');

    if (!this.userId) {
      this.errorMessage = 'Usuario no autenticado.';
      this.loading = false;
      return;
    }

    const addressJson = localStorage.getItem('selectedAddress');
    if (addressJson) {
      this.address = JSON.parse(addressJson);
    } else {
      this.errorMessage = 'No se ha seleccionado ninguna dirección.';
      this.loading = false;
      return;
    }

    const paymentJson = localStorage.getItem('selectedPayment');
    if (!paymentJson) {
      this.errorMessage = 'No se ha seleccionado método de pago.';
      this.loading = false;
      return;
    }

    try {
      const cart = await this.shopCartService.getCartByUser(this.userId).toPromise();
      const payment = JSON.parse(paymentJson);

      if (!cart) {
        this.errorMessage = 'No se pudo cargar el carrito.';
        this.loading = false;
        return;
      }

      this.paymentMethod = payment;

      // Enriquecer carrito con productos
      const enrichedCart = await Promise.all(cart.map(async item => {
        const product = await this.productService.getProductById(item.productId).toPromise();
        return {
          ...item,
          product: product ?? undefined
        };
      }));

      this.cartItems = enrichedCart;

      this.totalPrice = this.cartItems.reduce((acc, item) =>
        acc + ((item.product?.price ?? 0) * item.quantity), 0);

      this.loading = false;
    } catch (error: any) {
      this.errorMessage = 'Error al cargar datos: ' + (error.message || error);
      this.loading = false;
    }
  }

  confirmOrder(): void {
    if (!this.userId || !this.paymentMethod || !this.address || this.cartItems.length === 0) {
      this.errorMessage = 'Faltan datos para realizar el pedido.';
      return;
    }
  
    const newOrder: Order = {
      orderId: '',
      orderDate: new Date().toISOString(),
      status: 'PENDING',
      userId: this.userId,
      paymentId: this.paymentMethod.paymentId!,
      addressId: this.address.addressId,
      totalPrice: this.totalPrice   // <-- aquí añades el totalPrice
    };
  
    this.orderService.addOrder(newOrder).subscribe({
      next: (createdOrder) => {
        const orderId = createdOrder.orderId;
        if (!orderId) {
          this.errorMessage = 'No se pudo obtener el ID del pedido creado.';
          return;
        }
  
        // Crear detalles del pedido
        const createDetails$ = this.cartItems.map(item => {
          const orderDetail = {
            orderDetailId: '',
            orderId: orderId,
            productId: item.productId,
            quantity: item.quantity,
            price: item.product?.price ?? 0
          };
          return this.orderDetailService.create(orderDetail);
        });
  
        forkJoin(createDetails$).subscribe({
          next: () => {
            // Borrar cada item del carrito individualmente
            const deleteItems$ = this.cartItems.map(item => {
              return this.shopCartService.deleteItem(item.cartId);
            });

            forkJoin(deleteItems$).subscribe({
              next: () => {
                alert('Pedido realizado con éxito');
                localStorage.removeItem('selectedAddress');
                localStorage.removeItem('selectedPayment');
                this.router.navigate(['/home']);
              },
              error: (err) => {
                this.errorMessage = 'Error al eliminar los artículos del carrito: ' + err.message;
              }
            });
          },
          error: (err) => {
            this.errorMessage = 'Error al crear los detalles del pedido: ' + err.message;
          }
        });
      },
      error: (err) => {
        this.errorMessage = 'Error al crear la orden: ' + err.message;
      }
    });
  }

}
