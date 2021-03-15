package io.github.sherguioth.customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
	
	Optional<Customer> save(Customer customer);
	
	Optional<Customer> findById(long id);
	
	Optional<List<Customer>> findAll();
	
	void update(long id, Customer customer);
	
	void delete(long id);
}
