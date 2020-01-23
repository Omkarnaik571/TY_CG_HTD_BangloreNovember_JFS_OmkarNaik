import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientOtherCustomerOpeartionComponent } from './client-other-customer-opeartion.component';

describe('ClientOtherCustomerOpeartionComponent', () => {
  let component: ClientOtherCustomerOpeartionComponent;
  let fixture: ComponentFixture<ClientOtherCustomerOpeartionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientOtherCustomerOpeartionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientOtherCustomerOpeartionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
