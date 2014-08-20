package br.com.sis.igreja.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import br.com.sis.igreja.model.dao.TipoMembroDAO;
import br.com.sis.igreja.model.entity.Tipomembro;
import br.com.sis.igreja.util.JPAUtil;

@ManagedBean
public class TipoMembroBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Tipomembro tipoMembro = new Tipomembro();
	private DataModel<Tipomembro> tipoMembros;
	private String codigoSituacao;

	public Tipomembro getTipoMembro() {
		return tipoMembro;
	}

	public void setTipoMembro(Tipomembro tipoMembro) {
		this.tipoMembro = tipoMembro;
	}

	public DataModel<Tipomembro> getTipomembros() {
		try{
			TipoMembroDAO dao = new TipoMembroDAO(JPAUtil.getManager());
//			if (tipoMembros == null) {
				tipoMembros = new ListDataModel<Tipomembro>(dao.getBeans());
//			}
			return tipoMembros;
		} catch(Exception e){
			e.printStackTrace();
		}
		return new ListDataModel<Tipomembro>();
	}
	
	public void incluirTipoMembro() {
		tipoMembro = new Tipomembro();
		codigoSituacao = "1";
	}

	public void incluirMembro() {
		try{
			TipoMembroDAO dao = new TipoMembroDAO(JPAUtil.getManager());
			dao.salvar(tipoMembro);

			JPAUtil.adiconaMensagem(FacesMessage.SEVERITY_INFO, "TipoMembro cadastrado com sucesso", "");
		} catch(Exception e){
			e.printStackTrace();
			JPAUtil.adiconaMensagem(FacesMessage.SEVERITY_FATAL, "Ocorreu um erro ao cadastrar o TipoMembro", e.getMessage());
		}
	}

	public void alterarTipoMembro() {
		tipoMembro = tipoMembros.getRowData();
	}

	public void alterarTipoMembroProcessa() {
		try{
			TipoMembroDAO dao = new TipoMembroDAO(JPAUtil.getManager());
			dao.atualizar(tipoMembro);
			
			JPAUtil.adiconaMensagem(FacesMessage.SEVERITY_INFO, "Dados do TipoMembro alterados com sucesso", "");
		} catch(Exception e){
			e.printStackTrace();
			JPAUtil.adiconaMensagem(FacesMessage.SEVERITY_FATAL, "Ocorreu um erro ao alterar os dados do TipoMembro", e.getMessage());
		}
	}

	public void excluirTipoMembro() {
		try{
			tipoMembro = tipoMembros.getRowData();
			TipoMembroDAO dao = new TipoMembroDAO(JPAUtil.getManager());
			dao.excluir(tipoMembro);
			
			JPAUtil.adiconaMensagem(FacesMessage.SEVERITY_INFO, "Dados do Cliente excluído com sucesso", "");
		} catch(Exception e){
			e.printStackTrace();
			JPAUtil.adiconaMensagem(FacesMessage.SEVERITY_FATAL, "Ocorreu um erro ao excluir o cliente", e.getMessage());
		}
	}
	
	
}
