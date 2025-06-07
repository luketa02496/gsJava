package com.gs.gsjava.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "SENSOR")

public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sensor_seq")
    @SequenceGenerator(name = "sensor_seq", sequenceName = "sensor_seq", allocationSize = 1)
    @Column(name = "id_sensor")
    private Long idSensor;

    @ManyToOne
    @JoinColumn(name = "id_regiao", nullable = false)
    private Regiao regiao;

    @NotBlank
    @Size(max = 50)
    private String modelo;

    @NotNull
    @Pattern(regexp = "ATIVO|INATIVO|MANUTENCAO")
    private String status;

    @NotNull
    @Column(name = "data_instalacao")
    private LocalDate dataInstalacao;

    
    public Sensor() {}

    
    public Sensor(Long idSensor, Regiao regiao, @NotBlank @Size(max = 50) String modelo,
                  @NotNull @Pattern(regexp = "ATIVO|INATIVO|MANUTENCAO") String status,
                  @NotNull LocalDate dataInstalacao) {
        this.idSensor = idSensor;
        this.regiao = regiao;
        this.modelo = modelo;
        this.status = status;
        this.dataInstalacao = dataInstalacao;
    }


	public Long getIdSensor() {
		return idSensor;
	}


	public void setIdSensor(Long idSensor) {
		this.idSensor = idSensor;
	}


	public Regiao getRegiao() {
		return regiao;
	}


	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
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
