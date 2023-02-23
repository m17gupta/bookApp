import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { BookService } from 'src/app/book.service';

@Component({
  selector: 'app-adminmain-board',
  templateUrl: './adminmain-board.component.html',
  styleUrls: ['./adminmain-board.component.css']
})
export class AdminmainBoardComponent implements OnInit {
  bookForm!: FormGroup;
  book_update='';
  constructor(private fb:FormBuilder, private bookService:BookService) { this.getAllBook() }

  ngOnInit(): void {

    this.bookForm= this.fb.group({
      bookId:[''],
      bookTitle:[''],
      bookAuthor:[''],
      bookDescription:[''],
      stock:['']
    })
  }

  save(){
  this.bookService.addbook(this.bookForm.value).subscribe(
    responce=>{
      console.log(responce)
      if(responce){
        alert("Book Added Succedfully");
        this.bookForm.reset();
       this.getAllBook();
      }else{
        alert("Something went wrong ")
      }
    }
  )
  }
 allBook:any;
  getAllBook(){
    this.bookService.getAllBook().subscribe(
      responce=>{
        console.log(responce);
        this.allBook=responce;

      }
    )
  }

  update(data:any){
    this.bookForm.patchValue(data);
    this.book_update="hello";
  }

  updateBook(){
    this.bookService.updateBook(this.bookForm.value).subscribe(
      responce=>{
        console.log(responce);
        if(responce){
          alert("Book Data Updated");
          this.book_update="";
          this.bookForm.reset();
          this.getAllBook();
        }else{
          alert("some thing Went wrong")
        }
      }
    )
  }

  bookDelete(id:any){
    console.log(id);
    this.bookService.deleteBook(id).subscribe(
      responce=>{
        console.log(responce);
        if(responce){
          alert("Deleted Your Book ");
          this.getAllBook();
        }else{
          alert("SomeThing went Wrong")
        }
      }
    )
  }

}
