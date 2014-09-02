package br.com.sis.igreja.controller;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class UsuarioMB implements Serializable {

	private static final long serialVersionUID = 1L;
	private String linguaEscolhida;
	private Locale locale = new Locale("pt", "BR");

	public String getLinguaEscolhida() {
		return linguaEscolhida;
	}

	public void setLinguaEscolhida(String linguaEscolhida) {
		this.linguaEscolhida = linguaEscolhida;
	}

	public void alterarIdioma() {
		FacesContext instance = FacesContext.getCurrentInstance();
		if (linguaEscolhida.equals("en")) {
			locale = Locale.US;
			instance.getViewRoot().setLocale(locale);
		} else if(linguaEscolhida.equals("pt")) {
			locale = new Locale("pt", "BR");
			instance.getViewRoot().setLocale(locale);
		} else {
			locale = new Locale(linguaEscolhida);
			instance.getViewRoot().setLocale(locale);
		}
	}

	public Locale getLocale() {
		return locale;
	}
}