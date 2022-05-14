import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from 'src/app/Book';
import { ApibookService } from 'src/app/services/apibook.service';

@Component({
  selector: 'app-user-booklist',
  templateUrl: './user-booklist.component.html',
  styleUrls: ['./user-booklist.component.css']
})
export class UserBooklistComponent implements OnInit {

  book:Book[];
  constructor(private router: Router, private bookService: ApibookService) { }

  ngOnInit(): void {
    this.getBookList();
  }

  getBookList(){
    this.bookService.apiBookList().subscribe((res) => {
      this.book = res;

    });
  }

  rateBook(id: number){
    this.router.navigate(['/userbkrt/'+id]);
  }

}





  