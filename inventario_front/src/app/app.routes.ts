import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { RegistrarClienteComponent } from './pages/registrar-cliente/registrar-cliente.component';
export const routes: Routes = [
  { path: '', component: LoginComponent },
  {
    path: 'dashboard',
    loadChildren: () =>
      import('./pages/dashboard/dashboard.routes').then(
        (m) => m.DashboardRoutesModule
      ),
  },
  {path: 'usuario/:id', component: RegistrarClienteComponent}
];
