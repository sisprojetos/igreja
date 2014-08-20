package br.com.sis.igreja.util;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

public class JPAUtil {

	private static final String ENTITY_MANAGER = "entity_manager";
	
	public static void setManager(EntityManager em) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(ENTITY_MANAGER, em);
	}

	public static EntityManager getManager() {
		return (EntityManager) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(ENTITY_MANAGER);
	}
	
	public static void adiconaMensagem(Severity severity, String mensagem, String msg2) {
		FacesMessage message = new FacesMessage(severity, mensagem, msg2);
		FacesContext.getCurrentInstance().addMessage(null, message);

	}
}