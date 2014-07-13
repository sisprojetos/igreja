package br.com.sis.igreja.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the membros database table.
 * 
 */
@Entity
@Table(name="membros")
@NamedQuery(name="Membro.findAll", query="SELECT m FROM Membro m")
public class Membro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMembros;

	private String cpf;

	@Temporal(TemporalType.DATE)
	private Date dataNasc;

	private String email;

	private String login;

	@Temporal(TemporalType.DATE)
	private Date membroDesde;

	private String nome;

	private String observacao;

	private String rg;

	private String senha;

	private String sexo;

	//bi-directional many-to-many association to Acesso
	@ManyToMany
	@JoinTable(
		name="acessomembro"
		, joinColumns={
			@JoinColumn(name="IdMembro")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IdAcesso")
			}
		)
	private List<Acesso> acessos;

	//bi-directional many-to-one association to Endereco
	@ManyToOne
	@JoinColumn(name="IdEndereco")
	private Endereco endereco;

	//bi-directional many-to-one association to Igreja
	@ManyToOne
	@JoinColumn(name="IdIgreja")
	private Igreja igreja;

	//bi-directional many-to-one association to Tipomembro
	@ManyToOne
	@JoinColumn(name="IdTipoMembros")
	private Tipomembro tipomembro;

	//bi-directional many-to-many association to Telefone
	@ManyToMany(mappedBy="membros")
	private List<Telefone> telefones;

	public Membro() {
	}

	public int getIdMembros() {
		return this.idMembros;
	}

	public void setIdMembros(int idMembros) {
		this.idMembros = idMembros;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNasc() {
		return this.dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Date getMembroDesde() {
		return this.membroDesde;
	}

	public void setMembroDesde(Date membroDesde) {
		this.membroDesde = membroDesde;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public List<Acesso> getAcessos() {
		return this.acessos;
	}

	public void setAcessos(List<Acesso> acessos) {
		this.acessos = acessos;
	}

	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Igreja getIgreja() {
		return this.igreja;
	}

	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
	}

	public Tipomembro getTipomembro() {
		return this.tipomembro;
	}

	public void setTipomembro(Tipomembro tipomembro) {
		this.tipomembro = tipomembro;
	}

	public List<Telefone> getTelefones() {
		return this.telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

}