import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnalyzeHumanComponent } from './analyze-human/analyze-human.component';
import { WithMutationComponent } from './with-mutation/with-mutation.component';
import { WithoutMutationComponent } from './without-mutation/without-mutation.component';

@NgModule({
  declarations: [
    AppComponent,
    AnalyzeHumanComponent,
    WithMutationComponent,
    WithoutMutationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
