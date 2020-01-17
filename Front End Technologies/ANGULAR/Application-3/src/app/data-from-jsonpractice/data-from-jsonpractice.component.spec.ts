import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DataFromJSONPracticeComponent } from './data-from-jsonpractice.component';

describe('DataFromJSONPracticeComponent', () => {
  let component: DataFromJSONPracticeComponent;
  let fixture: ComponentFixture<DataFromJSONPracticeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DataFromJSONPracticeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DataFromJSONPracticeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
