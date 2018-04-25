package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.ListCreds;

public class ListCredsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MovieTheaterMadness");

	public void cleanUp(){
		emfactory.close();
	}

	public void insertAccessCode(ListCreds lc){
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(lc);
		em.getTransaction().commit();
		em.close();
	}

	public void deleteAccessCode(ListCreds toDelete) {
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

	public List<ListCreds> searchForAccessCodeByUsername(String usernameName) {
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

	
	public List<ListCreds> showAllItems(){

		EntityManager em = emfactory.createEntityManager();

		TypedQuery<ListCreds> typedQuery = em.createQuery("select lc from ListCreds lc", ListCreds.class);

		List<ListCreds> allItems = typedQuery.getResultList();

		em.close();

		return allItems;

	}



	public void updateAccessCode(ListCreds toEdit) {

		// TODO Auto-generated method stub

		EntityManager em = emfactory.createEntityManager();

		em.getTransaction().begin();

		

		em.merge(toEdit);

		em.getTransaction().commit();

		em.close();

	}
}
