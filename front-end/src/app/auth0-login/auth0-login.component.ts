import { Component } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';

@Component({
  selector: 'app-auth0-login',
  templateUrl: './auth0-login.component.html',
  styleUrls: ['./auth0-login.component.css']
})
export class Auth0LoginComponent {

  constructor(private auth: AuthService) { }

  login() {
    this.auth.loginWithRedirect()
  }

}
