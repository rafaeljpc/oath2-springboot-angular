import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudyUserComponent } from './study-user.component';

describe('StudyUserComponent', () => {
  let component: StudyUserComponent;
  let fixture: ComponentFixture<StudyUserComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StudyUserComponent]
    });
    fixture = TestBed.createComponent(StudyUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
