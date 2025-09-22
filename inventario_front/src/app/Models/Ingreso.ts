export interface IngresoRequest {
  documento: string;
  condicion: string;
  tipopago: string;
  formapago: string;
  total: number;
  gravada: number;
  impuesto: number;
  fecha_emision: string;
  fecha_vencimiento: string;
  usuarioEmpresa_id: number;
  usuarioProveedor_id: number;
  nota: string;
  detalles: DetalleIngresoRequest[];
}

export interface DetalleIngresoRequest {
  nombre: string;
  cantidad: number;
  precioUnitario: number;
  total: number;
  producto_id: string;
}
