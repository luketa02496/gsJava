package com.gs.gsjava.dto;

import com.gs.gsjava.model.Regiao;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
public class RegiaoDTO {

    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @DecimalMin("0.00")
    @DecimalMax("1.00")
    private Double vulnerabilidade;
    
    public RegiaoDTO() {}
    
    
    public RegiaoDTO(Long id, @NotBlank String nome, @NotNull Double latitude, @NotNull Double longitude,
			@DecimalMin("0.00") @DecimalMax("1.00") Double vulnerabilidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.latitude = latitude;
		this.longitude = longitude;
		this.vulnerabilidade = vulnerabilidade;
	}



    public RegiaoDTO(Regiao regiao) {
        this.id = regiao.getIdRegiao();
        this.nome = regiao.getNome();
        this.latitude = regiao.getLatitude();
        this.longitude = regiao.getLongitude();
        this.vulnerabilidade = regiao.getVulnerabilidade();
    }


	public Regiao toEntity() {
        Regiao regiao = new Regiao();
        regiao.setIdRegiao(this.id);
        regiao.setNome(this.nome);
        regiao.setLatitude(this.latitude);
        regiao.setLongitude(this.longitude);
        regiao.setVulnerabilidade(this.vulnerabilidade);
        return regiao;
    }
    
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

