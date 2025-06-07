package com.gs.gsjava.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "alerta")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAlerta;

    @ManyToOne
    @JoinColumn(name = "id_regiao", nullable = false)
    private Regiao regiao;

    @NotNull
    @Pattern(regexp = "CALOR|FRIO")
    private String tipo;

    @NotNull
    @Pattern(regexp = "BAIXA|MEDIA|ALTA")
    private String severidade;

    @NotNull
    private LocalDateTime dataHora;

    @NotBlank
    @Size(max = 200)
    private String mensagem;
    
    

	public Long getIdAlerta() {
		return idAlerta;
	}

	public void setIdAlerta(Long idAlerta) {
		this.idAlerta = idAlerta;
	}

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSeveridade() {
		return severidade;
	}

	public void setSeveridade(String severidade) {
		this.severidade = severidade;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
    
    
}
