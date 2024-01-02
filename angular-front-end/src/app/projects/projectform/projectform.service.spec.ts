import { TestBed } from '@angular/core/testing';

import { ProjectformService } from './projectform.service';

describe('ProjectformService', () => {
  let service: ProjectformService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProjectformService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
