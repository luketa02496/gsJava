package com.gs.gsjava.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AlertaDTO {

    private Long id;

    @NotNull
    private Long idRegiao;

    @NotBlank
    @Pattern(regexp = "CALOR|FRIO")
    private String tipo;

    @NotBlank
    @Pattern(regexp = "BAIXA|MEDIA|ALTA")
    private String severidade;

    @NotNull
    private LocalDateTime dataHora;

    @NotBlank
    private String mensagem;
    
    public AlertaDTO() {
    }
    


	public AlertaDTO(Long id, @NotNull Long idRegiao, @NotBlank @Pattern(regexp = "CALOR|FRIO") String tipo,
			@NotBlank @Pattern(regexp = "BAIXA|MEDIA|ALTA") String severidade, @NotNull LocalDateTime dataHora,
			@NotBlank String mensagem) {
		super();
		this.id = id;
		this.idRegiao = idRegiao;
		this.tipo = tipo;
		this.severidade = severidade;
		this.dataHora = dataHora;
		this.mensagem = mensagem;
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
