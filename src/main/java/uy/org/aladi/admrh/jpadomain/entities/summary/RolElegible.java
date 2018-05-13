package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;

public class RolElegible implements Serializable {


	private static final long serialVersionUID = 5411689881749503058L;

	private Long idRol;
	private String descripcion;
	private String descPublic;
	private Boolean selected;
	
	public RolElegible(){
		super();
	}

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescPublic() {
		return descPublic;
	}

	public void setDescPublic(String descPublic) {
		this.descPublic = descPublic;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
}
