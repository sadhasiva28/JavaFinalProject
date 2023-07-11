import { Component, Input } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {
@Input() product:any;

constructor(public router:Router,public route:ActivatedRoute) { }

ngOnInit(): void {
}

}
