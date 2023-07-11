import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }
  httOptions:any;

  getproducts():Observable<any>{
    return this.http.get("http://localhost:4500/products")
  }
  getdetails(id:number):Observable<any>{
    return this.http.get("http://localhost:4500/details/"+id)
  }
  getproductsById(id:number):Observable<any>{
    return this.http.get("http://localhost:4500/products/"+id)
}
getreviews():Observable<any>{
  return this.http.get("http://localhost:4500/review")
}
postdetails(obj:any):Observable<any>{

  this.httOptions=  new HttpHeaders({
    'Content-Type':  'application/json',
  })

return this.http.post("http://localhost:4500/review",obj,this.httOptions);
}
}
