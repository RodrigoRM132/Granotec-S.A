import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';

import { Producto, ProductoRequest } from '../Models/Producto';
import { ResponseApi } from '../Models/ResponseApi';
import { appsettings } from '../Settings/appsettings';
import { Observable } from 'rxjs';
import { Kardex } from '../Models/Kardex';

@Injectable({
  providedIn: 'root',
})
export class ProductoService {
  private apiurl: string = appsettings.apiUrl + 'producto';
  constructor(private http: HttpClient) {}
  listar(): Observable<Producto[]> {
    return this.http.get<Producto[]>(this.apiurl);
  }
  create(data: ProductoRequest): Observable<void> {
    return this.http.post<void>(this.apiurl, data);
  }
  getById(id: string): Observable<Producto> {
    return this.http.get<Producto>(`${this.apiurl}/${id}`);
  }
  getKardex(id: string): Observable<Kardex[]> {
    return this.http.get<Kardex[]>(`${this.apiurl}/kardex/${id}`);
  }
}
