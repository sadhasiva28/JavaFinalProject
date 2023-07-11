import { Component } from '@angular/core';
import { SuggestionsService } from 'src/app/services/suggestions.service';
import { FormComponent } from './form/form.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-suggestions',
  templateUrl: './suggestions.component.html',
  styleUrls: ['./suggestions.component.css']
})
export class SuggestionsComponent {
  suggestionlist:any;
  constructor(private sg: SuggestionsService,public dialog: MatDialog) {
    this.sg.getSuggestions().subscribe({
      next: (data: any) => (this.suggestionlist = data),
      error: () => (this.suggestionlist = [])
    });
  }
  openDialog(){
    this.dialog.open(FormComponent)
  }
}
