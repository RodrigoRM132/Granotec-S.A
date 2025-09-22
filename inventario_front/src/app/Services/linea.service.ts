import { Injectable } from '@angular/core';
import { appsettings } from '../Settings/appsettings';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Linea, LineaRequest } from '../Models/Linea';

@Injectable({
  providedIn: 'root',
})
export class LineaService {
  private apiurl: string = appsettings.apiUrl + 'linea';
  constructor(private http: HttpClient) {}
  listar(): Observable<Linea[]> {
    return this.http.get<Linea[]>(this.apiurl);
  }
  create(data: LineaRequest): Observable<void> {
    return this.http.post<void>(this.apiurl, data);
  }
}
