package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class CapitalesDisponiblesSerieSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2846175161937105197L;

	private Short tarjeta;
	private String nombre;
	private BigDecimal[] serie;
	
	public CapitalesDisponiblesSerieSummary(){}
	
	public CapitalesDisponiblesSerieSummary(Short tarjeta, String nombre, Integer size){
		this.tarjeta = tarjeta;
		this.nombre = nombre;
		this.serie = new BigDecimal[size];
	}

	public BigDecimal[] getSerie() {
		return serie;
	}

	public void setSerie(BigDecimal[] serie) {
		this.serie = serie;
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
}
