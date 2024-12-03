import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(private router: Router) {}
  email!: string;
  password!: string;

  onSubmit() {
    // Handle the form submission
  }
  navigateToSignup() { this.router.navigate(['/signup']); }
}
