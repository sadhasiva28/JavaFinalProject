import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DietBoxComponent } from './diet-box.component';

describe('DietBoxComponent', () => {
  let component: DietBoxComponent;
  let fixture: ComponentFixture<DietBoxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DietBoxComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DietBoxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
