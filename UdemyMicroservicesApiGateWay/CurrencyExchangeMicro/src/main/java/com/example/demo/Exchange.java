package com.example.demo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Exchange {

	@Id
	private Long id;

	@Column(name="table_from")
	private String from;

	@Column(name="table_to")
	private String to;

	private BigDecimal convertionMultiple;
	private String EnvironmentVariable;
	private String portAddress;

	public Exchange() {
	}

	public String getPortAddress() {
		return portAddress;
	}

	public void setPortAddress(String portAddress) {
		this.portAddress = portAddress;
	}

	public Exchange(Long id, String from, String to, BigDecimal convertionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.convertionMultiple = convertionMultiple;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConvertionMultiple() {
		return convertionMultiple;
	}

	public void setConvertionMultiple(BigDecimal convertionMultiple) {
		this.convertionMultiple = convertionMultiple;
	}

	public String getEnvironmentVariable() {
		return EnvironmentVariable;
	}

	public void setEnvironmentVariable(String environmentVariable) {
		EnvironmentVariable = environmentVariable;
	}

	@Override
	public String toString() {
		return "Exchange [id=" + id + ", from=" + from + ", to=" + to + ", convertionMultiple=" + convertionMultiple + "]";
	}
}
