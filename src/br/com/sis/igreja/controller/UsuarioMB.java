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

	public String getLinguaEscolhida() {
		return linguaEscolhida;
	}

	public void setLinguaEscolhida(String linguaEscolhida) {
		this.linguaEscolhida = linguaEscolhida;
	}

	private Locale locale;

	public String alterarIdioma() {
			locale = new Locale(linguaEscolhida);
			FacesContext instance = FacesContext.getCurrentInstance();
			instance.getViewRoot().setLocale(locale);
			return null;
		}
}