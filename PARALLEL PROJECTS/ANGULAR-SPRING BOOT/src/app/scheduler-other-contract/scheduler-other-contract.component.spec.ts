import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SchedulerOtherContractComponent } from './scheduler-other-contract.component';

describe('SchedulerOtherContractComponent', () => {
  let component: SchedulerOtherContractComponent;
  let fixture: ComponentFixture<SchedulerOtherContractComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SchedulerOtherContractComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SchedulerOtherContractComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
