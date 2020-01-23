import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddLandComponent } from './add-land.component';

describe('AddLandComponent', () => {
  let component: AddLandComponent;
  let fixture: ComponentFixture<AddLandComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddLandComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddLandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
