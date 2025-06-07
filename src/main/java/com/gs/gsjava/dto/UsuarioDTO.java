package com.gs.gsjava.dto;

import com.gs.gsjava.model.Regiao;
import com.gs.gsjava.model.Usuario;
import jakarta.validation.constraints.*;
import lombok.*;

@Data

public class UsuarioDTO {

    private Long id;

    @NotBlank
    private String nome;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Pattern(regexp = "CIDADAO|AGENTE|ADMIN")
    private String tipo;

    private Long idRegiao;
    
    public UsuarioDTO() {}
    

    public UsuarioDTO(Long id, @NotBlank String nome, @Email @NotBlank String email,
			@NotBlank @Pattern(regexp = "CIDADAO|AGENTE|ADMIN") String tipo, Long idRegiao) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.tipo = tipo;
		this.idRegiao = idRegiao;
	}

	public UsuarioDTO(Usuario atualizado) {
		
	}


	public Usuario toEntity(Regiao regiao) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(this.id);
        usuario.setNome(this.nome);
        usuario.setEmail(this.email);
        usuario.setTipo(this.tipo);
        usuario.setRegiao(regiao);
        return usuario;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getIdRegiao() {
		return idRegiao;
	}

	public void setIdRegiao(Long idRegiao) {
		this.idRegiao = idRegiao;
	}
    
   

}
