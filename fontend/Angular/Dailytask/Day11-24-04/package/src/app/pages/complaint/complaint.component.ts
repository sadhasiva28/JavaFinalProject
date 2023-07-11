import { Component } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable, map, startWith } from 'rxjs';
import { ComplaintService } from 'src/app/services/complaint.service';

@Component({
  selector: 'app-complaint',
  templateUrl: './complaint.component.html',
  styleUrls: ['./complaint.component.css']
})
export class ComplaintComponent {
  myControl = new FormControl('');
  options: string[] = ['Electronics', 'Cosmetics', 'Groceries', 'Books'];
  filteredOptions?: Observable<string[]>;

  fname: string = "";
  lname: string = "";
  email: string = "";
  message: string = "";
  category: string = "";
  errors: string[] = [];

  constructor(private hs: ComplaintService) { }

  ngOnInit() {
    this.filteredOptions = this.myControl.valueChanges.pipe(
      startWith(''),
      map(value => this._filter(value || '')),
    );
  }

  private _filter(value: string): string[] {
    const filterValue = value.toLowerCase();

    return this.options.filter(option => option.toLowerCase().includes(filterValue));
  }

  submit() {
    this.errors = [];

    let expr = /^[a-z][a-z\._0-9]+@[a-z]+\.(com|net|co\.in|in)$/;

    if (this.fname == undefined || this.fname.length < 3)
      this.errors.push("First name should be greater than 3 characters");
    if (this.lname == undefined || this.lname.length < 3)
      this.errors.push("Last name should be greater than 3 characters");
    if (this.email == undefined || !expr.test(this.email))
      this.errors.push("Email should be in correct format");
      if (this.email == undefined || this.options.includes(this.category)) {
        this.errors.push("Choose a valid category from the options");
      }      
    if (this.message == undefined || this.message.length < 30)
      this.errors.push("Message should be greater than 30 characters");
    if (this.errors.length == 0) {
      let obj = {
        id: Math.round(Math.random() * 100000),
        fname: this.fname,
        lname: this.lname,
        email: this.email,
        message: this.message
      }

      this.hs.postEnquiry(obj).subscribe({
        next: () => {
          alert("Your enquiry has been posted successfully");
          this.fname = "";
          this.lname = "";
          this.email = "";
          this.message = "";
          this.category = "";
        },
        error: () => {
          alert("There was a problem posting your enquiry");
        }
      });
    }
  }

}
