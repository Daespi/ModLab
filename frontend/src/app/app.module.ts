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
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
 // <-- ¡Aquí!
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

