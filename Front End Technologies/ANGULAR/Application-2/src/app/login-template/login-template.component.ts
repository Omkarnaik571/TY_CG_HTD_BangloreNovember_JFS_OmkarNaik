import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login-template',
  templateUrl: './login-template.component.html',
  styleUrls: ['./login-template.component.css']
})
export class LoginTemplateComponent implements OnInit {




  constructor() { }

  submitForm(form: NgForm) {
    console.log(form.value);
    form.reset();
  }


  ngOnInit() {
  }

}
