import { DOCUMENT } from '@angular/common';
import { Component, Inject } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';

@Component({
  selector: 'app-auth0-logout',
  templateUrl: './auth0-logout.component.html',
  styleUrls: ['./auth0-logout.component.css']
})
export class Auth0LogoutComponent {

  constructor(
    @Inject(DOCUMENT) public document: Document,
    private auth: AuthService
  ) { }

  logout() {
    this.auth.logout({
      logoutParams: {
        returnTo: this.document.location.origin
      }
    })
  }
}
