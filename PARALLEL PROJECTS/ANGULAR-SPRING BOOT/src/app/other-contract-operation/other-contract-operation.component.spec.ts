import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OtherContractOperationComponent } from './other-contract-operation.component';

describe('OtherContractOperationComponent', () => {
  let component: OtherContractOperationComponent;
  let fixture: ComponentFixture<OtherContractOperationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OtherContractOperationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OtherContractOperationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
