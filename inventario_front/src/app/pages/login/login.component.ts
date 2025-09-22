import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../Services/auth.service';
import { LoginRequest, Usuario } from '../../Models/Usuario';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import Swal from 'sweetalert2';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule, MatCardModule, MatInputModule,MatFormFieldModule, MatButtonModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  private authService = inject(AuthService);
  public formBuild=inject(FormBuilder)

  constructor(private router: Router) {}

  public formLogin:FormGroup=this.formBuild.group({
    username:[""],
    password:[""]
  });

  login() {
    const usr: Usuario={
      username: this.formLogin.value.username,
      password: this.formLogin.value.password,
      id:0,
      rol:'',
    };
    this.authService.login(usr).subscribe({
      next:(data) => {
        if(data.id>0){
          this.router.navigate(["dashboard/index"])
        }
        else {
          Swal.fire({
            icon: 'error',
            title: 'Necesita Permisos',
            timer: 1000,
          });
        }
      },
      error:(err) => {
        console.log("ERROR: no se recibio respuesta del servidor")
      }
    });
  }
}
