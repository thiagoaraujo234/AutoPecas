package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Usuario extends DefaultEntity<Usuario> {


	private static final long serialVersionUID = 321139500355223596L;

	@Column(length = 14, nullable = false)
	private String cpf;

	@Column(length = 256, nullable = false)
	private String senha;
	
	@Column(length = 100, nullable = false)
	private String nome;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAniversario;

	@Column(length = 100)
	private String email;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
