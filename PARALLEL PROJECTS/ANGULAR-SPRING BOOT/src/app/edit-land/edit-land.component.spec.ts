import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditLandComponent } from './edit-land.component';

describe('EditLandComponent', () => {
  let component: EditLandComponent;
  let fixture: ComponentFixture<EditLandComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditLandComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditLandComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
