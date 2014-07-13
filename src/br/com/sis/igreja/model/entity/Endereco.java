package br.com.sis.igreja.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the endereco database table.
 * 
 */
@Entity
@NamedQuery(name="Endereco.findAll", query="SELECT e FROM Endereco e")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idEndereco;

	private String cep;

	private String complemento;

	private String numero;

	private String rua;

	//bi-directional many-to-one association to Cidade
	@ManyToOne
	@JoinColumn(name="IdCidade")
	private Cidade cidade;

	//bi-directional many-to-one association to Igreja
	@OneToMany(mappedBy="endereco")
	private List<Igreja> igrejas;

	//bi-directional many-to-one association to Membro
	@OneToMany(mappedBy="endereco")
	private List<Membro> membros;

	public Endereco() {
	}

	public int getIdEndereco() {
		return this.idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Igreja> getIgrejas() {
		return this.igrejas;
	}

	public void setIgrejas(List<Igreja> igrejas) {
		this.igrejas = igrejas;
	}

	public Igreja addIgreja(Igreja igreja) {
		getIgrejas().add(igreja);
		igreja.setEndereco(this);

		return igreja;
	}

	public Igreja removeIgreja(Igreja igreja) {
		getIgrejas().remove(igreja);
		igreja.setEndereco(null);

		return igreja;
	}

	public List<Membro> getMembros() {
		return this.membros;
	}

	public void setMembros(List<Membro> membros) {
		this.membros = membros;
	}

	public Membro addMembro(Membro membro) {
		getMembros().add(membro);
		membro.setEndereco(this);

		return membro;
	}

	public Membro removeMembro(Membro membro) {
		getMembros().remove(membro);
		membro.setEndereco(null);

		return membro;
	}

}