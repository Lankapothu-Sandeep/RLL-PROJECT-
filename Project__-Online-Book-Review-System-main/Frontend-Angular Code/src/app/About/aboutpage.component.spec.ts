import { ComponentFixture, TestBed } from '@angular/core/testing';

import { aboutpageComponent } from './aboutpage.component';

describe('aboutpageComponent', () => {
  let component: aboutpageComponent;
  let fixture: ComponentFixture<aboutpageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ aboutpageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(aboutpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});