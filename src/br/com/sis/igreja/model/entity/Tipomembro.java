package br.com.sis.igreja.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipomembros database table.
 * 
 */
@Entity
@Table(name="tipomembros")
@NamedQuery(name="Tipomembro.findAll", query="SELECT t FROM Tipomembro t")
public class Tipomembro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTipoMembros;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to Membro
	@OneToMany(mappedBy="tipomembro")
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

}