package br.com.sis.igreja.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


import br.com.sis.igreja.model.entity.Membro;

public class MembroDAO implements InterfaceDAO<Membro> {

	private EntityManager manager;
	
	public MembroDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void salvar(Membro bean) throws Exception {
		manager.persist(bean);		
	}

	@Override
	public void atualizar(Membro bean) throws Exception {
		manager.merge(bean);		
	}

	@Override
	public void excluir(Membro bean) throws Exception {
		manager.remove(bean);		
	}

	@Override
	public Membro getBean(Integer id) throws Exception {
		return manager.find(Membro.class, id);
	}

	@Override
	public List<Membro> getBeans() throws Exception {
		Query query = manager.createQuery("SELECT s FROM Membro s");
		return query.getResultList();
	}

}
