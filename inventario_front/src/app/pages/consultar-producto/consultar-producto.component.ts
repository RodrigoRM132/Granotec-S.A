import { Component, inject, Input, OnInit } from '@angular/core';
import { ProductoService } from '../../Services/producto.service';
import { Producto } from '../../Models/Producto';
import { Kardex } from '../../Models/Kardex';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CategoriaService } from '../../Services/categoria.service';
import { LineaService } from '../../Services/linea.service';
import { Linea } from '../../Models/Linea';
import { Categoria } from '../../Models/Categoria';
@Component({
  selector: 'app-consultar-producto',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './consultar-producto.component.html',
  styleUrl: './consultar-producto.component.css',
})
export class ConsultarProductoComponent implements OnInit {
  @Input('id') id: string = '';
  productoService = inject(ProductoService);
  categoriaService = inject(CategoriaService);
  lineaService = inject(LineaService);
  Lineas: Linea[] = [];
  Categorias: Categoria[] = [];
  Producto: Producto | null = null;
  ListKardex: Kardex[] = [];
  ngOnInit(): void {
    this.cargarLineas();
    this.cargarCategorias();
    this.cargarProducto();
  }
  cargarProducto() {
    this.productoService.getById(this.id).subscribe((res) => {
      this.Producto = res;
      console.log(this.Producto);
    });
    this.productoService.getKardex(this.id).subscribe((res) => {
      this.ListKardex = res;
      console.log(this.ListKardex);
    });
  }
  cargarCategorias() {
    this.categoriaService.listar().subscribe((data) => {
      this.Categorias = data;
    });
  }
  cargarLineas() {
    this.lineaService.listar().subscribe((data) => {
      this.Lineas = data;
    });
  }
  Registrar() {}
}
