import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { BookService } from 'src/app/book.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 loginForm!: FormGroup;
  constructor(private fb:FormBuilder, private bookService:BookService, private router:Router) { }

  ngOnInit(): void {

    this.loginForm=this.fb.group({
      emailId:[''],
      password:['']
    })
  }

  user:any;
  email:any;
  login(){
    this.bookService.login(this.loginForm.value).subscribe(
      responce=>{
        console.log(responce);
        if(responce){
          alert("You are Login succesfully");
          this.user=responce;
          this.email=this.user.emailId;
          console.log(this.email);
          localStorage.setItem('userId',this.email);

          this.router.navigateByUrl("/admin")
        }
        else{
          alert("some thing went wrong")
        }
      }
    )

  }
}
