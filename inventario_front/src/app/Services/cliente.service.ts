import { inject, Injectable } from '@angular/core';
import { appsettings } from '../Settings/appsettings';
import { Cliente } from '../Models/Cliente';
import { ResponseApi } from '../Models/ResponseApi';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class ClienteService {
  private apiurl: string = appsettings.apiUrl + 'cliente';
  constructor(private http: HttpClient) {}

  listar() {
    return this.http.get<Cliente[]>(this.apiurl);
  }
  obtener(id: number) {
    return this.http.get<Cliente>(`${this.apiurl}/${id}`);
  }

  crear(Cliente: Cliente) {
    return this.http.post<ResponseApi>(this.apiurl, Cliente);
  }

  actualizar(objeto: Cliente, id: number) {
    return this.http.put<ResponseApi>(this.apiurl, objeto);
  }

  eliminar(id: number) {
    return this.http.delete<ResponseApi>(`${this.apiurl}/${id}`);
  }
}
