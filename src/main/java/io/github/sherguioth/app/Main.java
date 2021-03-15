package io.github.sherguioth.app;

import javax.persistence.EntityManager;

import io.github.sherguioth.config.JPAUtil;
import io.github.sherguioth.customer.Customer;
import io.github.sherguioth.customer.CustomerController;

public class Main {
	
	public static void main(String[] args) {
		connTest();
		test();
	}

	public static void connTest() {
		EntityManager manager = JPAUtil.getEntityManagerFactory().createEntityManager();
		System.out.println("Parece que todo al peluche");
		manager.close();
	}
	
	public static void test() {
		Customer customer = new Customer();
		customer.setName("Customer 1");
		customer.setPhoneNumber("Phone 1");
		
		CustomerController controller = new CustomerController();
		controller.save(customer);
		
		System.out.println("Todo correcto, y yo que me alegro");
	}
}
