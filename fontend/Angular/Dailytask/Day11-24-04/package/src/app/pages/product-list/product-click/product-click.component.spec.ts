import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductClickComponent } from './product-click.component';

describe('ProductClickComponent', () => {
  let component: ProductClickComponent;
  let fixture: ComponentFixture<ProductClickComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductClickComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProductClickComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
