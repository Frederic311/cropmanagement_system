import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { environment } from '../../environments/environment';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  // private apiUrl = environment.apiUrl;
  private base_url= 'http://13.87.131.41/api';

  constructor(private http: HttpClient, private router: Router) { }

  private createAuthorizationHeader(token: string): HttpHeaders {
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    });
  }

  login(authRequest: { email: string, password: string }): Observable<any>
  { return this.http.post(`http://13.87.131.41/api/auth/login`, authRequest).pipe(
     tap((response: any) => { localStorage.setItem('token', response.text); }) ); }

  getUserFromToken(token: string): Observable<any> {
    const headers = this.createAuthorizationHeader(token);
    return this.http.get(`http://13.87.131.41/api/auth?token=${token}`, { headers });
  }

  validateToken(token: string): Observable<any> {
    const headers = this.createAuthorizationHeader(token);
    return this.http.get(`http://13.87.131.41/api/auth/validate`, { headers });
  }

  saveUser(userDTO: { fullName: string, email: string, password: string, role: string }): Observable<any> {
    return this.http.post(`http://13.87.131.41/api/auth/add-user`, userDTO);
  }
  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['/login']);
  }
  isLoggedIn(): boolean { return !!localStorage.getItem('token'); }



}


