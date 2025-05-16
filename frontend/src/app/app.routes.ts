import { Routes } from '@angular/router';
import { RegisterComponent } from './pages/register/register.component';
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { AddAddressComponent } from './pages/add-address/add-address.component';
import { ShippingAddressComponent } from './pages/shipping-address/shipping-address.component';
import { CpuComponent } from './pages/cpu/cpu.component';
import { CpuListComponent } from './pages/cpu-list/cpu-list.component';
import { CpuDetailComponent } from './pages/cpu-details/cpu-details.component';
import { ShopCartComponent } from './pages/shop-cart/shop-cart.component';

export const routes: Routes = [
    { path: 'register', component: RegisterComponent},
    { path: 'login', component: LoginComponent},
    { path: 'home', component: HomeComponent},
    { path: 'address', component: ShippingAddressComponent},
    { path: 'address/add', component: AddAddressComponent},
    { path: 'cpu', component: CpuComponent },
    { path: 'cpus', component: CpuListComponent },
    { path: 'cpus/:id', component: CpuDetailComponent },
    { path: 'shopcart', component: ShopCartComponent }

];
