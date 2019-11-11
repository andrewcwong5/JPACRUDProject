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
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Buffets");
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Buffets findById(int id) {
		return em.find(Buffets.class, id);
	}

	@Override
	public List<Buffets> findAll() {
		String jpql = "SELECT f FROM buffets f";
		
		List<Buffets> buffets = em.createQuery(jpql, Buffets.class).getResultList();
		for (Buffets buffet : buffets) {
			System.out.println(buffet);
		}
		return null;
	}

	@Override
	public boolean createBuffet(Buffets buffet) {
        em.getTransaction().begin();
        em.persist(buffet);
        em.flush();
        em.getTransaction().commit();
        em.close();
		return false;
	}

	@Override
	public Buffets getBuffet(int id) {
		 return em.find(Buffets.class, id);
	}

	@Override
	public int bulkUpdate(String oldFn, String newFn) {
		String updateJpql = "UPDATE Buffets buffet SET buffet.name = :newName WHERE buffet.name = :oldName";
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.flush();   // flush pending changes to the database
        em.clear();   // clean up current persistence context
        
        int numChanged = em.createQuery(updateJpql)
           .setParameter("newFn",  newFn)
           .setParameter("oldFn",  oldFn)
           .executeUpdate();
        
        em.getTransaction().commit();
        return numChanged;
	}

	@Override
	public boolean deleteBuffet(int id) {
		boolean success = false;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        // find managed address to remove
        Buffets buffet = em.find(Buffets.class, id);
        if (buffet != null) {
            em.remove(buffet);
        }
        success = ! em.contains(buffet); 
        em.getTransaction().commit();
        return success;
	}

}
