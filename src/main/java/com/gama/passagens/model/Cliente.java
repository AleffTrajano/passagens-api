package com.gama.passagens.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.gama.passagens.model.enums.TipoDocumento;

public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 60)
	private String nome;
	
	@Column(name = "numero_docto", length = 30)
	private String numeroDocumento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "numero_docto", length = 10)
	private TipoDocumento tipoDocumento;
	
	@Column(length = 15)
	private String cpfCnpj;
	
	@Column(length = 60)
	private String email;
	
	@Embedded
	private Telefone celular;
	
}
