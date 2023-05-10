import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Auth0LogoutComponent } from './auth0-logout.component';

describe('Auth0LogoutComponent', () => {
  let component: Auth0LogoutComponent;
  let fixture: ComponentFixture<Auth0LogoutComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [Auth0LogoutComponent]
    });
    fixture = TestBed.createComponent(Auth0LogoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
