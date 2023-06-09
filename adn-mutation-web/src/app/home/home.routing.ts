import { Routes, RouterModule } from '@angular/router'
import { NgModel } from '@angular/forms'
import { HomeComponent } from './home.component'
import { NgModule } from '@angular/core'

export const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})

export class HomeRoutingModule { }