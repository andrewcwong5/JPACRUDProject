package com.skilldistillery.buffets.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.buffets.entities.Buffets;

@Transactional
@Service
public class BuffetDAOJpaImpl implements BuffetDAO{
	// EntityManagerFactory emf = Persistence.createEntityManagerFactory("Buffets");
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Buffets findById(int id) {
		return em.find(Buffets.class, id);
	}

	@Override
	public List<Buffets> findAll() {
		String jpql = "SELECT f FROM buffets f";
//		return em.createQuery(jpql, Buffets.class).getResultList();
		
		List<Buffets> buffets = em.createQuery(jpql, Buffets.class).getResultList();
//		for (Buffets buffet : buffets) {
//			System.out.println(buffet);
//		}
		return buffets;
	}
	
	@Override
	public Buffets createBuffet(Buffets buffet) {
//        em.getTransaction().begin();
        em.persist(buffet);
        em.flush();
//        em.getTransaction().commit();
//        em.close();
        return buffet;
	}
	@Override
	public Buffets updateBuffet(int id, Buffets buffet) {
		Buffets updated = em.find(Buffets.class, id);
		updated.setId(buffet.getId());
		updated.setName(buffet.getName());
		updated.setAddress(buffet.getAddress());
		updated.setPhone(buffet.getPhone());
		updated.setLunchPrice(buffet.getLunchPrice());
		updated.setDinnerPrice(buffet.getDinnerPrice());
		updated.setType(buffet.getType());
		
		 // actually make changes
		em.merge(updated);
		return updated;
		
	}
        
//     // open a transaction
//        em.getTransaction().begin();
//
//        // create a "detached" customer entity
//        Customer detachedCustomer = new Customer();
//
//        // retrieve a "managed" customer entity
//        Customer managedCustomer = em.find(Customer.class, 1);
//
//        // update the values of the detached entity
//        detachedCustomer.setFirstName("Nope");
//        detachedCustomer.setLastName("Not Gonna Happen");
//
//        // update the values of the managed entity
//        managedCustomer.setFirstName("Will Update");
//        managedCustomer.setLastName("On Commit");
//
//        // actually make changes
//        em.getTransaction().commit();
//        // -> the detached entity's changes were not saved
//        // -> the managed entity's changes HAVE been saved

	@Override
	public boolean deleteBuffet(Buffets buffet) {
		boolean success = true;
////        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        // find managed buffet to remove
//        Buffets buffet = em.find(Buffets.class, id);
//        if (buffet != null) {
            em.remove(buffet);
//        }
//        success = ! em.contains(buffet); 
//        em.getTransaction().commit();
        return success;
	}


}
