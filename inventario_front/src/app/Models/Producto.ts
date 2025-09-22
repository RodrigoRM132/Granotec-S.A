export interface Producto {
  id: string;
  nombre: string;
  descripcion: string;
  precio: number;
  stock: number;
  unidad_medida: string;
  categoria_id: string;
  linea_id: string;
}
export interface ProductoRequest {
  nombre: string;
  descripcion: string;
  precio: number;
  unidad_medida: string;
  categoria_id: string;
  linea_id: string;
}
