import { Component, inject, OnInit } from '@angular/core';
import { Producto } from '../../Models/Producto';
import { ProductoService } from '../../Services/producto.service';
import { IngresoRequest } from '../../Models/Ingreso';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { IngresoService } from '../../Services/ingreso.service';
import { AuthService } from '../../Services/auth.service';
import { UsuarioResponse } from '../../Models/Usuario';
import { SalidaService } from '../../Services/salida.service';
import { SalidaRequest } from '../../Models/Salida';
import { UsuarioService } from '../../Services/usuario.service';

@Component({
  selector: 'app-salida',
  standalone: true,
  imports: [CommonModule, FormsModule, CurrencyPipe],
  templateUrl: './salida.component.html',
  styleUrl: './salida.component.css',
})
export class SalidaComponent implements OnInit {
  Productos: Producto[] = [];
  Usuarios: UsuarioResponse[] = [];

  productoService = inject(ProductoService);
  salidaService = inject(SalidaService);
  authService = inject(UsuarioService);

  Salida: SalidaRequest = {
    documento: '',
    condicion: '',
    tipopago: '',
    formapago: '',
    total: this.totalPagar,
    gravada: this.totalGravada,
    impuesto: this.igv,
    fecha_emision: '',
    fecha_vencimiento: '',

    usuarioEmpresa_id: 0,
    usuarioCliente_id: 0,
    nota: '',
    detalles: [],
  };
  ngOnInit(): void {
    this.cargarProductos();
    this.setFechaEmision();
    this.cargarUsuarios();
    console.log(this.Salida);
  }
  cargarUsuarios() {
    this.authService.listar().subscribe((res) => {
      this.Usuarios = res.filter((usuario) => usuario.rol === 'Cliente');
    });
    this.authService.usuario$.subscribe((res) => {
      if (res) {
        this.Salida.usuarioEmpresa_id = res.id;
      }
    });
  }
  cargarProductos() {
    this.productoService.listar().subscribe((res) => {
      this.Productos = res;
    });
  }
  Registrar() {
    this.Salida.total = this.totalPagar;
    this.Salida.gravada = this.totalGravada;
    this.Salida.impuesto = this.igv;
    this.Salida.fecha_emision = this.Salida.fecha_emision + 'T00:00:00';
    this.Salida.fecha_vencimiento = this.Salida.fecha_vencimiento + 'T00:00:00';
    console.log('Ingreso: ', this.Salida);
    console.log('Detalles', this.Salida.detalles);
    this.salidaService.registrar(this.Salida).subscribe((res) => {
      console.log(res);
    });
  }

  deleteProducto(index: number) {
    this.Salida.detalles.splice(index, 1);
  }
  EscogeProveedor(event: Event) {
    const select = event.target as HTMLSelectElement;
    const usuario_id = Number(select.value);
    const usuario = this.Usuarios.find((u) => u.id === usuario_id);
    if (usuario) {
      this.Salida.usuarioCliente_id = usuario_id;
    }
  }
  EscogeProducto(event: Event) {
    const select = event.target as HTMLSelectElement;
    const producto_id = select.value;

    const ProductoDetalle = this.Salida.detalles.find(
      (detalle) => detalle.producto_id === producto_id
    );
    if (ProductoDetalle) {
      ProductoDetalle.cantidad++;
      this.recalcularPrecio(this.Salida.detalles.indexOf(ProductoDetalle));
    } else {
      const producto = this.Productos.find((p) => p.id === producto_id);
      if (producto) {
        this.Salida.detalles.push({
          cantidad: 1,
          nombre: producto?.nombre,
          precioUnitario: producto?.precio,
          total: producto?.precio,
          producto_id: producto_id,
        });
      }
    }
  }
  recalcularPrecio(index: number): void {
    const producto = this.Salida.detalles[index];
    if (producto.cantidad && producto.precioUnitario) {
      producto.total = producto.cantidad * producto.precioUnitario;
    } else {
      producto.total = 0;
    }
  }
  get totalGravada(): number {
    return this.totalPagar / 1.18;
  }

  get igv(): number {
    return this.totalGravada * 0.18;
  }

  get totalPagar(): number {
    return this.Salida?.detalles.reduce(
      (total, detalle) => total + detalle.total,
      0
    );
  }
  setFechaEmision(): void {
    const now = new Date();
    const day = now.getDate().toString().padStart(2, '0');
    const month = (now.getMonth() + 1).toString().padStart(2, '0');
    const year = now.getFullYear();

    // Formatear las fechas en 'yyyy-mm-dd'
    this.Salida.fecha_emision = `${year}-${month}-${day}`;
    this.Salida.fecha_vencimiento = `${year}-${month}-${day}`;
  }
}
