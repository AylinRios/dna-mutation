import { Component, OnInit } from '@angular/core';
import { LoginService } from './service/login.service';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators, FormBuilder } from '@angular/forms'


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  public loginForm: FormGroup
  public hide: boolean = true

  constructor(
    private router: Router,
    private loginService: LoginService,

  ) {
    this.loginForm = new FormGroup({
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.required)
    })
  }

  public validateUserName(): string {
    let usernameControl = this.loginForm.controls["username"]

    return usernameControl.hasError('required') ? 'El campo es obligatorio' : ''
  }

  validateToDisabledButton(): boolean {
    let emailControl = this.loginForm.controls["username"]
    return emailControl.hasError('required')
  }

  userAuthentication() {
    const loginControls = this.loginForm.controls
    this.loginService
      .login(loginControls["username"].value, loginControls["password"].value)
      .subscribe(statusResult => {
        switch (statusResult) {
          case 200:
            //  this.router.navigate(['/app-home'])

            this.router.navigate(['/home'])
            break

        }
      })
  }

}
