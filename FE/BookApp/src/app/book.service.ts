import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private httpCilent:HttpClient) { }

  baseurl= "http://localhost:9999/book-app/v1/";

  register(user:any){
    return this.httpCilent.post(this.baseurl+"register",user)
  }


  login(user1:any){
    return this.httpCilent.post(this.baseurl+"login",user1);

  }

  addbook(book:any){
    return this.httpCilent.post(this.baseurl+"add-book"+"/"+localStorage.getItem("userId"),book)
  }

  getAllBook(){
    return this.httpCilent.get(this.baseurl+"get-all-book"+"/"+localStorage.getItem('userId'));
  }

  updateBook(data:any){
    return this.httpCilent.put(this.baseurl+"update-book"+"/"+localStorage.getItem('userId'),data);
  }

  deleteBook(id:any){
    return this.httpCilent.delete(this.baseurl+"delete-book"+"/"+localStorage.getItem('userId')+"/"+id);
  }
}
