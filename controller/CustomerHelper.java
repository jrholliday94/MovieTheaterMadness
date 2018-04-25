package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import customer.Customer;

public class CustomerHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MovieTheaterMadness");

	public void cleanUp() {
		emfactory.close();
	}

	public void insertCustomer(Customer cust) { // Correlates to the add credential function on admin panel.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(cust);
		em.getTransaction().commit();
		em.close();
	}

}
