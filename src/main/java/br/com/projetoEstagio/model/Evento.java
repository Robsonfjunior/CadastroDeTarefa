package br.com.projetoEstagio.model;

import java.io.Serializable;

public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;

	private String numero;
	private String titulo;
	private String reponsavel;
	private String situacao;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getReponsavel() {
		return reponsavel;
	}

	public void setReponsavel(String reponsavel) {
		this.reponsavel = reponsavel;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
