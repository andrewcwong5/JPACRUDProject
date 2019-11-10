package com.skilldistillery.buffets.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.buffets.entities.Buffets;

@Transactional
@Service
public class BuffetDAOJpaImpl implements BuffetDAO{
	
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

}
