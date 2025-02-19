package com.hexaware.restapi.service;

import java.util.List;

import com.hexaware.restapi.dto.ProductDTO;
import com.hexaware.restapi.entity.Product;

public interface IProductService {

	
	 public  Product   addProduct(ProductDTO productDTO);
	 
	 public  ProductDTO  getById(int pid);
	 
	 public List<Product>  getAllProducts();
	
	 public Product updateProduct(ProductDTO productDTO);
	 
	 public void deleteProductById(int id);
	
}
