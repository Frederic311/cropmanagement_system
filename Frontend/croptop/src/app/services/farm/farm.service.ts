import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Farm } from '../../models/farm.model';

const BASE_URL = 'http://localhost:8080/api/farm';

@Injectable({
  providedIn: 'root'
})
export class FarmService {

  constructor(private http: HttpClient) { }

  private createAuthorizationHeader(): HttpHeaders {
    const jwtToken = localStorage.getItem('jwt');
    if (jwtToken) {
      return new HttpHeaders().set('Authorization', 'Bearer ' + jwtToken);
    }
    return new HttpHeaders();
  }

  addFarm(farm: Farm): Observable<Farm> {
    return this.http.post<Farm>(`${BASE_URL}/add-farm`, farm, {
      headers: this.createAuthorizationHeader()
    });
  }

  getAllFarms(): Observable<Farm[]> {
    return this.http.get<Farm[]>(`${BASE_URL}/all-farms`, {
      headers: this.createAuthorizationHeader()
    });
  }

  getFarmById(id: number): Observable<Farm> {
    return this.http.get<Farm>(`${BASE_URL}/${id}`, {
      headers: this.createAuthorizationHeader()
    });
  }

  updateFarm(id: number, farm: Farm): Observable<Farm> {
    return this.http.put<Farm>(`${BASE_URL}/update/${id}`, farm, {
      headers: this.createAuthorizationHeader()
    });
  }

  deleteFarm(id: number): Observable<void> {
    return this.http.delete<void>(`${BASE_URL}/delete/${id}`, {
      headers: this.createAuthorizationHeader()
    });
  }
}
