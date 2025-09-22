import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { Usuario, UsuarioRequest, UsuarioResponse } from '../Models/Usuario';
import { appsettings } from '../Settings/appsettings';
import { ResponseApi } from '../Models/ResponseApi';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  apiUrl: string = appsettings.apiUrl + 'usuario';

  public usuarioSubject = new BehaviorSubject<UsuarioResponse | null>(null);
  public usuario$ = this.usuarioSubject.asObservable();

  constructor(private http: HttpClient) {
    this.cargarUsuario();
  }

  cargarUsuario() {
    const userString = localStorage.getItem('User');
    if (userString) {
      try {
        const usuario: UsuarioResponse = JSON.parse(userString);
        this.usuarioSubject.next(usuario);
      } catch (error) {
        console.error('Error al parsear el usuario desde localStorage:', error);
      }
    }
  }

  register(registerRequest: any): Observable<UsuarioResponse> {
    return this.http
      .post<UsuarioResponse>(`${this.apiUrl}/register`, registerRequest)
      .pipe(
        tap((response) => {
          localStorage.setItem('User', JSON.stringify(response));
        })
      );
  }
  listar(): Observable<UsuarioResponse[]> {
    return this.http.get<UsuarioResponse[]>(`${this.apiUrl}/listar`);
  }

  getUsuario(): any | null {
    const user = localStorage.getItem('User');
    return user ? JSON.parse(user) : null;
  }

  eliminar(id: number) {
    return this.http.delete<ResponseApi>(`${this.apiUrl}/${id}`); 
  }
}
