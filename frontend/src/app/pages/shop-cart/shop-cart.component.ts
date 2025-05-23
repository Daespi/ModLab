import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ShopCartService } from '../../services/shopCart/shopCart.service';
import { ProductService } from '../../services/product/product.service';
import { ShopCart } from '../../models/ShopCart/ShopCart';
import { CPU } from '../../models/Cpu/Cpu';
import { forkJoin } from 'rxjs';
import { UserService } from '../../services/user/user.service';
import { AuthService } from '../../services/auth.service';
import { Product } from '../../models/Product/Product';

@Component({
  selector: 'app-shop-cart',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './shop-cart.component.html',
  styleUrl: './shop-cart.component.css'
})
export class ShopCartComponent implements OnInit {
  cartItems: ShopCart[] = [];
  userId: string = '';

  productDetailsMap: Map<string, Product> = new Map(); 
  constructor(
    private shopCartService: ShopCartService,
    private productService: ProductService,
    private userService: UserService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {
    const email = this.authService.getUserEmail();
    if (email) {
      this.userService.getUserByEmail(email).subscribe({
        next: (user) => {
          this.userId = user.userId!;
          this.loadCart();
        },
        error: (err) => {
          console.error('Error al obtener usuario por email:', err);
        }
      });
    } else {
      console.warn('No hay usuario logueado');
    }
  }

  loadCart(): void {
    if (!this.userId) return;  // Evitar llamadas sin userId válido
    this.shopCartService.getCartByUser(this.userId).subscribe({
      next: (items: ShopCart[]) => {
        this.cartItems = items;
        this.loadProductsDetails(items);
      },
      error: (err: any) => {
        console.error('Error al cargar el carrito:', err);
      }
    });
  }

  private loadProductsDetails(items: ShopCart[]): void {
    const requests = items
      .map(item => item.productId)
      .filter((id): id is string => !!id) // Filtra productId no undefined
      .map(productId => this.productService.getProductById(productId)); // Cambiado a productService
  
    if (requests.length === 0) return;
  
    forkJoin(requests).subscribe({
      next: (products: Product[]) => {
        products.forEach(product => {
          if (product.productId) {
            this.productDetailsMap.set(product.productId, product);
          }
        });
      },
      error: (err) => {
        console.error('Error al cargar detalles de productos:', err);
      }
    });
  }

  removeFromCart(cartId: number): void {
    this.shopCartService.deleteItem(cartId).subscribe({
      next: () => {
        this.cartItems = this.cartItems.filter(item => item.cartId !== cartId);
      },
      error: (err: any) => {
        console.error('Error al eliminar el producto del carrito:', err);
      }
    });
  }

  clearCart(): void {
    this.shopCartService.clearUserCart(this.userId).subscribe({
      next: () => {
        this.cartItems = [];
        this.productDetailsMap.clear();
      },
      error: (err: any) => {
        console.error('Error al vaciar el carrito:', err);
      }
    });
  }

  getProductInfo(productId: string | undefined): Product | undefined {
    if (!productId) return undefined;
    return this.productDetailsMap.get(productId);
  }
  

  getTotal(): number {
    return this.cartItems.reduce((total, item) => {
      const cpu = this.getProductInfo(item.productId);
      if (!cpu) return total;
      return total + (cpu.price * item.quantity);
    }, 0);
  }

  purchase(): void {
    console.log('Lógica de compra aún no implementada.');
    // Aquí podrías llamar al servicio que crea una orden, por ejemplo.
  }
}
