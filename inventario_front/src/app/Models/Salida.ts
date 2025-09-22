export interface SalidaRequest {
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
  usuarioCliente_id: number;
  nota: string;
  detalles: DetalleSalidaRequest[];
}

export interface DetalleSalidaRequest {
  nombre: string;
  cantidad: number;
  precioUnitario: number;
  total: number;
  producto_id: string;
}
