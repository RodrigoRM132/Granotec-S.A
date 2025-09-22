import { Component, inject, OnInit } from '@angular/core';
import { TablesComponent } from '../../components/tables/tables.component';
import { Producto, ProductoRequest } from '../../Models/Producto';
import { ProductoService } from '../../Services/producto.service';
import { FormsModule } from '@angular/forms';
import { Linea } from '../../Models/Linea';
import { Categoria } from '../../Models/Categoria';
import { CategoriaService } from '../../Services/categoria.service';
import { LineaService } from '../../Services/linea.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-registrar-producto',
  standalone: true,
  imports: [CommonModule, TablesComponent, FormsModule],
  templateUrl: './registrar-producto.component.html',
  styleUrl: './registrar-producto.component.css',
})
export class RegistrarProductoComponent implements OnInit {
  Productos: Producto[] = [];
  Lineas: Linea[] = [];
  Categorias: Categoria[] = [];
  productoService = inject(ProductoService);
  categoriaService = inject(CategoriaService);
  lineaService = inject(LineaService);
  NewProducto: ProductoRequest = {
    nombre: '',
    descripcion: '',
    precio: 0,
    unidad_medida: '',
    categoria_id: '',
    linea_id: '',
  };
  showForm: boolean = false;
  ngOnInit(): void {
    this.cargarCategorias();
    this.cargarLineas();
    this.cargarProductos();
  }
  Registrar() {
    this.productoService.create(this.NewProducto).subscribe((res) => {
      console.log(res);
      this.cargarProductos();
    });
  }
  cargarProductos() {
    this.productoService.listar().subscribe((res) => {
      this.Productos = res;
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
  toggleForm() {
    this.showForm = !this.showForm;
  }
}
