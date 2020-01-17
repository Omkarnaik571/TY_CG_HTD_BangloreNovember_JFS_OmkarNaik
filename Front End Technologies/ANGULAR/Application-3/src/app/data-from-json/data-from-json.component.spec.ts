import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DataFromJsonComponent } from './data-from-json.component';

describe('DataFromJsonComponent', () => {
  let component: DataFromJsonComponent;
  let fixture: ComponentFixture<DataFromJsonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DataFromJsonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DataFromJsonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
