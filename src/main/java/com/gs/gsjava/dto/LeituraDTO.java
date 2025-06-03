package com.gs.gsjava.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LeituraDTO {

    private Long id;

    @NotNull
    private Long idSensor;

    @NotNull
    private Double temperatura;

    @NotNull
    private Double umidade;

    @NotNull
    private LocalDateTime dataHora;
    
    public LeituraDTO() {
    }
    


	public LeituraDTO(Long id, @NotNull Long idSensor, @NotNull Double temperatura, @NotNull Double umidade,
			@NotNull LocalDateTime dataHora) {
		super();
		this.id = id;
		this.idSensor = idSensor;
		this.temperatura = temperatura;
		this.umidade = umidade;
		this.dataHora = dataHora;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdSensor() {
		return idSensor;
	}

	public void setIdSensor(Long idSensor) {
		this.idSensor = idSensor;
	}

	public Double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}

	public Double getUmidade() {
		return umidade;
	}

	public void setUmidade(Double umidade) {
		this.umidade = umidade;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
    
   
}
