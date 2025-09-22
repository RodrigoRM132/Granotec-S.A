import { Component, inject } from '@angular/core';
import { Categoria, CategoriaRequest } from '../../Models/Categoria';
import { CategoriaService } from '../../Services/categoria.service';
import { FormsModule } from '@angular/forms';
import { TablesComponent } from '../../components/tables/tables.component';

@Component({
  selector: 'app-registrar-categoria',
  standalone: true,
  imports: [FormsModule, TablesComponent],
  templateUrl: './registrar-categoria.component.html',
  styleUrl: './registrar-categoria.component.css',
})
export class RegistrarCategoriaComponent {
  Categorias: Categoria[] = [];
  categoriaService = inject(CategoriaService);
  NewCategoria: CategoriaRequest = {
    nombre: '',
  };
  ngOnInit(): void {
    this.cargarCategorias();
  }
  cargarCategorias() {
    this.categoriaService.listar().subscribe((data) => {
      this.Categorias = data;
    });
  }
  Registrar() {
    this.categoriaService.create(this.NewCategoria).subscribe(() => {
      this.NewCategoria = {
        nombre: '',
      };
      this.cargarCategorias();
    });
  }
}
