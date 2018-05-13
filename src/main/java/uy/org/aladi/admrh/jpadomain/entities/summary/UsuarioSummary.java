package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;

public class UsuarioSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8644916312494364847L;
	private Long idusuario;
	private Long idGplanta;
	private String nombre;
	private String username;
	private String email;
	private String roles;
	
	
	public UsuarioSummary(){
		super();
	}
	
	public Long getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}

	public Long getIdGplanta() {
		return idGplanta;
	}

	public void setIdGplanta(Long idGplanta) {
		this.idGplanta = idGplanta;
	}
	
	
}
