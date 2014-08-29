package br.com.sis.igreja.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.sis.igreja.model.entity.Tipomembro;

public class TipoMembroDAO implements InterfaceDAO<Tipomembro> {
	
	private EntityManager manager;
	
	public TipoMembroDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	@Override
	public void salvar(Tipomembro bean) throws Exception {
		manager.persist(bean);		
	}

	@Override
	public void atualizar(Tipomembro bean) throws Exception {
		manager.merge(bean);
	}

	@Override
	public void excluir(Tipomembro bean) throws Exception {
		manager.remove(bean);		
	}

	@Override
	public Tipomembro getBean(Integer id) throws Exception {
		return manager.find(Tipomembro.class, id);
	}

	@Override
	public List<Tipomembro> getBeans() throws Exception {
		//Query query = manager.createQuery("SELECT s FROM Tipomembro s");
		Query query = manager.createNamedQuery("Tipomembro.findAll");
		return query.getResultList();
	}
}
