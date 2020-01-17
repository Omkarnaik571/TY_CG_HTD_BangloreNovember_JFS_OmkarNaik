import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetProductsComponent } from './get-products.component';

describe('GetProductsComponent', () => {
  let component: GetProductsComponent;
  let fixture: ComponentFixture<GetProductsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetProductsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetProductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
