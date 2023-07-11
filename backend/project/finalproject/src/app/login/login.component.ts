import { Component } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import { LoginService } from '../services/login.service';
import { Router } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  hidePassword = true;
  UserLoginForm:any;
  userlist: any;
  hide = true;
  signin:boolean = true;
  signup:boolean = false;
  login(){
    this.signin = true;
    this.signup = false;
  }
  register(){
    this.signin = false;
    this.signup = true;
  }
  constructor(private fb:FormBuilder,private ls:LoginService,private router:Router){
    this.UserLoginForm = this.fb.group({
       name:['',[Validators.required,Validators.minLength(3)]],
       password:['',[Validators.required,Validators.minLength(6)]],
       email:['',[Validators.required, Validators.pattern(
         "^[A-Za-z][A-Za-z_\.0-9]+@[A-Za-z]+[\.][A-Za-z]{2,5}$")]],
     })

     this.ls.getUser().subscribe({
       next: (data: any) => (this.userlist = data),
       error: () => (this.userlist = [])
     });

    }
    checkUser() {
      if (!this.UserLoginForm.valid) {
        console.log('Userform valid');
        const foundUser = this.userlist.find((user: any) => user.Username === this.UserLoginForm.value.name && user.Password === this.UserLoginForm.value.password);
        if (foundUser) {
          if (foundUser.type === 'user') {
            this.router.navigate(['home']);
          } 
          else if (foundUser.type === 'admin') {
            this.router.navigate(['admin']);
          } 
        }
        else {
          alert("Invalid credentials! Try again")
          location.reload();
        }
      }
    }    
    
    existingUser: boolean = false;
    saveUser() {
      this.existingUser = false;
    
      for (let x of this.userlist) {
        if (x.Email === this.UserLoginForm.value.email) {
          this.existingUser = true;
          break;
        }
      }
    
      if (!this.existingUser) {
        var temp: any = {
          id: this.userlist.length + 1,
          Username: this.UserLoginForm.value.name,
          Password: this.UserLoginForm.value.password,
          Email: this.UserLoginForm.value.email,
          type: "user",
        };
    
        this.ls.addUser(temp).subscribe({
          next: (data) => {
            alert("Yah! Registered successfully");
            location.reload();
          },
          error: (error) => alert("Oops! Unable to register"),
        });
      } else {
        alert("User already exists with this email address!");
        location.reload();
      }
    }
    
}
