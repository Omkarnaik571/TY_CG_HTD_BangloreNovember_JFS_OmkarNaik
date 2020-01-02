"use strict";
console.log('hello world');
var a = 100;
console.log(a);
console.log('type script code started');
var b;
b = "hello";
console.log(b);
b = 100;
console.log(b);
//For declareing an array of generics type
var arr = [10, 20];
//Declering an object of generics type
var stud;
stud = {
    name: 'Omkar',
    age: 22,
    marks: 22,
    pass: true
};
//Creating class and objects in type script
var Student = /** @class */ (function () {
    function Student(name, age, USN, marks, aadharNo, panNumber) {
        this.name = name;
        this.age = age;
        this.USN = USN;
        this.marks = marks;
        this.aadharNo = aadharNo;
        this.panNumber = panNumber;
    } //end of constructor...................
    return Student;
}()); //end of class.................................
var stud1 = new Student('Omkar', 22, '14FSC', 92, undefined);
// creating object through string literals
var stud2 = {
    name: 'Aaryan',
    age: 22,
    USN: 'weergr',
    marks: 72
};
var student2 = new Student('aaryan', 22, '14FSC', 92, undefined);
var clearedStudent = [
    new Student('Saif', 22, '15FSC', 92, undefined),
    new Student('Suraj', 24, '16FSC', 92, undefined)
];
clearedStudent.forEach(function (value, index, array) {
    console.log(value, index);
});
