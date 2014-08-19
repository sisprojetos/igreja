package br.com.sis.igreja.model.dao;

import java.util.List;

public interface InterfaceDAO<T> {

	public void salvar(T bean) throws Exception;
	public void atualizar(T bean) throws Exception;
	public void excluir(T bean) throws Exception;
	public T getBean(Integer id) throws Exception;
	public List<T> getBeans() throws Exception;
}
