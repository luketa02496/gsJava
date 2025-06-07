package com.gs.gsjava.dto;

import com.gs.gsjava.model.Regiao;
import com.gs.gsjava.model.Sensor;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
public class SensorDTO {

    private Long id;
    private Long idRegiao;
    private String modelo;
    private String status;
    private LocalDate dataInstalacao;

    
    public SensorDTO() {}

    
    public SensorDTO(Long id, Long idRegiao, String modelo, String status, LocalDate dataInstalacao) {
        this.id = id;
        this.idRegiao = idRegiao;
        this.modelo = modelo;
        this.status = status;
        this.dataInstalacao = dataInstalacao;
    }

    public SensorDTO(Sensor sensor) {
        this.id = sensor.getIdSensor();
        this.idRegiao = sensor.getRegiao() != null ? sensor.getRegiao().getIdRegiao() : null;
        this.modelo = sensor.getModelo();
        this.status = sensor.getStatus();
        this.dataInstalacao = sensor.getDataInstalacao();
    }

   
    public Sensor toEntity(Regiao regiao) {
        return new Sensor(this.id, regiao, this.modelo, this.status, this.dataInstalacao);
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getIdRegiao() {
		return idRegiao;
	}


	public void setIdRegiao(Long idRegiao) {
		this.idRegiao = idRegiao;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public LocalDate getDataInstalacao() {
		return dataInstalacao;
	}


	public void setDataInstalacao(LocalDate dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}


	
}
