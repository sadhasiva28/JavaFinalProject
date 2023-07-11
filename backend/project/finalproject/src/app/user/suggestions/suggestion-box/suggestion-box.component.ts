import { Component, Input, ViewChild } from '@angular/core';
import { MatAccordion } from '@angular/material/expansion';

@Component({
  selector: 'app-suggestion-box',
  templateUrl: './suggestion-box.component.html',
  styleUrls: ['./suggestion-box.component.css']
})
export class SuggestionBoxComponent {
@Input() suggestions:any;
}
