import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SchedulerEditContractComponent } from './scheduler-edit-contract.component';

describe('SchedulerEditContractComponent', () => {
  let component: SchedulerEditContractComponent;
  let fixture: ComponentFixture<SchedulerEditContractComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SchedulerEditContractComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SchedulerEditContractComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
