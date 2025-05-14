import { Data } from "@angular/router";

export class User {
    userId?: string;
    username?: string;
    firstName?: string;
    lastName?: string;
    passwordHash?: string; // Mejor que passwordHash en frontend
    email?: string;
    phone?: string;
    createdAt?: Date;
    roleName?: string;
    shippingAddresses?: string[];
}
