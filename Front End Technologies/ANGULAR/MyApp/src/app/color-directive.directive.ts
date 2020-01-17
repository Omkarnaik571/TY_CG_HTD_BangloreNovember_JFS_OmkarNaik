import { Directive, ElementRef, Renderer2, HostListener } from '@angular/core';

@Directive({
  selector: '[appColorDirective]'
})


export class ColorDirectiveDirective {

  constructor(private e1: ElementRef, private renderer: Renderer2) {
    // this.e1.nativeElement.style.background = 'blue';
    // this.e1.nativeElement.style.fontSize = '25px';
    let h1 = this.renderer.createElement('h6');
    let text = this.renderer.createText('Welcome to custom html tag by Renderer');
    this.renderer.appendChild(h1, text);
    this.renderer.appendChild(this.e1.nativeElement, h1);

  }
  @HostListener('mouseenter')
  x() {
    this.e1.nativeElement.style.background = '#ccc';
    this.e1.nativeElement.style.color = 'blue';
    this.e1.nativeElement.style.fontSize = '20px';
  }

  @HostListener('mouseleave')
  y() {
    this.e1.nativeElement.style.background = 'lightblue';
    this.e1.nativeElement.style.color = 'brown';
    this.e1.nativeElement.style.fontSize = '30px';
  }



}
