package com.gama.passagens.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.gama.passagens.model.enums.TipoDocumento;

@Entity
@Table(name = "tab_cliente")
public class Cliente extends Usuario {
	
	@Column(length = 60)
	private String nome;
	
	@Column(name = "numero_docto", length = 30)
	private String numeroDocumento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_docto", length = 10)
	private TipoDocumento tipoDocumento;
	
	@Column(length = 15)
	private String cpfCnpj;
	
	@Column(length = 60)
	private String email;
	
	@Embedded
	private Telefone telefone;
	
	@Embedded
	 @AttributeOverrides({
	    @AttributeOverride(name="ddd",column=@Column(name="emergencia_ddd")),
	    @AttributeOverride(name="numero",column=@Column(name="emergencia_numero")),
	    @AttributeOverride(name="nomeContato",column=@Column(name="emergencia_nome_contato"))
	  })
	private Telefone telefoneEmergencia;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Telefone getTelefoneEmergencia() {
		return telefoneEmergencia;
	}

	public void setTelefoneEmergencia(Telefone telefoneEmergencia) {
		this.telefoneEmergencia = telefoneEmergencia;
	}


	
}
