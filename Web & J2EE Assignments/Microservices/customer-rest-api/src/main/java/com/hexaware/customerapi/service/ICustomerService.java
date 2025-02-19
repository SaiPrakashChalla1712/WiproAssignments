package com.hexaware.customerapi.service;

import java.util.List;

import com.hexaware.customerapi.dto.CustomerDTO;
import com.hexaware.customerapi.dto.CustomerProductVO;
import com.hexaware.customerapi.dto.Product;
import com.hexaware.customerapi.entity.Customer;

public interface ICustomerService {

	
	public Customer	addCustomer(CustomerDTO customerDTO);
	
	public CustomerDTO	getCustomerById(int customerId);
		
	public List<Customer>	getAllCustomer();
	
	public   CustomerProductVO   getCustomerAndProductById(int customerId);

	public void updateProductByCustomer(Product product);
	
	

	public Product insertProductByCust(Product product);
	public String deleteProductByCust(int id);
	
}
