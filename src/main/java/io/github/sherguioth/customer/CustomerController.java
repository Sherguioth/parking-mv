package io.github.sherguioth.customer;

import java.util.List;
import java.util.Optional;

public class CustomerController {
	
	private final ICustomerService service;
	
	public CustomerController() {
		service = new CustomerServiceImpl();
	}
	
	public Optional<Customer> save(Customer customer){
		return service.save(customer);
	}
	
	public Optional<List<Customer>> findAll(){
		return service.findAll();
	}
	
	public Optional<Customer> findById(long id){
		return service.findById(id);
	}
	
	public void update(Customer customer) {
		service.update(0, customer);
	}
	
	public void delete(long id) {
		service.delete(id);
	}
}
