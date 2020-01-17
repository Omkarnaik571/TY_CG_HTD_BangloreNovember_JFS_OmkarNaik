import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LateCommersComponent } from './late-commers.component';

describe('LateCommersComponent', () => {
  let component: LateCommersComponent;
  let fixture: ComponentFixture<LateCommersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LateCommersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LateCommersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
