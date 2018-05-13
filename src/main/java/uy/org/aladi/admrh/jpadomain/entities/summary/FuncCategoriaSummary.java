package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.util.Date;

public class FuncCategoriaSummary implements Serializable{
	
	private static final long serialVersionUID = -6472408322835534940L;
	private Short tarjeta;
	private String nombre;
	private Date ingreso;
	private String grado;
	private String depto;
	private Boolean selected;
	
	public FuncCategoriaSummary(){
		
	}
	
	public FuncCategoriaSummary(Short tarjeta, String nombre, boolean selected){
		this.tarjeta = tarjeta;
		this.nombre = nombre;
		this.selected = selected;
	}
	
	
	public Short getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getIngreso() {
		return ingreso;
	}
	public void setIngreso(Date ingreso) {
		this.ingreso = ingreso;
	}

	public Boolean getSelected(){
		return selected;
	}
	
	public Boolean isSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}
	

}
