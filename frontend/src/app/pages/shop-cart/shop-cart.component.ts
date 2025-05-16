import { Component, OnInit } from '@angular/core';
import { ShopCart } from '../../models/ShopCart/ShopCart';
import { ShopCartService } from '../../services/shopCart/shopCart.service';


@Component({
  selector: 'app-shop-cart',
  templateUrl: './shop-cart.component.html',
  styleUrls: ['./shop-cart.component.css']
})
export class ShopCartComponent implements OnInit {
  cartItems: ShopCart[] = [];
  userId = 'usuario-demo';

  constructor(private cartService: ShopCartService) {}

  ngOnInit(): void {
    this.loadCart();
  }

  loadCart(): void {
    this.cartService.getCartByUser(this.userId).subscribe((items: ShopCart[]) => {
      this.cartItems = items;
    });
  }

  removeItem(cartId: number): void {
    this.cartService.removeFromCart(cartId).subscribe(() => {
      this.cartItems = this.cartItems.filter(item => item.cartId !== cartId);
    });
  }

  getTotal(): number {
    return this.cartItems.reduce((sum, item) => sum + item.quantity * 10, 0); // Reemplaza 10 con precio real si lo tienes
  }
}
