import { Component, inject, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Linea, LineaRequest } from '../../Models/Linea';
import { LineaService } from '../../Services/linea.service';
import { TablesComponent } from '../../components/tables/tables.component';

@Component({
  selector: 'app-registrar-linea',
  standalone: true,
  imports: [FormsModule, TablesComponent],
  templateUrl: './registrar-linea.component.html',
  styleUrl: './registrar-linea.component.css',
})
export class RegistrarLineaComponent implements OnInit {
  Lineas: Linea[] = [];
  lineaService = inject(LineaService);
  NewLinea: LineaRequest = {
    nombre: '',
  };
  ngOnInit(): void {
    this.cargarLineas();
  }
  cargarLineas() {
    this.lineaService.listar().subscribe((data) => {
      this.Lineas = data;
    });
  }
  Registrar() {
    this.lineaService.create(this.NewLinea).subscribe(() => {
      this.NewLinea = {
        nombre: '',
      };
      this.cargarLineas();
    });
  }
}
