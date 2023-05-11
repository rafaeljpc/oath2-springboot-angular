import { TestBed } from '@angular/core/testing';

import { StudyUserSvcService } from './study-user-svc.service';

describe('StudyUserSvcService', () => {
  let service: StudyUserSvcService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StudyUserSvcService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
