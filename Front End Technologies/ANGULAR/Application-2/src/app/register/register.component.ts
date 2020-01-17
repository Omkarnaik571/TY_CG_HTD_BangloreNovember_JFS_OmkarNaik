import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormArray } from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup;
  constructor() { }

  ngOnInit() {
    this.registerForm = new FormGroup({
      name: new FormControl(null, [
        Validators.required,
        Validators.minLength(5)
      ]),
      email: new FormControl(null, [
        Validators.required,
        Validators.minLength(8),
        Validators.email
      ]),
      password: new FormControl(null, [
        Validators.required,
        Validators.minLength(8),
        Validators.maxLength(8)
      ]),
      age: new FormControl(null, [
        Validators.required,
        Validators.minLength(1),
        Validators.pattern('[0-9]')
      ]),
      skills: new FormArray([
        this.getSkill()
      ])
    });
  }

  submitForm() {
    console.log(this.registerForm.get('name'));
    this.registerForm.reset();
  }

  get name() {
    return this.registerForm.get('name');
  }

  get email() {
    return this.registerForm.get('email');
  }

  get password() {
    return this.registerForm.get('password');
  }

  get age() {
    return this.registerForm.get('age');
  }

  get skills(): FormArray {
    return this.registerForm.get('skills') as FormArray;
  }

  getSkill() {
    return new FormControl(null,
      [Validators.required,
      Validators.minLength(3)]
      );
  }

  addSkill() {
    this.skills.push(this.getSkill());
  }

  deleteSkill(i: number) {
    this.skills.removeAt(i);
  }





}
