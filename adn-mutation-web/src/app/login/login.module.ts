import { NgModule } from '@angular/core'
import { FormsModule, ReactiveFormsModule } from '@angular/forms'
import { MatButtonModule } from '@angular/material/button'
import { MatCardModule } from '@angular/material/card'
import { MatFormFieldModule } from '@angular/material/form-field'
import { MatIconModule } from '@angular/material/icon'
import { MatInputModule } from '@angular/material/input'
import { RouterModule } from '@angular/router'
import { LoginComponent } from './login.component'
import { LoginRoutes } from './login.routing'
import { CommonModule } from '@angular/common'


@NgModule({
  imports: [
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    FormsModule,
    MatIconModule,
    MatButtonModule,
    ReactiveFormsModule,
    CommonModule,
    RouterModule.forChild(LoginRoutes)
  ],
  declarations: [LoginComponent],
  exports: [RouterModule, LoginComponent],
  providers: [],

})
export class LoginModule {}