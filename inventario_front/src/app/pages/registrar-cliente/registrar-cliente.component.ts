import { Component, inject, OnInit } from '@angular/core';
import { SunatService } from '../../Services/sunat.service';
import { Router } from '@angular/router';
import { ClienteService } from '../../Services/cliente.service';
import { Cliente } from '../../Models/Cliente';
import {FormBuilder,FormGroup,FormsModule,ReactiveFormsModule,} from '@angular/forms';
import { UsuarioRequest, UsuarioResponse } from '../../Models/Usuario';
import { AuthService } from '../../Services/auth.service';
import { TablesComponent } from '../../components/tables/tables.component';
import { UsuarioService } from '../../Services/usuario.service';

@Component({
  selector: 'app-registrar-cliente',
  standalone: true,
  imports: [TablesComponent, FormsModule],
  templateUrl: './registrar-cliente.component.html',
  styleUrl: './registrar-cliente.component.css',
})
export class RegistrarClienteComponent implements OnInit {
  showForm: boolean = false;
  authService = inject(AuthService);
  usuarioService = inject(UsuarioService);
  Roles = [
    {nombre: 'Cliente',},
    {nombre: 'Proveedor'},
  ];
  NewUsuario: UsuarioRequest = {
    documento: '',
    nombre: '',
    direccion: '',
    telefono: '',
    rol: '',
  };
  Usuarios: UsuarioResponse[] = [];
  constructor(
    private sunatService: SunatService,
    private router: Router,
    private clienteService: UsuarioService
  ) {}
  ngOnInit(): void {
    this.cargarUsuarios();
  }

  buscarRuc(ruc: string) {
    this.sunatService.buscarRuc(ruc).subscribe(
      (data) => {
        this.NewUsuario.nombre = data.razonSocial;
        this.NewUsuario.direccion = data.direccion;
      },
      (error) => {
        console.error('Error al consultar RUC:', error);
      }
    );
  }

  Registrar() {
    this.usuarioService.register(this.NewUsuario).subscribe(
      (response) => {
        console.log('Usuario registrado', response);
        this.cargarUsuarios();
      },
      (error) => {
        console.error('Error al registrar el usuario', error);
      }
    );
  }

  cargarUsuarios() {
    this.usuarioService.listar().subscribe(
      (data) => {
        this.Usuarios = data;
      },
      (error) => {
        console.error('Error al cargar usuarios:', error);
      }
    );
  }

  toggleForm() {
    this.showForm = !this.showForm;
  }

  eliminarUsuario(id: number) {
    this.usuarioService.eliminar(id).subscribe(
      (response) => {
        console.log('Usuario eliminado:', response);
        this.cargarUsuarios();
      },
      (error) => {
        console.error('Error al eliminar el usuario:', error);
      }
    );
  }
}
