import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SaifComponent } from './saif.component';

describe('SaifComponent', () => {
  let component: SaifComponent;
  let fixture: ComponentFixture<SaifComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SaifComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SaifComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
