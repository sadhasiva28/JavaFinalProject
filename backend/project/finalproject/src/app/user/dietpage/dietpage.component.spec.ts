import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DietpageComponent } from './dietpage.component';

describe('DietpageComponent', () => {
  let component: DietpageComponent;
  let fixture: ComponentFixture<DietpageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DietpageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DietpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
