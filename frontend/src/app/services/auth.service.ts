import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private isLoggedInSubject = new BehaviorSubject<boolean>(this.hasToken());

  public isLoggedIn$: Observable<boolean> = this.isLoggedInSubject.asObservable();

  private hasToken(): boolean {
    return !!localStorage.getItem('userEmail');
  }

  login(email: string): void {
    localStorage.setItem('userEmail', email);
    this.isLoggedInSubject.next(true);
  }

  logout(): void {
    localStorage.removeItem('userEmail');
    this.isLoggedInSubject.next(false);
  }

  getUserEmail(): string | null {
    return localStorage.getItem('userEmail');
  }

  isLoggedIn(): boolean {
    return this.isLoggedInSubject.value;
  }
}
