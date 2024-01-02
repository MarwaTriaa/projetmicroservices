import { TestBed } from '@angular/core/testing';

import { PbformService } from './pbform.service';

describe('PbformService', () => {
  let service: PbformService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PbformService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
