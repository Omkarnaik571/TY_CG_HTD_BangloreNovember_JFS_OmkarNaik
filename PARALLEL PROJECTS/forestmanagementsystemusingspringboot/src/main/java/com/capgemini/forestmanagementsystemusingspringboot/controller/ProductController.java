package com.capgemini.forestmanagementsystemusingspringboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestmanagementsystemusingspringboot.dto.ProductDetailsDto;
import com.capgemini.forestmanagementsystemusingspringboot.dto.ProductResponse;
import com.capgemini.forestmanagementsystemusingspringboot.service.ProductService;

@CrossOrigin(origins = "*" , allowedHeaders = "*", allowCredentials = "true")
@RestController
public class ProductController {
     @Autowired
	ProductService productService;
	
     @PostMapping(path = "/addProduct", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  	public ProductResponse addProduct(@RequestBody ProductDetailsDto bean) {
    	 ProductResponse response = new ProductResponse();
  		if (productService.addProduct(bean)) {
  			// Added successfully
  			response.setStatuscode(200);
  			response.setMessage("product could`nt be added !!");
  			response.setDescription("Product added succefully !!");
  		} else {
  			// Added Unsuccessfully
  			response.setStatuscode(444);
  			response.setMessage("product could`nt be added !!");
  			response.setMessage("product could`nt be added !!");
  		}

  		return response;
  	}// end of add Product
     
     
     @DeleteMapping(path = "/deleteProduct/{productId}",produces = MediaType.APPLICATION_JSON_VALUE)
 	public ProductResponse deleteProduct(@PathVariable("productId")int id) {
 		ProductResponse response = new ProductResponse();
 		if(productService.deleteProduct(id)) {
 			//Deletion successfully
 			response.setStatuscode(200);
 			response.setMessage("product deleted Successfully !!");
 			response.setDescription("product deleted Successfully !!");
 		}
 		else {
 			//Deletion unsuccessful Unsuccessfully
 			response.setStatuscode(444);
 			response.setMessage("product deletion unsuccessful !!");
 			response.setMessage("product deletion unsuccessful !!");
 		}
 		return response;
 	}//end of delete product
     
     @GetMapping(path = "/viewallProduct", produces = MediaType.APPLICATION_JSON_VALUE)
  	public ProductResponse viewallProduct() {
    	 ProductResponse response = new ProductResponse();
  		List<ProductDetailsDto> result = productService.viewAllProduct();
  		if(!result.isEmpty()) {
  			response.setStatuscode(200);
  	 		response.setMessage("All product details found !!");
  	 		response.setDescription("All product details found !!");
  	 		response.setBean(result);	
  		}
       else {
 			
 			response.setStatuscode(444);
 			response.setMessage("product data  not found !!");
 			response.setDescription("product data  not found");
 		}
  		
  		return response;
  	}// end of view all product
     
     
     @PutMapping(path = "/modifyProduct",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
  	public ProductResponse modifyProduct(@RequestBody ProductDetailsDto bean) {
    	 ProductResponse response=new ProductResponse();
  		if(productService.modifyProduct(bean)) {
  			response.setStatuscode(200);
  			response.setMessage("product data modified succesfully  !!");
  			response.setDescription("product data modified succesfully  !!");
  			
  		}
  		else {
  			response.setStatuscode(444);
  			response.setMessage("product Modification unsuccessful !!");
  			response.setMessage("product Modification unsuccessful !!");
  			
  		}
  		
  		return response;
  	}
 	
     @PostMapping(path = "/viewSingleProduct", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  	public ProductResponse viewSingleProduct(@RequestBody ProductDetailsDto bean) {
  		ProductDetailsDto productDetailsDto = productService.viewParticularProduct(bean.getProductId());
  		ProductResponse response = new ProductResponse();
  		if (productDetailsDto != null) {
  			response.setStatuscode(201);
  			response.setMessage("product data found !!");
  			response.setDescription("product data found !!");
  			response.setBean(Arrays.asList(productDetailsDto));

  		} else {
  			response.setStatuscode(444);
  			response.setMessage("Invalid product id !!");
  			response.setDescription("Invalid product id !! ");
  		}
  		return response;
  	}// end of add User
 	
     
     
     
     
     
	
	
	
	
}
