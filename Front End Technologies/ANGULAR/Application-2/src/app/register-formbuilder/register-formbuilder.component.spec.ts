import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterFormbuilderComponent } from './register-formbuilder.component';

describe('RegisterFormbuilderComponent', () => {
  let component: RegisterFormbuilderComponent;
  let fixture: ComponentFixture<RegisterFormbuilderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterFormbuilderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterFormbuilderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
