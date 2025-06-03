package com.gs.gsjava.dto;

import com.gs.gsjava.model.Regiao;
import com.gs.gsjava.model.Sensor;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SensorDTO {

    private Long id;

    @NotNull
    private Long idRegiao;

    @NotBlank
    private String modelo;

    @NotBlank
    @Pattern(regexp = "ATIVO|INATIVO|MANUTENCAO")
    private String status;

    @NotNull
    private LocalDate dataInstalacao;
    
    public SensorDTO() {
    }

    public SensorDTO(Sensor sensor) {
        this.id = sensor.getIdSensor();
        this.idRegiao = sensor.getRegiao() != null ? sensor.getRegiao().getIdRegiao() : null;
        this.modelo = sensor.getModelo();
        this.status = sensor.getStatus();
        this.dataInstalacao = sensor.getDataInstalacao();
    }

    public Sensor toEntity(Regiao regiao) {
        Sensor sensor = new Sensor();
        sensor.setIdSensor(this.id);
        sensor.setModelo(this.modelo);
        sensor.setStatus(this.status);
        sensor.setDataInstalacao(this.dataInstalacao);
        sensor.setRegiao(regiao);
        return sensor;
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
