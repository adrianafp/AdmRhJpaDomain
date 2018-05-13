package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;

public class ResumenSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9054009087036883459L;

	private String descripcion;
	private String valor;
	
	public ResumenSummary()
	{}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	
}
