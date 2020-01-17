import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormArray, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-register-formbuilder',
  templateUrl: './register-formbuilder.component.html',
  styleUrls: ['./register-formbuilder.component.css']
})
export class RegisterFormbuilderComponent implements OnInit {

  registerForm: FormGroup;
  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.registerForm = this.fb.group({
      name: this.fb.control(null, [
        Validators.required,
        Validators.minLength(5)
      ]),
      email: this.fb.control(null, [
        Validators.required,
        Validators.minLength(8),
        Validators.email
      ]),
      password: this.fb.control(null, [
        Validators.required,
        Validators.minLength(8),
        Validators.maxLength(8)
      ]),
      age: this.fb.control(null, [
        Validators.required,
        Validators.minLength(1),
        Validators.pattern('[0-9]')
      ]),
      skills: this.fb.array([
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
