package br.com.sis.igreja.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the igrejas database table.
 * 
 */
@Entity
@Table(name="igrejas")
@NamedQuery(name="Igreja.findAll", query="SELECT i FROM Igreja i")
public class Igreja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idIgreja;

	private String cnpj;

	@Temporal(TemporalType.DATE)
	private Date dataFundacao;

	private String nome;

	private String pastorResp;

	//bi-directional many-to-one association to Endereco
	@ManyToOne
	@JoinColumn(name="IdEndereco")
	private Endereco endereco;

	//bi-directional many-to-one association to Tipoigreja
	@ManyToOne
	@JoinColumn(name="IdTipoIgreja")
	private Tipoigreja tipoigreja;

	//bi-directional many-to-one association to Membro
	@OneToMany(mappedBy="igreja")
	private List<Membro> membros;

	//bi-directional many-to-many association to Telefone
	@ManyToMany(mappedBy="igrejas")
	private List<Telefone> telefones;

	public Igreja() {
	}

	public int getIdIgreja() {
		return this.idIgreja;
	}

	public void setIdIgreja(int idIgreja) {
		this.idIgreja = idIgreja;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Date getDataFundacao() {
		return this.dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPastorResp() {
		return this.pastorResp;
	}

	public void setPastorResp(String pastorResp) {
		this.pastorResp = pastorResp;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Tipoigreja getTipoigreja() {
		return this.tipoigreja;
	}

	public void setTipoigreja(Tipoigreja tipoigreja) {
		this.tipoigreja = tipoigreja;
	}

	public List<Membro> getMembros() {
		return this.membros;
	}

	public void setMembros(List<Membro> membros) {
		this.membros = membros;
	}

	public Membro addMembro(Membro membro) {
		getMembros().add(membro);
		membro.setIgreja(this);

		return membro;
	}

	public Membro removeMembro(Membro membro) {
		getMembros().remove(membro);
		membro.setIgreja(null);

		return membro;
	}

	public List<Telefone> getTelefones() {
		return this.telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

}