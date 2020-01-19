import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientEditContractComponent } from './client-edit-contract.component';

describe('ClientEditContractComponent', () => {
  let component: ClientEditContractComponent;
  let fixture: ComponentFixture<ClientEditContractComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientEditContractComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientEditContractComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
