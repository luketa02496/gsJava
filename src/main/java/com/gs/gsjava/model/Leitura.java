package com.gs.gsjava.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "leitura")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Leitura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLeitura;

    @ManyToOne
    @JoinColumn(name = "id_sensor", nullable = false)
    private Sensor sensor;

    @NotNull
    private Double temperatura;

    @NotNull
    private Double umidade;

    @NotNull
    private LocalDateTime dataHora;
    
    public Leitura () {}

	public Leitura(Long idLeitura, Sensor sensor, @NotNull Double temperatura, @NotNull Double umidade,
			@NotNull LocalDateTime dataHora) {
		super();
		this.idLeitura = idLeitura;
		this.sensor = sensor;
		this.temperatura = temperatura;
		this.umidade = umidade;
		this.dataHora = dataHora;
	}

	public Long getIdLeitura() {
		return idLeitura;
	}

	public void setIdLeitura(Long idLeitura) {
		this.idLeitura = idLeitura;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
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
