import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './pages/register/register.component';
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { AddAddressComponent } from './pages/add-address/add-address.component';
import { ShippingAddressComponent } from './pages/shipping-address/shipping-address.component';

import { CpusComponent } from './pages/cpus/cpus.component';
import { CpuDetailComponent } from './pages/cpu-detail/cpu-detail.component';
import { ShopCartComponent } from './pages/shop-cart/shop-cart.component';
import { ShowAddressComponent } from './pages/show-address/show-address.component';
import { PaymentMethodComponent } from './pages/payment-method/payment-method.component';
import { ShowPaymentComponent } from './pages/show-payment/show-payment.component';
import { OrderSummaryComponent } from './pages/order-summary/order-summary.component';


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'address/add', component: AddAddressComponent },

  { path: 'address', component: ShippingAddressComponent },  // otras rutas...
  { path: 'cpus', component: CpusComponent },
  { path: 'cpus/:id', component: CpuDetailComponent },
  { path: 'user/shopcart', component: ShopCartComponent },
  { path: 'user/show-address', component: ShowAddressComponent },
  { path: 'user/payment', component: PaymentMethodComponent },
  { path: 'user/show-payment', component: ShowPaymentComponent },
  { path: 'user/order-summary', component: OrderSummaryComponent },





  // otras rutas...
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
