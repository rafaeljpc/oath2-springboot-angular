import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { StudyToolbarComponent } from './study-toolbar/study-toolbar.component';
import { StudyContentComponent } from './study-content/study-content.component';

@NgModule({
  declarations: [
    AppComponent,
    StudyToolbarComponent,
    StudyContentComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
