package br.com.sis.igreja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

		private static final EntityManagerFactory emf =
				Persistence.createEntityManagerFactory("Sis_Igreja");
		
		public static EntityManager getEntityManager() {
			return emf.createEntityManager();
		}
}

