
import { Data } from "@angular/router";

export interface CPU {
    productId?: string; // ID opcional si lo genera el backend
    name: string;
    description: string;
    price: number;
    stockQuantity: number;
    rating: number;
    brand: string;
    model: string;
    processorCore: number;
    numberThreads: number;
    baseClock: number;
    frecuency: number;
    cacheMemory: string;
    tdp: number;
    socket: string;
    lithography: number;
    hasIntegratedGraphics: boolean;
    width: number;
    high: number;
    length: number;
    weight: number;
    fragile: boolean;
  }

