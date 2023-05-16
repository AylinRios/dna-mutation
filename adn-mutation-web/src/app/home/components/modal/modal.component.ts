import { Component } from '@angular/core';
import { MatDialogRef } from '@angular/material/dialog';
import { HomeService } from '../../service/home.service';
import { FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent {

  public form: FormGroup

  constructor(public dialogRef: MatDialogRef<ModalComponent>, public homeService: HomeService) {
    this.form = new FormGroup({
      name: new FormControl('', Validators.required)
    })
  }

  createHuman() {
    const nameControls = this.form.controls
    this.homeService.createHuman(nameControls["name"].value).subscribe(data => console.log(data))
  }

  public validateUserName(): string {
    let nameControl = this.form.controls["name"]
    return nameControl.hasError('required') ? 'El campo es obligatorio' : ''
  }


}
