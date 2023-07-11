import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OwndietpageComponent } from './owndietpage.component';

describe('OwndietpageComponent', () => {
  let component: OwndietpageComponent;
  let fixture: ComponentFixture<OwndietpageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OwndietpageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OwndietpageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
