import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './pages/register/register.component';
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { AddAddressComponent } from './pages/add-address/add-address.component';
import { ShippingAddressComponent } from './pages/shipping-address/shipping-address.component';
import { CpuComponent } from './pages/cpu/cpu.component';
import { CpuListComponent } from './pages/cpu-list/cpu-list.component';
import { CpuDetailComponent } from './pages/cpu-details/cpu-details.component';
import { PaymentMethodComponent } from './pages/payment-method/payment-method.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'address/add', component: AddAddressComponent },
  { path: 'address', component: ShippingAddressComponent },
  { path: 'cpu', component: CpuComponent },
  { path: 'cpus', component: CpuListComponent },
  { path: 'cpus/:id', component: CpuDetailComponent },
  { path: 'paymentmethod', component: PaymentMethodComponent }, // otras rutas...
  // otras rutas...
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
