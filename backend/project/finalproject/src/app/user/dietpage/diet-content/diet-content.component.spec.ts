import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DietContentComponent } from './diet-content.component';

describe('DietContentComponent', () => {
  let component: DietContentComponent;
  let fixture: ComponentFixture<DietContentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DietContentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DietContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
