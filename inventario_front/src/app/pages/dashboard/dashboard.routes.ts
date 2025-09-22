import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutComponent } from './layout/layout.component';
const routes: Routes = [
  {
    path: '',
    component: LayoutComponent,
    children: [
      {
        path: 'index',
        loadComponent: () =>
          import('../index/index.component').then((m) => m.IndexComponent),
      },

      {
        path: 'registrar-producto',
        loadComponent: () =>
          import('../registrar-producto/registrar-producto.component').then(
            (m) => m.RegistrarProductoComponent
          ),
      },
      {
        path: 'registrar-categoria',
        loadComponent: () =>
          import('../registrar-categoria/registrar-categoria.component').then(
            (m) => m.RegistrarCategoriaComponent
          ),
      },
      {
        path: 'registrar-linea',
        loadComponent: () =>
          import('../registrar-linea/registrar-linea.component').then(
            (m) => m.RegistrarLineaComponent
          ),
      },
      {
        path: 'ingreso',
        loadComponent: () =>
          import('../ingreso/ingreso.component').then(
            (m) => m.IngresoComponent
          ),
      },
      {
        path: 'salida',
        loadComponent: () =>
          import('../salida/salida.component').then((m) => m.SalidaComponent),
      },
      {
        path: 'registrar-cliente',
        loadComponent: () =>
          import('../registrar-cliente/registrar-cliente.component').then(
            (m) => m.RegistrarClienteComponent
          ),
      },
      {
        path: 'consultar-producto/:id',
        loadComponent: () =>
          import('../consultar-producto/consultar-producto.component').then(
            (m) => m.ConsultarProductoComponent
          ),
      },
    ],
  },
] as Routes;

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class DashboardRoutesModule {}
