import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddProductPracticeComponent } from './add-product-practice.component';

describe('AddProductPracticeComponent', () => {
  let component: AddProductPracticeComponent;
  let fixture: ComponentFixture<AddProductPracticeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddProductPracticeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddProductPracticeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
