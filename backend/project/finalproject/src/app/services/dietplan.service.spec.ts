import { TestBed } from '@angular/core/testing';

import { DietplanService } from './dietplan.service';

describe('DietplanService', () => {
  let service: DietplanService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DietplanService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
