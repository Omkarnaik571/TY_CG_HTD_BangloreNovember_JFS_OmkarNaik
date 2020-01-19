import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientOtherContractOpeartionComponent } from './client-other-contract-opeartion.component';

describe('ClientOtherContractOpeartionComponent', () => {
  let component: ClientOtherContractOpeartionComponent;
  let fixture: ComponentFixture<ClientOtherContractOpeartionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientOtherContractOpeartionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientOtherContractOpeartionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
