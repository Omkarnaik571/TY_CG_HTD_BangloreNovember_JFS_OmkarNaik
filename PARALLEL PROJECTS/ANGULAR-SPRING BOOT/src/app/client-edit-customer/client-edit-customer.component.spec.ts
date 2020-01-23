import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientEditCustomerComponent } from './client-edit-customer.component';

describe('ClientEditCustomerComponent', () => {
  let component: ClientEditCustomerComponent;
  let fixture: ComponentFixture<ClientEditCustomerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientEditCustomerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientEditCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
