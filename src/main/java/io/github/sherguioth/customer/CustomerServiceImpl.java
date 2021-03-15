package io.github.sherguioth.customer;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements ICustomerService{
	
	private final CustomerRepository repository;
	
	public CustomerServiceImpl() {
		repository = new CustomerRepository();
	}
	
	@Override
	public Optional<Customer> save(Customer customer) {
		return Optional.of(repository.save(customer));
	}

	@Override
	public Optional<Customer> findById(long id) {
		return Optional.of(repository.findById(id));
	}

	@Override
	public Optional<List<Customer>> findAll() {
		return Optional.of(repository.findAll());
	}

	@Override
	public void update(long id, Customer customer) {
		repository.update(customer);
	}

	@Override
	public void delete(long id) {
		Customer customer = repository.findById(id);
		repository.delete(customer);
	}
}
