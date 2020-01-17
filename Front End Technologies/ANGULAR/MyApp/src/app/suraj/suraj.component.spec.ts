import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SurajComponent } from './suraj.component';

describe('SurajComponent', () => {
  let component: SurajComponent;
  let fixture: ComponentFixture<SurajComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SurajComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SurajComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
