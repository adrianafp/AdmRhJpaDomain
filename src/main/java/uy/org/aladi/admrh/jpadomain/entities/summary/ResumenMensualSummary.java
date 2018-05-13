package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;

public class ResumenMensualSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9054009087036883459L;

	private String tarjeta;
	private String nombre;
	private String anioMes;
	private String descripcion;
	private Short veces;
	private Short dias;
	private String horas;
	
	public ResumenMensualSummary()
	{}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAnioMes() {
		return anioMes;
	}

	public void setAnioMes(String anioMes) {
		this.anioMes = anioMes;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Short getVeces() {
		return veces;
	}

	public void setVeces(Short veces) {
		this.veces = veces;
	}

	public Short getDias() {
		return dias;
	}

	public void setDias(Short dias) {
		this.dias = dias;
	}

	public String getHoras() {
		return horas;
	}

	public void setHoras(String horas) {
		this.horas = horas;
	}
	
	
	
}
