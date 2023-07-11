import { Component, Input } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ResponseFormComponent } from '../response-form/response-form.component';

@Component({
  selector: 'app-response-box',
  templateUrl: './response-box.component.html',
  styleUrls: ['./response-box.component.css']
})
export class ResponseBoxComponent {
@Input() suggestion:any;
constructor(private dialog: MatDialog){

}
}
