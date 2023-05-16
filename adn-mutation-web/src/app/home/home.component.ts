import { Component, OnInit } from '@angular/core';
import { HomeService } from './service/home.service';
import { MatDialog } from '@angular/material/dialog';
import { ModalComponent } from './components/modal/modal.component';
import { DialogRef } from '@angular/cdk/dialog';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {

  data: any = [];
  dataStats: any = [];
  isEnabled: boolean = false;

  constructor(
    private homeService: HomeService,
    public dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.homeService
      .getAll()
      .subscribe(data =>
        this.data = data
      )

    this.homeService.getStats().subscribe(dataStats =>
      this.dataStats = dataStats);
  }

  getData() {
    this.homeService
      .getAll()
      .subscribe(data =>
        this.data = data
      )
  }

  getRecordsMutation(hasMutation: boolean) {
    this.homeService.getRecordsWithMutation(hasMutation).subscribe(data =>
      this.data = data);
  }

  displayStats() {
    this.isEnabled = !this.isEnabled;
  }

  getStats(){
    this.homeService.getStats().subscribe(dataStats =>
      this.dataStats = dataStats);
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(
      ModalComponent
    )

    dialogRef.afterClosed().subscribe(result => {

      setTimeout(() => { this.getData(), this.getStats(), console.log("cerrado") }, 3000)
    })
  }


}
