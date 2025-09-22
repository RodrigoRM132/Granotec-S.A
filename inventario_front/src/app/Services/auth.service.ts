import { Injectable } from '@angular/core';
import { appsettings } from '../Settings/appsettings';
import { BehaviorSubject, map, Observable, of, tap } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { LoginRequest, Usuario, UsuarioResponse } from '../Models/Usuario';
import { ResponseApi } from '../Models/ResponseApi';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  apiUrl: string = appsettings.apiUrl + 'credenciales';

  public usuarioSubject = new BehaviorSubject<Usuario | null>(null);
  public usuario$ = this.usuarioSubject.asObservable();

  constructor(private http: HttpClient) {
  }

  login(obj: Usuario){
    const urlvalidar = this.apiUrl+"/login"
    return this.http.post<Usuario>(urlvalidar,obj);
  }

  logout() {
    localStorage.removeItem('User');
    this.usuarioSubject.next(null);
  }

}
