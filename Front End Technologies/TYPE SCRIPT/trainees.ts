interface Trainee{
  name:string,
  age:number,
  printData():void

}//end of interface


class Training implements Trainee{
name:'Omkar Naik';
age:22;
USN:'asdf';
marks:100;
aadharNO:124;
printData(){

}//end of method
}//end of class


let trainerr1:Trainee={
  name:'raja',
  age:12,
   printData:function(){
      console.log(this.name,this.age);
   }
  


}



