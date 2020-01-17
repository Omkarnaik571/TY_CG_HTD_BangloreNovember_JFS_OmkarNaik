import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OmkarComponent } from './omkar.component';

describe('OmkarComponent', () => {
  let component: OmkarComponent;
  let fixture: ComponentFixture<OmkarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OmkarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OmkarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
