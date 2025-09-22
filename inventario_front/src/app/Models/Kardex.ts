import { UsuarioResponse } from './Usuario';

export interface Kardex {
  id: string;
  fecha: number[];
  cantidad: number;
  stockActual: number;
  usuario: UsuarioResponse;
}
