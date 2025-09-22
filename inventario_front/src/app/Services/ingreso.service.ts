import { Injectable } from '@angular/core';
import { IngresoRequest } from '../Models/Ingreso';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { appsettings } from '../Settings/appsettings';

@Injectable({
  providedIn: 'root',
})
export class IngresoService {
  private apiurl: string = appsettings.apiUrl + 'ingreso';
  constructor(private http: HttpClient) {}
  registrar(data: IngresoRequest): Observable<void> {
    return this.http.post<void>(this.apiurl, data);
  }
}
