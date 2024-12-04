import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { AuthService } from '../../services/auth/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, ToastModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(private router: Router,private authService: AuthService, private messageService: MessageService) {}
  email!: string;
  password!: string;

  onSubmit() {
    // Handle the form submission
  }
  navigateToSignup() { this.router.navigate(['/signup']); }
}
