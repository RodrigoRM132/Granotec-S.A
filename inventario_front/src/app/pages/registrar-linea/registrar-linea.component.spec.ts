import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarLineaComponent } from './registrar-linea.component';

describe('RegistrarLineaComponent', () => {
  let component: RegistrarLineaComponent;
  let fixture: ComponentFixture<RegistrarLineaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegistrarLineaComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrarLineaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
