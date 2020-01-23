import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OtherCustomerOperationComponent } from './other-customer-operation.component';

describe('OtherCustomerOperationComponent', () => {
  let component: OtherCustomerOperationComponent;
  let fixture: ComponentFixture<OtherCustomerOperationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OtherCustomerOperationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OtherCustomerOperationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
