package com.gs.gsjava.dto;

import com.gs.gsjava.model.Regiao;
import com.gs.gsjava.model.Usuario;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    
    public UsuarioDTO() {
    }


    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getIdUsuario();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.tipo = usuario.getTipo();
        this.idRegiao = usuario.getRegiao() != null ? usuario.getRegiao().getIdRegiao() : null;
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
