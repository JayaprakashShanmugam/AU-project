import { TestBed } from '@angular/core/testing';

import { OpportunityserviceService } from './opportunityservice.service';

describe('OpportunityserviceService', () => {
  let service: OpportunityserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OpportunityserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
