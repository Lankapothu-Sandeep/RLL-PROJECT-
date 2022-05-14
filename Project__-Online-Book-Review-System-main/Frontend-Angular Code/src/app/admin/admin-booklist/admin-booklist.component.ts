import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from 'src/app/Book';
import { ApibookService } from 'src/app/services/apibook.service';

@Component({
  selector: 'app-admin-booklist',
  templateUrl: './admin-booklist.component.html',
  styleUrls: ['./admin-booklist.component.css']
})
export class AdminBooklistComponent implements OnInit {

  isDisable: boolean = false;
  disableBtn: string = "Disable";
  btncls: string = "btn-info";

  books:Book[];

  constructor(private router: Router, private bookService: ApibookService) { }

  ngOnInit(): void {

    this.bookService.apiBookList().subscribe((bookdata) => 
    this.books = bookdata
    );

    console.log(this.books)

  }

  addbook(){
    this.router.navigate(['/adminaddbook']);
  }

  distoggle(i:any){
    this.isDisable = !this.isDisable;
    if(this.isDisable == false){
      this.disableBtn = "Disable";
      document.getElementById('disbutt_'+i)?.classList.remove("btn-success");
      document.getElementById('disbutt_'+i)?.classList.add("btn-info");
      document.getElementById('myrow_'+i)?.style.setProperty("text-decoration", "none");
      document.getElementById('edt_'+i)?.style.setProperty("display", "inline");
      document.getElementById('det_'+i)?.style.setProperty("display", "inline");
    }else{
      this.disableBtn = "Enable";
      document.getElementById('disbutt_'+i)?.classList.remove("btn-info");
      document.getElementById('disbutt_'+i)?.classList.add("btn-success");
      document.getElementById('myrow_'+i)?.style.setProperty("text-decoration", "line-through");
      document.getElementById('edt_'+i)?.style.setProperty("display", "none");
      document.getElementById('det_'+i)?.style.setProperty("display", "none");
      //this.btncls = "btn-success";
    }
  }


  deleteBook(valId: number){
    console.log(valId);
    if (confirm("Do you want to delete the data??")) {
      this.bookService.deleteBook(valId).subscribe((res) => {
        console.log(res);
      });
    } else {
      console.log("Deletion Aborted");
    }
    
  }

  editBook(id:number){
    this.router.navigate(['/adminbkedit/'+id]);
  }


}
