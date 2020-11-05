package com.gama.passagens.infra.exceptions.config;

public enum ErrorType {
	ERRO_INTERNO("500", "000", "Erro interno sem causa mapeada"),
    CREDENCIAL_INVALIDA("400", "001", "Credencial Inválida %s"),
    EMAIL_EXISTENTE("400", "003", "Email %s já cadastrado na nossa base de dados"),
	
    ERRO_GENERICO("400", "999", "Erro generico");
    private final String tipo;
    private final String codigo;
    private final String mensagem;

    private ErrorType(String tipo, String codigo, String mensagem) {
        this.tipo = tipo;
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    public String getValue() {
        return this.name();
    }

    public String getCodigo() {
        return String.format("%s.%s", tipo, codigo);
    }
    public String getTipo() {
		return tipo;
	}

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String toString() {
        return String.format("C\u00f3digo da falha: %s = %s.", getCodigo(), getMensagem());
    }
}
