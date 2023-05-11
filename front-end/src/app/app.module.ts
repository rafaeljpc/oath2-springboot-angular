import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AuthModule, AuthHttpInterceptor } from '@auth0/auth0-angular';

import { AppComponent } from './app.component';
import { StudyToolbarComponent } from './study-toolbar/study-toolbar.component';
import { StudyContentComponent } from './study-content/study-content.component';
import { environment } from 'src/environments/environment.development';
import { Auth0LoginComponent } from './auth0-login/auth0-login.component';
import { Auth0LogoutComponent } from './auth0-logout/auth0-logout.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { StudyUserComponent } from './study-user/study-user.component';

@NgModule({
  declarations: [
    AppComponent,
    StudyToolbarComponent,
    StudyContentComponent,
    Auth0LoginComponent,
    Auth0LogoutComponent,
    UserProfileComponent,
    StudyUserComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AuthModule.forRoot({
      domain: environment.authDomain,
      clientId: environment.authClientId,

      authorizationParams: {
        redirect_uri: window.location.origin,
        audience: environment.audience,
      },

      httpInterceptor: {
        allowedList: [{
          uri: `${environment.serviceMainUrl}/*`,
          tokenOptions: {
            authorizationParams: {
              audience: environment.audience,
              scope: environment.scope
            }
          }
        }]
      }
    })
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthHttpInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
