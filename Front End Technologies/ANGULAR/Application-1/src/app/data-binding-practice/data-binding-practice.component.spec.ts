import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DataBindingPracticeComponent } from './data-binding-practice.component';

describe('DataBindingPracticeComponent', () => {
  let component: DataBindingPracticeComponent;
  let fixture: ComponentFixture<DataBindingPracticeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DataBindingPracticeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DataBindingPracticeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
