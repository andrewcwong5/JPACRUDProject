package com.skilldistillery.buffets.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class buffetsTest {

		private static EntityManagerFactory emf;
		private EntityManager em;
		private Buffets buffet;
		
		private List<Buffets> buffets ;
		
		@BeforeAll
		static void setUpBeforeClass() throws Exception {
				emf = Persistence.createEntityManagerFactory("Buffets");
		}

		@AfterAll
		static void tearDownAfterClass() throws Exception {
			emf.close();
		}

		@BeforeEach
		void setUp() throws Exception {
			em = emf.createEntityManager();
		}

		@AfterEach
		void tearDown() throws Exception {
			em.close();
			buffet=null;
		}

		@Test
		@DisplayName("test functionality")
		void test() {
			buffet = em.find(Buffets.class, 1);
			assertNotNull(buffet);
			assertEquals("Eater", buffet.getName());
//			assertEquals("5.00", buffet.getLunchPrice());
		}
		@Test
		@DisplayName("test ability to print a list")
		void test2() {
			String jpql = "SELECT f FROM buffets f";
			buffets = em.createQuery(jpql, Buffets.class).getResultList();
			assertNotNull(buffets);
			
		}

}
