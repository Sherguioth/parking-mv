package io.github.sherguioth.app;

import javax.persistence.EntityManager;

import io.github.sherguioth.config.JPAUtil;

public class Main {
	
	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManagerFactory().createEntityManager();
		System.out.println("Parece que todo al peluche");
		manager.close();
	}

}
