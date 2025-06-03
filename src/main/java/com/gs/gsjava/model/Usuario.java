package com.gs.gsjava.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @Email
    @NotBlank
    @Size(max = 100)
    @Column(unique = true)
    private String email;

    @NotNull
    @Pattern(regexp = "CIDADAO|AGENTE|ADMIN")
    private String tipo;

    @ManyToOne
    @JoinColumn(name = "id_regiao")
    private Regiao regiao;
    
    public Usuario () {}

	public Usuario(Long idUsuario, @NotBlank @Size(max = 100) String nome,
			@Email @NotBlank @Size(max = 100) String email,
			@NotNull @Pattern(regexp = "CIDADAO|AGENTE|ADMIN") String tipo, Regiao regiao) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.tipo = tipo;
		this.regiao = regiao;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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

	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}
    
    
}


