import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudyToolbarComponent } from './study-toolbar.component';

describe('StudyToolbarComponent', () => {
  let component: StudyToolbarComponent;
  let fixture: ComponentFixture<StudyToolbarComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [StudyToolbarComponent]
    });
    fixture = TestBed.createComponent(StudyToolbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
