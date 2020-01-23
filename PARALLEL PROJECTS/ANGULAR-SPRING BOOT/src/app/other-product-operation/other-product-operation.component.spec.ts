import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OtherProductOperationComponent } from './other-product-operation.component';

describe('OtherProductOperationComponent', () => {
  let component: OtherProductOperationComponent;
  let fixture: ComponentFixture<OtherProductOperationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OtherProductOperationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OtherProductOperationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
