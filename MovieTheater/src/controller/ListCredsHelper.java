package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.ListCreds;

/*
 * Joe Fazio
 * 4/18/18
 * Holds all entity manager functionality to include the queries that return back to the 
 * StartProgram for user accessibility.
 */


public class ListCredsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MovieTheaterMadness");

	public void cleanUp(){
		emfactory.close();
	}

	public void insertAccessCode(ListCreds lc){		//  Correlates to the add credential function on admin panel.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(lc);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteAccessCode(ListCreds toDelete) {	// Correlates to the delete credential function on the admin panel.
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCreds> typedQuery = em.createQuery("select lc from ListCreds lc where lc.username = :selectedUserName", ListCreds.class);
		typedQuery.setParameter("selectedUserName", toDelete.getUserName());
		typedQuery.setMaxResults(1);
		ListCreds result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListCreds> searchForAccessCodeByUsername(String usernameName) {  // Correlates to the initial logon function that returns the specific role a user has.
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCreds> typedQuery = em.createQuery("select lc from ListCreds lc where lc.username = :selectedUserName", ListCreds.class);
		typedQuery.setParameter("selectedUserName", usernameName);
     	List<ListCreds> foundAccessCodes = typedQuery.getResultList();
		em.close();
		return foundAccessCodes;

	}
	
	public List<ListCreds> searchForAccessCodeByRole(String RoleName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListCreds> typedQuery = em.createQuery("select lc from ListCreds lc where lc.role = :selectedRole", ListCreds.class);
		typedQuery.setParameter("selectedRole", RoleName);
		List<ListCreds> foundRole = typedQuery.getResultList();
		em.close();
		return foundRole;
	}
	

	public ListCreds searchForAccessCodeById(int id){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListCreds foundId = em.find(ListCreds.class, id);
		em.close();
		return foundId;

	}

	public List<ListCreds> searchAnAccessCode(String usernameName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
//		TypedQuery<ListCreds> typedQuery = em.createQuery("select lc from ListCreds lc where lc.username = :selectedUserName", ListCreds.class);
		TypedQuery<ListCreds> typedQuery = em.createQuery("select lc from ListCreds lc where lc.username = :selectedUserName", ListCreds.class);
		typedQuery.setParameter("selectedUserName", usernameName);
     	List<ListCreds> foundAccessCodes = typedQuery.getResultList();
     	em.close();
     	return foundAccessCodes;
	
	}

	
	public List<ListCreds> showAllItems(){    // Correlates to the list credential function on the admin panel.

		EntityManager em = emfactory.createEntityManager();

		TypedQuery<ListCreds> typedQuery = em.createQuery("select lc from ListCreds lc", ListCreds.class);

		List<ListCreds> allItems = typedQuery.getResultList();

		em.close();

		return allItems;

	}

	public void updateAccessCode(ListCreds toEdit) {   // Correlates to the update credential function on the admin panel.

		// TODO Auto-generated method stub

		EntityManager em = emfactory.createEntityManager();

		em.getTransaction().begin();

		

		em.merge(toEdit);

		em.getTransaction().commit();

		em.close();

	}
}
