import { Component, Input, OnInit } from '@angular/core';
import { DietplanService } from 'src/app/services/dietplan.service';

@Component({
  selector: 'app-diet-box',
  templateUrl: './diet-box.component.html',
  styleUrls: ['./diet-box.component.css']
})
export class DietBoxComponent implements OnInit {
@Input() Diet:any;
@Input() lang!: string;
ngOnInit(): void {}
}
