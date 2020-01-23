import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AccountsOperationComponent } from './accounts-operation.component';

describe('AccountsOperationComponent', () => {
  let component: AccountsOperationComponent;
  let fixture: ComponentFixture<AccountsOperationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AccountsOperationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AccountsOperationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
