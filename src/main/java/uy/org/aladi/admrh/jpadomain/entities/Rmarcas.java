package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rmarcas database table.
 * 
 */
@Entity
@Table(name="rmarcas")
public class Rmarcas implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idrmarcas;

	private String ceros;
	private String tarjeta;
	private String fecha;
	private String hora;
	private String minutos;
	private String segundos;
	private String resto;



	public Rmarcas() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdrmarcas() {
		return this.idrmarcas;
	}

	public void setIdrmarcas(Long idrmarcas) {
		this.idrmarcas = idrmarcas;
	}

	public String getCeros() {
		return ceros;
	}

	public void setCeros(String ceros) {
		this.ceros = ceros;
	}

	public String getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getMinutos() {
		return minutos;
	}

	public void setMinutos(String minutos) {
		this.minutos = minutos;
	}

	public String getSegundos() {
		return segundos;
	}

	public void setSegundos(String segundos) {
		this.segundos = segundos;
	}

	public String getResto() {
		return resto;
	}

	public void setResto(String resto) {
		this.resto = resto;
	}

}