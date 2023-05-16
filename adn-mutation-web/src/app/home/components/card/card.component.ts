import { Component, Input } from '@angular/core';

export class Human {
  name: string = "";
  createdAt: Date = new Date;
  hasMutation:boolean = false;
}

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent {
  
@Input() human: Human = {name: "", createdAt: new Date, hasMutation:false};


}
