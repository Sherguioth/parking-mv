package io.github.sherguioth.customer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import io.github.sherguioth.config.IRepository;
import io.github.sherguioth.config.JPAUtil;

public class CustomerRepository implements IRepository<Customer, Long>{

	private EntityManager manager;
	
	public CustomerRepository() {
		manager = JPAUtil.getEntityManagerFactory().createEntityManager();
	}
	
	@Override
	public Customer save(Customer obj) {
		manager.getTransaction().begin();
		manager.persist(obj);
		manager.getTransaction().commit();
		return obj;
	}

	@Override
	public Customer findById(Long id) {
		return manager.find(Customer.class, id);
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customersList = new ArrayList<Customer>();
		Query query = manager.createQuery("from Customer");
		customersList = query.getResultList();
		return customersList;
	}

	@Override
	public void update(Customer obj) {
		manager.getTransaction().begin();
		manager.merge(obj);
		manager.getTransaction().commit();
	}

	@Override
	public void delete(Customer obj) {
		manager.getTransaction().begin();
		manager.remove(obj);
		manager.getTransaction().commit();
	}
}
