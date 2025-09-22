import { Injectable } from '@angular/core';
import { appsettings } from '../Settings/appsettings';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Categoria, CategoriaRequest } from '../Models/Categoria';

@Injectable({
  providedIn: 'root',
})
export class CategoriaService {
  private apiurl: string = appsettings.apiUrl + 'categoria';
  constructor(private http: HttpClient) {}
  listar(): Observable<Categoria[]> {
    return this.http.get<Categoria[]>(this.apiurl);
  }
  create(data: CategoriaRequest): Observable<void> {
    return this.http.post<void>(this.apiurl, data);
  }
}
