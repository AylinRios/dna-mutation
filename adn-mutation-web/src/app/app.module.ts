import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnalyzeHumanComponent } from './analyze-human/analyze-human.component';
import { WithMutationComponent } from './with-mutation/with-mutation.component';
import { WithoutMutationComponent } from './without-mutation/without-mutation.component';
import { LoginComponent } from './login/login.component';
import { LoginService } from './login/service/login.service';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginModule } from './login/login.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CommonModule } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';
import { HomeComponent } from './home/home.component';
import { MatToolbarModule } from '@angular/material/toolbar';
import { HomeModule } from './home/home.module';
import { HomeService } from './home/service/home.service';
import { GenericService } from './shared/generic.service';

@NgModule({
  declarations: [
    AppComponent,
    AnalyzeHumanComponent,
    WithMutationComponent,
    WithoutMutationComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    CommonModule,
    MatIconModule,
    MatToolbarModule,
    LoginModule,
    HomeModule
  ],
  providers: [LoginService, HomeService, GenericService],
  bootstrap: [AppComponent]
})
export class AppModule { }
