import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { BookService } from 'src/app/book.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {
  signForm!: FormGroup;
  constructor(private fb:FormBuilder, private bookService:BookService, private router:Router) { }

  ngOnInit(): void {
    this.signForm=this.fb.group({
      name:['',],
      phone:[''],
      emailId:[''],
      address:[''],
      password:['']

    })
  }
 signup(){
 this.bookService.register(this.signForm.value).subscribe(
  responce=>{
    console.log(responce);
    if(responce){
      alert("sign Sucessfully");
      this.router.navigateByUrl("dashboard/login")
    }else{
      alert("Some Thing is wrong .Please try again")
    }
  }
 )
 }


}
