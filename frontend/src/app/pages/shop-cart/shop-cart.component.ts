import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ShopCartService } from '../../services/shopCart/shopCart.service';
import { CPUService } from '../../services/cpus/cpu.service';
import { ShopCart } from '../../models/ShopCart/ShopCart';
import { CPU } from '../../models/Cpu/Cpu';
import { forkJoin } from 'rxjs';
import { UserService } from '../../services/user/user.service';
import { AuthService } from '../../services/auth.service';

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

  cpuDetailsMap: Map<string, CPU> = new Map();  // Mapa productId -> CPU

  constructor(
    private shopCartService: ShopCartService,
    private cpuService: CPUService,
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
        this.loadCPUsDetails(items);
      },
      error: (err: any) => {
        console.error('Error al cargar el carrito:', err);
      }
    });
  }

  private loadCPUsDetails(items: ShopCart[]): void {
    const requests = items
      .map(item => item.productId)
      .filter((id): id is string => !!id) // Filtra productId no undefined
      .map(productId => this.cpuService.getCPUById(productId));

    if (requests.length === 0) return;

    forkJoin(requests).subscribe({
      next: (cpus: CPU[]) => {
        cpus.forEach(cpu => {
          if (cpu.productId) {
            this.cpuDetailsMap.set(cpu.productId, cpu);
          }
        });
      },
      error: (err) => {
        console.error('Error al cargar detalles de CPUs:', err);
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
        this.cpuDetailsMap.clear();
      },
      error: (err: any) => {
        console.error('Error al vaciar el carrito:', err);
      }
    });
  }

  getCPUInfo(productId: string | undefined): CPU | undefined {
    if (!productId) return undefined;
    return this.cpuDetailsMap.get(productId);
  }

  getTotal(): number {
    return this.cartItems.reduce((total, item) => {
      const cpu = this.getCPUInfo(item.productId);
      if (!cpu) return total;
      return total + (cpu.price * item.quantity);
    }, 0);
  }

  purchase(): void {
    console.log('Lógica de compra aún no implementada.');
    // Aquí podrías llamar al servicio que crea una orden, por ejemplo.
  }
}
