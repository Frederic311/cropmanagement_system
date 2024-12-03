import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  constructor(private router: Router) {}
  name!: string;
  email!: string;
  password!: string;

  onSubmit() {
    // Handle the form submission
  }

  navigateToLogin() { this.router.navigate(['/login']); }
}
