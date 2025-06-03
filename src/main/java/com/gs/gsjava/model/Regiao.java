package com.gs.gsjava.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "regiao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Regiao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRegiao;

    @NotBlank
    private String nome;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @DecimalMin("0.00")
    @DecimalMax("1.00")
    private Double vulnerabilidade;
    
    public Regiao () {}

	public Regiao(Long idRegiao, @NotBlank String nome, @NotNull Double latitude, @NotNull Double longitude,
			@DecimalMin("0.00") @DecimalMax("1.00") Double vulnerabilidade) {
		super();
		this.idRegiao = idRegiao;
		this.nome = nome;
		this.latitude = latitude;
		this.longitude = longitude;
		this.vulnerabilidade = vulnerabilidade;
	}

	public Long getIdRegiao() {
		return idRegiao;
	}

	public void setIdRegiao(Long idRegiao) {
		this.idRegiao = idRegiao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getVulnerabilidade() {
		return vulnerabilidade;
	}

	public void setVulnerabilidade(Double vulnerabilidade) {
		this.vulnerabilidade = vulnerabilidade;
	}
    
    
}


