import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OtherLandOperationComponent } from './other-land-operation.component';

describe('OtherLandOperationComponent', () => {
  let component: OtherLandOperationComponent;
  let fixture: ComponentFixture<OtherLandOperationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OtherLandOperationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OtherLandOperationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
