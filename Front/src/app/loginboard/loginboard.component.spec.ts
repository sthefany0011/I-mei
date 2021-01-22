import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginboardComponent } from './loginboard.component';

describe('LoginboardComponent', () => {
  let component: LoginboardComponent;
  let fixture: ComponentFixture<LoginboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
