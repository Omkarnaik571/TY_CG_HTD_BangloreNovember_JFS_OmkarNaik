console.log('hello world');

let a:number=100;
console.log(a);


console.log('type script code started');

let b;
b="hello";
console.log(b);
b=100;
console.log(b);

//For declareing an array of generics type

let arr:number[]=[10,20];

//Declering an object of generics type

let stud:{name:string,age:number,marks:number,pass:boolean}

stud={
    name:'Omkar',
    age:22,
    marks:22,
    pass:true
}
//Creating class and objects in type script
class Student{
    constructor(public name:string,
        public age:number,
        public USN:string,
        public marks:number,
        public aadharNo?:number,
        public panNumber?:number
        ){      
        
        }//end of constructor...................

//   static printDetails():void{
//      console.log('Name is '+this.name);
//      console.log('Age is '+this.age);
//      console.log('USN is '+this.USN);
//      console.log('Marks is '+this.marks)

//    }//end of method............................

}//end of class.................................

let stud1=new Student('Omkar',22,'14FSC',92,undefined);


// creating object through string literals

let stud2:Student = {
 name:'Aaryan',
 age:22,
 USN:'weergr',
 marks:72
}

let student2=new Student('aaryan',22,'14FSC',92,undefined);

let clearedStudent=[
    new Student('Saif',22,'15FSC',92,undefined),
    new Student('Suraj',24,'16FSC',92,undefined)
    
];

  clearedStudent.forEach((value,index,array)=>{
    console.log(value,index);
  });






