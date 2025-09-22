import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class SunatService {
  private baseUrl = 'http://localhost:8080/api/sunat';
  constructor(private http: HttpClient) {}

  buscarRuc(ruc: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${ruc}`);
  }
}
