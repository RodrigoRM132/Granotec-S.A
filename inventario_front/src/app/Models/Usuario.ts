export interface Usuario {
  id: number;
  username: string;
  password: string;
  rol: string;
}

export interface UsuarioRequest {
  documento: string;
  nombre: string;
  direccion: string;
  telefono: string;
  rol: string;
}
export interface UsuarioResponse {
  id: number;
  documento: string;
  nombre: string;
  direccion: string;
  telefono: string;
  rol: string;
}
export interface LoginRequest {
  username: string;
  password: string;
}
