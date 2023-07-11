import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-forum-box',
  templateUrl: './forum-box.component.html',
  styleUrls: ['./forum-box.component.css']
})
export class ForumBoxComponent {
@Input() Forum:any;
}
