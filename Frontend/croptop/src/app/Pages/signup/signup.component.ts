import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { ToastModule } from 'primeng/toast';
import { AuthService } from '../../services/auth/auth.service';


@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [FormsModule, ToastModule],
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
  providers: [ MessageService]
})
export class SignupComponent {
  name!: string;
  email!: string;
  password!: string;

  constructor(private router: Router, private authService: AuthService, private messageService: MessageService) {}

  onSubmit() {
    const userDTO = {
      fullName: this.name,
      email: this.email,
      password: this.password,
      role: 'farmer'
    };

    this.authService.saveUser(userDTO).subscribe(
      response => {
        this.messageService.add({ severity: 'success', summary: 'Success', detail: 'User registered successfully!' });
        this.router.navigate(['/login']);
      },
      error => {
        this.messageService.add({ severity: 'error', summary: 'Error', detail: 'Error registering user: ' + error.message });
      }
    );
  }

  navigateToLogin() {
    this.router.navigate(['/login']);
  }
}
