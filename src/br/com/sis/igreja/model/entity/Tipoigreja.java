package br.com.sis.igreja.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipoigreja database table.
 * 
 */
@Entity
@NamedQuery(name="Tipoigreja.findAll", query="SELECT t FROM Tipoigreja t")
public class Tipoigreja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTipoIgreja;

	private String descricao;

	private String nome;

	//bi-directional many-to-one association to Igreja
	@OneToMany(mappedBy="tipoigreja")
	private List<Igreja> igrejas;

	public Tipoigreja() {
	}

	public int getIdTipoIgreja() {
		return this.idTipoIgreja;
	}

	public void setIdTipoIgreja(int idTipoIgreja) {
		this.idTipoIgreja = idTipoIgreja;
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

	public List<Igreja> getIgrejas() {
		return this.igrejas;
	}

	public void setIgrejas(List<Igreja> igrejas) {
		this.igrejas = igrejas;
	}

	public Igreja addIgreja(Igreja igreja) {
		getIgrejas().add(igreja);
		igreja.setTipoigreja(this);

		return igreja;
	}

	public Igreja removeIgreja(Igreja igreja) {
		getIgrejas().remove(igreja);
		igreja.setTipoigreja(null);

		return igreja;
	}

}