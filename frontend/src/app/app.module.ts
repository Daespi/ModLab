import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';  // Importa FormsModule
import { AppRoutingModule } from './app-routing.module';
import { RegisterComponent } from './pages/register/register.component';
import { LoginComponent } from './pages/login/login.component';
import { HomeComponent } from './pages/home/home.component';
import { HeaderComponent } from './pages/header/header.component';
import { FooterComponent } from './pages/footer/footer.component';
import { AddAddressComponent } from './pages/add-address/add-address.component';
import { ShippingAddressComponent } from './pages/shipping-address/shipping-address.component';
import { CpuComponent } from './pages/cpu/cpu.component';
import { CpuDetailComponent } from './pages/cpu-details/cpu-details.component';
import { CpuListComponent } from './pages/cpu-list/cpu-list.component';
import { RouterModule } from '@angular/router'; // 👈 Necesario para routerLink
import { CommonModule } from '@angular/common';
import { PaymentMethodComponent } from './pages/payment-method/payment-method.component';



@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    ShippingAddressComponent,
    AddAddressComponent,
    CpuComponent,
    CpuDetailComponent,
    CpuListComponent,
    PaymentMethodComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    CommonModule
 // <-- ¡Aquí!
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

