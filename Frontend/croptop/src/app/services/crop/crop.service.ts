import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CropService {
  baseUrl: string = "http://localhost:8080/api/crop/"

  token: any = localStorage.getItem('token')

  private createAuthorizationHeader(token: string): HttpHeaders {
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    });
  }

  constructor(private http:HttpClient) { }

  getCrop(id: number): Observable<any>{
    const headers = this.createAuthorizationHeader(this.token);
    return this.http.get(this.baseUrl + id, {headers})
  }

  addCrop( CropDTO: {id: number,  cropName: String ,  cropDescription: String ,  farm_id: number  }): Observable<any>{
    const headers = this.createAuthorizationHeader(this.token);
    return this.http.post(this.baseUrl + "add-crop", CropDTO, {headers})
  }

  getCropsByFarmId(id: number): Observable<any>{
    const headers = this.createAuthorizationHeader(this.token);
    return this.http.get(this.baseUrl + "all-crops/" + id, {headers})
  }

  updateCrop(id:number, CropDTO: {id: number,  cropName: String ,  cropDescription: String ,  farm_id: number  }): Observable<any>{
    const headers = this.createAuthorizationHeader(this.token);
    return this.http.put(this.baseUrl + "update/" + id, CropDTO, {headers})
  }

  deleteCrop(id:number): Observable<any>{
    const headers = this.createAuthorizationHeader(this.token);
    return this.http.delete(this.baseUrl + "delete/" + id, {headers})
  }
}
