package br.com.sis.igreja.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.sis.igreja.model.dao.TipoMembroDAO;
import br.com.sis.igreja.model.entity.Tipomembro;
import br.com.sis.igreja.util.JPAUtil;

@ManagedBean
@ViewScoped
public class TipoMembroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Tipomembro tipoMembro = new Tipomembro();
	private DataModel<Tipomembro> tipoMembros;
	
	public int getTipoMembroLength() { 
		return this.tipoMembros.getRowCount(); 
	}

	public Tipomembro getTipoMembro() {
		return tipoMembro;
	}

	public void setTipoMembro(Tipomembro tipoMembro) {
		this.tipoMembro = tipoMembro;
	}
	
	@PostConstruct
	public void init() {
		try {
			System.err.println("executando o init");
			TipoMembroDAO dao = new TipoMembroDAO(JPAUtil.getManager());
			tipoMembros = new ListDataModel<Tipomembro>(dao.getBeans());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DataModel<Tipomembro> findAll() {
		return tipoMembros;
	}

	public void incluirTipoMembro() {
		tipoMembro = new Tipomembro();
	}

	public void incluirMembro() {
		try {
			TipoMembroDAO dao = new TipoMembroDAO(JPAUtil.getManager());
			dao.salvar(tipoMembro);

			JPAUtil.adiconaMensagem(FacesMessage.SEVERITY_INFO,
					"TipoMembro cadastrado com sucesso", "");
		} catch (Exception e) {
			e.printStackTrace();
			JPAUtil.adiconaMensagem(FacesMessage.SEVERITY_FATAL,
					"Ocorreu um erro ao cadastrar o TipoMembro", e.getMessage());
		}
	}

	public void alterarTipoMembro() {
		tipoMembro = tipoMembros.getRowData();
	}

	public void alterarTipoMembroProcessa() {
		try {
			TipoMembroDAO dao = new TipoMembroDAO(JPAUtil.getManager());
			dao.atualizar(tipoMembro);

			JPAUtil.adiconaMensagem(FacesMessage.SEVERITY_INFO,
					"Dados do TipoMembro alterados com sucesso", "");
		} catch (Exception e) {
			e.printStackTrace();
			JPAUtil.adiconaMensagem(FacesMessage.SEVERITY_FATAL,
					"Ocorreu um erro ao alterar os dados do TipoMembro",
					e.getMessage());
		}
	}

	public void excluirTipoMembro() {
		try {
			tipoMembro = tipoMembros.getRowData();
			TipoMembroDAO dao = new TipoMembroDAO(JPAUtil.getManager());
			dao.excluir(tipoMembro);

			JPAUtil.adiconaMensagem(FacesMessage.SEVERITY_INFO,
					"Dados do Cliente excluído com sucesso", "");
		} catch (Exception e) {
			e.printStackTrace();
			JPAUtil.adiconaMensagem(FacesMessage.SEVERITY_FATAL,
					"Ocorreu um erro ao excluir o cliente", e.getMessage());
		}
	}
}
