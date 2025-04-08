import { Data } from "@angular/router";

export class User{
    userId?: string;
    username?: string;
    firstName?: string;
    lastName?: string;
    passwordHash?: string;
    email?: string;
    phone?: string;
    createdAt?: Date;
    roleName?: boolean;
    shippingAddresses?: String[];
}