import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {
  httpOptions:any;
  constructor(private http:HttpClient) { }        

  public getProductsbyId(id:any): Observable<any> {
    return this.http.get("http://localhost:4500/Allproducts/"+id);
  }
  public getProducts(): Observable<any> {
    return this.http.get("http://localhost:4500/Allproducts");
  }
  public postProduct(obj: any): Observable<any> {
    this.httpOptions = new HttpHeaders({
      'Content-Type': 'application/json',
    })

    return this.http.post("http://localhost:4500/Allproducts", obj, this.httpOptions);
  }
  public getProductsByCategory(category: string): Observable<any> {
    return this.http.get<any>('http://localhost:4500/Allproducts').pipe(
      map(data => data.filter((product: { type: string; }) => product.type === category))
    );
  }
  
}
