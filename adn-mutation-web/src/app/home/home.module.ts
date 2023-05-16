import { NgModule } from '@angular/core'
import { HomeComponent } from "./home.component";
import { HomeRoutingModule } from "./home.routing";
import { CommonModule } from "@angular/common";
import { MatGridListModule } from '@angular/material/grid-list';
import { MatTabsModule } from '@angular/material/tabs';
import { MatCardModule } from '@angular/material/card';
import { CardComponent } from './components/card/card.component';
import { ModalComponent } from './components/modal/modal.component';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  imports: [
    HomeRoutingModule,
    CommonModule,
    MatGridListModule,
    MatTabsModule,
    MatCardModule,
    MatDialogModule,
    MatInputModule,
    MatButtonModule,
    ReactiveFormsModule
  ],
  declarations: [HomeComponent, CardComponent, ModalComponent],
  exports: [HomeComponent]
})
export class HomeModule { }