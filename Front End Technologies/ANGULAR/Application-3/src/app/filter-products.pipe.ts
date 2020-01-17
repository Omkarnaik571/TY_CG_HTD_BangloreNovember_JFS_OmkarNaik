import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterProducts'
})
export class FilterProductsPipe implements PipeTransform {

  products: Products[];


  transform(products: Products[], search: string): Products[] {
    if (search === undefined) {
      return products;
    } else {
      return products.filter((value, index) => {
        return value.name.toLowerCase().includes(search.toLocaleLowerCase());
      });
    }



  }

}
