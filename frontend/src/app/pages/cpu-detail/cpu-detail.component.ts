import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CPUService } from '../../services/cpus/cpu.service';
import { CPU } from '../../models/Cpu/Cpu';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ReviewService } from '../../services/review/review.service';
import { Review } from '../../models/review/review';
import { ShopCartService } from '../../services/shopCart/shopCart.service';
import { ShopCart } from '../../models/ShopCart/ShopCart';
import { UserService } from '../../services/user/user.service';

@Component({
  selector: 'app-cpu-detail',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './cpu-detail.component.html',
  styleUrls: ['./cpu-detail.component.css']
})
export class CpuDetailComponent implements OnInit {
  cpu: CPU | undefined;
  reviews: Review[] = [];
  reviewAuthors: { [reviewId: number]: string } = {};  // clave: id de review, valor: username


  newRating: number = 5;
  newComment: string = '';

  quantity: number = 1;
  userId: string = '';


  

  constructor(
    private route: ActivatedRoute,
    private cpuService: CPUService,
    private reviewService: ReviewService,
    private shopCartService: ShopCartService,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.userId = localStorage.getItem('userId') || '';

    const id = this.route.snapshot.paramMap.get('id');

    if (id !== null) {
      this.cpuService.getCPUById(id).subscribe({
        next: (data: CPU) => {
          this.cpu = data;
          this.loadReviews();
        },
        error: (err) => {
          console.error('Error al obtener la CPU:', err);
        }
      });
    } else {
      console.error('ID inválido o no encontrado en la ruta');
    }
  }

  get fullStars(): any[] {
    const rating = this.cpu?.rating ?? 0;
    return new Array(Math.floor(rating));
  }

  get hasHalfStar(): boolean {
    const rating = this.cpu?.rating ?? 0;
    const decimalPart = rating % 1;
    return decimalPart >= 0.25 && decimalPart < 0.75;
  }

  get emptyStars(): any[] {
    const rating = this.cpu?.rating ?? 0;
    const full = Math.floor(rating);
    const half = this.hasHalfStar ? 1 : 0;
    return new Array(5 - full - half);
  }

  loadReviews() {
    if (!this.cpu?.productId) return;
    this.reviewService.getReviewsByProductId(this.cpu.productId).subscribe({
      next: (reviews) => {
        this.reviews = reviews;
        
        for (const review of reviews) {
          if (review.userId) {
            this.userService.getById(review.userId).subscribe({
              next: (user) => {
                this.reviewAuthors[review.reviewId] = user.username ?? 'Usuario desconocido';
              },
              error: (err) => {
                console.error('Error al obtener usuario', err);
                this.reviewAuthors[review.reviewId] = 'Usuario desconocido';
              }
            });
          } else {
            this.reviewAuthors[review.reviewId] = 'Usuario desconocido';
          }
        }
        
      },
      error: (err) => {
        console.error('Error al cargar reviews:', err);
      }
    });
  }

  submitReview() {
    if (!this.cpu?.productId) return;

    if (this.newRating < 1 || this.newRating > 5 || !this.newComment.trim()) {
      alert('Introduce un comentario válido y una puntuación entre 1 y 5.');
      return;
    }

    const reviewToSend: Partial<Review> = {
//      userId: this.userId,"531379e5-be0a-490d-a4f7-710665b73d28", 
      userId: this.userId!,        // Incluye el ID del usuario
      productId: this.cpu.productId,
      rating: this.newRating,
      comment: this.newComment.trim(),
    };
    

    this.reviewService.addReview(reviewToSend).subscribe({
      next: (review) => {
        alert('Comentario añadido con éxito');
        this.newRating = 5;
        this.newComment = '';
        this.loadReviews();
      },
      error: (err) => {
        console.error('Error al añadir review:', err);
        alert('Error al enviar el comentario');
      }
    });
  }

  addToCart() {
    if (!this.cpu) {
      alert('CPU no cargada');
      return;
    }
    if (this.quantity < 1) {
      alert('La cantidad debe ser al menos 1');
      return;
    }

    const cartItem: ShopCart = {
      cartId: 0,
      userId: this.userId,            // CAMBIO AQUÍ: debe ser userId, no userIdFromUser
      productId: this.cpu.productId!,
      quantity: this.quantity
    };
    

    this.shopCartService.addProductToCart(cartItem).subscribe({
      next: () => {
        alert('Producto añadido al carrito');
        this.quantity = 1;
      },
      error: (err: any) => {
        console.error('Error al añadir al carrito:', err);
        alert('Error al añadir al carrito');
      }
    });
  }
}
