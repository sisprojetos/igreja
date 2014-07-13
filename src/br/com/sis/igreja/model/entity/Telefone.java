package br.com.sis.igreja.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the telefone database table.
 * 
 */
@Entity
@NamedQuery(name="Telefone.findAll", query="SELECT t FROM Telefone t")
public class Telefone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTelefone;

	private String operadora;

	private String telefone;

	private String tipoTelefone;

	//bi-directional many-to-many association to Igreja
	@ManyToMany
	@JoinTable(
		name="telefoneigreja"
		, joinColumns={
			@JoinColumn(name="IdTelefone")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IdIgreja")
			}
		)
	private List<Igreja> igrejas;

	//bi-directional many-to-many association to Membro
	@ManyToMany
	@JoinTable(
		name="telefonemembro"
		, joinColumns={
			@JoinColumn(name="IdTelefone")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IdMembro")
			}
		)
	private List<Membro> membros;

	public Telefone() {
	}

	public int getIdTelefone() {
		return this.idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

	public String getOperadora() {
		return this.operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTipoTelefone() {
		return this.tipoTelefone;
	}

	public void setTipoTelefone(String tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public List<Igreja> getIgrejas() {
		return this.igrejas;
	}

	public void setIgrejas(List<Igreja> igrejas) {
		this.igrejas = igrejas;
	}

	public List<Membro> getMembros() {
		return this.membros;
	}

	public void setMembros(List<Membro> membros) {
		this.membros = membros;
	}

}