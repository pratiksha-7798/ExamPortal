import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';
import { Examination } from '../model/examination';
import { Questions } from '../model/questions';
import { QuestionsService } from '../service/questions.service';

@Component({
  selector: 'app-view-questions',
  templateUrl: './view-questions.component.html',
  styleUrls: ['./view-questions.component.css']
})
export class ViewQuestionsComponent implements OnInit {

  
  questionsList:Questions[]=[];

  constructor(private _questionsService:QuestionsService) { }

  ngOnInit(): void 
  {
    this.getAllQuestionsDetails();
  }

  getAllQuestionsDetails()
  {
    this._questionsService.getAllQuestionsDetails().subscribe((Response:Questions[])=>
    {
            this.questionsList=Response;
  },
  (error=>
    {
      console.log(error);
    })
  );
      
  }
  deleteQuestions(id:any)
      {
        const swalWithBootstrapButtons = Swal.mixin({
          customClass: {
            confirmButton: 'btn btn-success',
            cancelButton: 'btn btn-danger'
          },
          buttonsStyling: false
        })
        
        swalWithBootstrapButtons.fire({
          title: 'Are you sure to delete data?',
          text: "You won't be able to revert this!",
          icon: 'warning',
          showCancelButton: true,
          confirmButtonText: 'Yes, delete it!',
          cancelButtonText: 'No, cancel!',
          reverseButtons: true
        }).then((result) => {
          if (result.isConfirmed) {
              
          this._questionsService.deleteQuestions(id).subscribe(Response=>
            {
                 this.getAllQuestionsDetails;
                 swalWithBootstrapButtons.fire(
                  'Deleted!',
                  'Your record has been deleted.',
                  'success'
                )    

            },
            (error=>
              {
                console.log(error);
              })
            );
    
          } else if (
            /* Read more about handling dismissals below */
            result.dismiss === Swal.DismissReason.cancel
          ) {
            swalWithBootstrapButtons.fire(
              'Cancelled',
              'Your imaginary file is safe :)',
              'error'
            )
          }
        })

           
}

}
