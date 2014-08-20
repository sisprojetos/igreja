package br.com.sis.igreja.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.sis.igreja.util.JPAUtil;

public class PhaseListenerUtil implements PhaseListener{

	private static final long serialVersionUID = 1L;

	public void beforePhase(PhaseEvent fase) {
		System.out.println("Antes da fase: " + fase.getPhaseId());
		if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {
			EntityManager em = JPAUtil.getManager();
			if (em == null) {
				try {
					EntityManagerFactory factory = Persistence
							.createEntityManagerFactory("Sis_Igreja");
					em = factory.createEntityManager();
					em.getTransaction().begin();
					JPAUtil.setManager(em);
					System.out.println("Abriu Conexão");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void afterPhase(PhaseEvent fase) {
		System.out.println("Depois da fase: " + fase.getPhaseId());
		if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {
			EntityManager em = JPAUtil.getManager();
			if (em != null && em.isOpen()) {
				try {
					em.getTransaction().commit();
				} catch (Exception e) {
					e.printStackTrace();
					em.getTransaction().rollback();
				} finally {
					em.close();
					System.out.println("Fechou Conexão");
				}
			}
		}
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
