package uy.org.aladi.admrh.jpadomain.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;


import javax.persistence.*;


/**
 * The persistent class for the rresumenhis database table.
 * 
 */
@Entity
@Table(name="rresumenhis")
public class Rresumenhis implements Serializable {
	private static final long serialVersionUID = 1L;


	private Long idRResumenHis;
	private Short dias;
	private String horas;
	private Long idGPlanta;
	private Short idRCodigos;
	private String mesnro;
	private Short tarjeta;
	private Short veces;

	public Rresumenhis() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idRResumenHis", unique = true, nullable = false)
	public Long getIdRResumenHis() {
		return this.idRResumenHis;
	}

	public void setIdRResumenHis(Long idRResumenHis) {
		this.idRResumenHis = idRResumenHis;
	}

	public Short getDias() {
		return this.dias;
	}

	public void setDias(Short dias) {
		this.dias = dias;
	}

	public String getHoras() {
		return this.horas;
	}

	public void setHoras(String horas) {
		this.horas = horas;
	}

	public Long getIdGPlanta() {
		return this.idGPlanta;
	}

	public void setIdGPlanta(Long idGPlanta) {
		this.idGPlanta = idGPlanta;
	}

	public String getMesnro() {
		return this.mesnro;
	}

	public void setMesnro(String mesnro) {
		this.mesnro = mesnro;
	}

	public Short getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Short getVeces() {
		return this.veces;
	}

	public void setVeces(Short veces) {
		this.veces = veces;
	}

	public Short getIdRCodigos() {
		return idRCodigos;
	}

	public void setIdRCodigos(Short idRCodigos) {
		this.idRCodigos = idRCodigos;
	}

}