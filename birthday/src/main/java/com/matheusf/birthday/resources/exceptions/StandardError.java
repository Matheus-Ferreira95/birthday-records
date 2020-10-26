package com.matheusf.birthday.resources.exceptions;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer status;
	private OffsetDateTime timestamp;
	private String mensagem;
	private String path;
	
	public StandardError() {
	}

	public StandardError(Integer status, OffsetDateTime timestamp, String mensagem, String path) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.mensagem = mensagem;
		this.path = path;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public OffsetDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(OffsetDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}	
}