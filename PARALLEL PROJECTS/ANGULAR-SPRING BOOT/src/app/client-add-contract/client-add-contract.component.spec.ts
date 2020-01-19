import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientAddContractComponent } from './client-add-contract.component';

describe('ClientAddContractComponent', () => {
  let component: ClientAddContractComponent;
  let fixture: ComponentFixture<ClientAddContractComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientAddContractComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientAddContractComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
