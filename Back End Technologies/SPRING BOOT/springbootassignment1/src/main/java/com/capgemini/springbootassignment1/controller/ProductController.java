package com.capgemini.springbootassignment1.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.springbootassignment1.dto.ProductBean;
import com.capgemini.springbootassignment1.dto.ProductResponse;
import com.capgemini.springbootassignment1.service.ProductOperationService;

@RestController
public class ProductController {

	@Autowired
	private ProductOperationService service;
	
	
	@PostMapping(path="/addproduct",produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse addProduct(@RequestBody ProductBean bean) {
		ProductResponse response=new ProductResponse();
		if(service.addProduct(bean)) {
			//Added successfully
			response.setStatuscode(200);
			response.setMessage("Success !!");
			response.setDescription("Product Added Successfully !!");
		}
		else {
			//Added Unsuccessfully
			response.setStatuscode(444);
			response.setMessage("Failure !!");
			response.setMessage("Product insertion unsuccessful !!");
			
		}
		
		return response;
	}//end of add product
	
	@DeleteMapping(path = "/deleteproduct/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse deleteProduct(@PathVariable("id")int id) {
		ProductResponse response=new ProductResponse();
		
		if(service.deleteProduct(id)) {
			//Deletion successfully
			response.setStatuscode(200);
			response.setMessage("Success !!");
			response.setDescription("Product deleted Successfully !!");
		}
		else {
			//Deletion unsuccessful Unsuccessfully
			response.setStatuscode(444);
			response.setMessage("Failure !!");
			response.setMessage("Product deletion unsuccessful !!");
		}
		return response;
	}//end of delete product
	
	@GetMapping(path = "/viewallproduct",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductBean> viewAllProduct() {
		ProductResponse response=new ProductResponse();
		List<ProductBean> result=service.getAllProductDetails();
		      return result;
		
	}//end of view all product
	
	
	@PostMapping(path = "/changeimageurl",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse changeImageUrl(@RequestParam("id")int id,@RequestParam("imgurl")String url) {
		ProductResponse response=new ProductResponse();
		if(service.changeImageUrl(id, url)) {
			response.setStatuscode(200);
			response.setMessage("Success !!");
			response.setDescription("Image Url changed successfully !!");
			
		}
		else {
			response.setStatuscode(444);
			response.setMessage("Failure !!");
			response.setMessage("Image Url couldn`t changeds !!");
			
		}
		
		return response;
	}
	
	
	
	
	
	
	
	
	
	
}
