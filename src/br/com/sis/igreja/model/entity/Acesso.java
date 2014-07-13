package br.com.sis.igreja.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the acesso database table.
 * 
 */
@Entity
@NamedQuery(name="Acesso.findAll", query="SELECT a FROM Acesso a")
public class Acesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAcesso;

	private String descricao;

	private String nome;

	//bi-directional many-to-many association to Membro
	@ManyToMany(mappedBy="acessos")
	private List<Membro> membros;

	public Acesso() {
	}

	public int getIdAcesso() {
		return this.idAcesso;
	}

	public void setIdAcesso(int idAcesso) {
		this.idAcesso = idAcesso;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Membro> getMembros() {
		return this.membros;
	}

	public void setMembros(List<Membro> membros) {
		this.membros = membros;
	}

}