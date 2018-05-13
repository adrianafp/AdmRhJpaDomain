package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;

public class ActRegSummary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -40388269397239843L;
	private Short tarjeta;
	private String nombre;
	private String anioMes;
	private Short codigo;
	private String concepto;
	private Integer veces;
	private String horas;
	private Integer dias;
	
	public ActRegSummary(){}
	
	public ActRegSummary(Short tarjeta, String nombre){
		this.tarjeta = tarjeta;
		this.nombre = nombre;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public Integer getVeces() {
		return veces;
	}

	public void setVeces(Integer veces) {
		this.veces = veces;
	}

	public String getHoras() {
		return horas;
	}

	public void setHoras(String horas) {
		this.horas = horas;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
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

	public String getAnioMes() {
		return anioMes;
	}

	public void setAnioMes(String anioMes) {
		this.anioMes = anioMes;
	}

	public Short getCodigo() {
		return codigo;
	}

	public void setCodigo(Short codigo) {
		this.codigo = codigo;
	}
	
	
}
