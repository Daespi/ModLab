import { Data } from "@angular/router";

export class ShippingAddress {
    addressId?: number;  // Opcional, porque puede ser generado por el backend
    userId!: string;
    address!: string;
    zipCode!: string;
    city!: string;
    state!: string;
    country!: string;
}