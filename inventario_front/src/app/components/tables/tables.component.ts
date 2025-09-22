import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-tables',
  standalone: true,
  imports: [RouterLink, CommonModule],
  templateUrl: './tables.component.html',
  styleUrl: './tables.component.css',
})
export class TablesComponent {
  @Input() data: any[] = [];
  @Input() columns: any[] = [];
  @Input() ruta: string = '';
  @Input() param: string = '';
  @Input() iconType: string = 'default';
  @Output() eliminar: EventEmitter<number> = new EventEmitter<number>(); 

  currentRoute: string = '';

  constructor(private router: Router) { }
  
  ngOnInit(): void {
    this.currentRoute = this.router.url;
  }

  eliminarUsuario(id: number) {
    this.eliminar.emit(id);
  }

  shouldHideIcon(): boolean {
    const rutasOcultas = ['/dashboard/registrar-categoria', '/dashboard/registrar-linea'];
    return rutasOcultas.includes(this.currentRoute);
  }
}
