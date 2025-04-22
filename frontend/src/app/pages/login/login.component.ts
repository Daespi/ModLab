import { Component, OnInit } from '@angular/core';
import { User } from '../../models/User/User';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'] // estaba mal escrito: era `styleUrl` → debe ser `styleUrls`
})
export class LoginComponent implements OnInit {

  user?: User;

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.userService.getById('id').subscribe({
      next: (value) => {
        this.user = value;
        console.log(value);
      },
      error: (error) => console.error(error)
    });
  }
}
