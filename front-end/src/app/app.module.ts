import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AuthModule } from '@auth0/auth0-angular';

import { AppComponent } from './app.component';
import { StudyToolbarComponent } from './study-toolbar/study-toolbar.component';
import { StudyContentComponent } from './study-content/study-content.component';
import { environment } from 'src/environments/environment.development';
import { Auth0LoginComponent } from './auth0-login/auth0-login.component';
import { Auth0LogoutComponent } from './auth0-logout/auth0-logout.component';
import { UserProfileComponent } from './user-profile/user-profile.component';

@NgModule({
  declarations: [
    AppComponent,
    StudyToolbarComponent,
    StudyContentComponent,
    Auth0LoginComponent,
    Auth0LogoutComponent,
    UserProfileComponent
  ],
  imports: [
    BrowserModule,
    AuthModule.forRoot({
      domain: environment.authDomain,
      clientId: environment.authClientId,
      authorizationParams: {
        redirect_uri: window.location.origin
      }
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
