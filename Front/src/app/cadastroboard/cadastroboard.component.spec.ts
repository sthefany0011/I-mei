import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastroboardComponent } from './cadastroboard.component';

describe('CadastroboardComponent', () => {
  let component: CadastroboardComponent;
  let fixture: ComponentFixture<CadastroboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastroboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastroboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
