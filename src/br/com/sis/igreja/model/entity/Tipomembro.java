package br.com.sis.igreja.model.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

/**
 * The persistent class for the tipomembros database table.
 * 
 */
@Entity
@Table(name = "tipomembros")
@NamedQuery(name = "Tipomembro.findAll", query = "SELECT t FROM Tipomembro t")
public class Tipomembro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTipoMembros;

	private String descricao;

	private String nome;

	// bi-directional many-to-one association to Membro
	@OneToMany(mappedBy = "tipomembro")
	private List<Membro> membros;

	public Tipomembro() {
	}

	public int getIdTipoMembros() {
		return this.idTipoMembros;
	}

	public void setIdTipoMembros(int idTipoMembros) {
		this.idTipoMembros = idTipoMembros;
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

	public Membro addMembro(Membro membro) {
		getMembros().add(membro);
		membro.setTipomembro(this);

		return membro;
	}

	public Membro removeMembro(Membro membro) {
		getMembros().remove(membro);
		membro.setTipomembro(null);

		return membro;
	}
	
	@PrePersist
	public void prePersist(){
		System.err.println("Persistindo um novo objeto com persist () ou merge () ... ");
	}

	@PostPersist
	public void postPersist(){
		System.err.println("O comando insert foi executado no banco de dados ... ");
		System.err.println("Um rollback ainda pode desfazer o comando insert ... ");
	}

	@PreRemove
	public void preRemove(){
		System.err.println("Removendo um objeto gerenciado com remove () ... ");
	}

	@PostRemove
	public void postRemove(){
		System.err.println("O comando delete foi executado no banco de dados ... ");
		System.err.println("Um rollback ainda pode desfazer o comando delete ... ");
	}

	@PreUpdate
	public void preUpdate(){
		System.err.println("O comando update executará no banco de dados ... ");
	}

	@PostUpdate
	public void postUpdate(){
		System.err.println("O comando update foi executado no banco de dados ... ");
		System.err.println("Um rollback ainda pode desfazer o comando update ... ");
	}

	@PostLoad
	public void postLoad (){
		System.err.println("Um objeto foi carregado com os dados do banco de dados .");
	}

}
