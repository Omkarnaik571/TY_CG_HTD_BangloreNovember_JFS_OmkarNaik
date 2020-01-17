import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  message: string;
  error: string;


  constructor(private service: AuthenticationService) { }

  ngOnInit() {
  }

  registerUser(form: NgForm) {
    this.service.registerUser(form.value).subscribe(data => {
      console.log(data);
      if (data.statuscode === 200) {
        this.message = data.message;
        form.reset();
        setTimeout(() => {
          this.message = null;
        }, 5000);
      } else {
        this.error = data.error.message;
        this.error = data.error.message;
        setTimeout(() => {
          this.message = null;
        }, 5000);
      }

    });

  }

}
