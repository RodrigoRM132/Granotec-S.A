import { Injectable } from '@angular/core';
import { appsettings } from '../Settings/appsettings';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SalidaRequest } from '../Models/Salida';

@Injectable({
  providedIn: 'root',
})
export class SalidaService {
  private apiurl: string = appsettings.apiUrl + 'salida';
  constructor(private http: HttpClient) {}
  registrar(data: SalidaRequest): Observable<void> {
    return this.http.post<void>(this.apiurl, data);
  }
}
