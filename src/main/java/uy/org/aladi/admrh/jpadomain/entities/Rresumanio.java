package uy.org.aladi.admrh.jpadomain.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the rresumanio database table.
 * 
 */
@Entity
@Table(name="rresumanio")
public class Rresumanio implements Serializable {
	private static final long serialVersionUID = 1L;


	private Long idRResumanio;
	private Short dias;
	private String horas;
	private Rcodigos rcodigos;
	private Gplanta gplanta;
	private String mesnro;
	private Short tarjeta;
	private Short veces;

	public Rresumanio() {
	}

	public Rresumanio(Gplanta gplanta, Rcodigos rcodigos, String mesnro, Short dias, String horas,  
			Short tarjeta){
		this.gplanta = gplanta;
		this.rcodigos = rcodigos;
		this.mesnro = mesnro;
		this.dias = dias;
		this.horas = horas;
		this.tarjeta = tarjeta;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idRResumanio", unique = true, nullable = false)
	public Long getIdRResumanio() {
		return this.idRResumanio;
	}

	public void setIdRResumanio(Long idRResumanio) {
		this.idRResumanio = idRResumanio;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRCodigos", nullable = false)
	@NotNull
	public Rcodigos getRcodigos() {
		return this.rcodigos;
	}

	public void setRcodigos(Rcodigos rcodigos) {
		this.rcodigos = rcodigos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idGPlanta", nullable = false)
	@NotNull
	public Gplanta getGplanta() {
		return this.gplanta;
	}

	public void setGplanta(Gplanta gplanta) {
		this.gplanta = gplanta;
	}

	@Column(name = "Mesnro")
	public String getMesnro() {
		return this.mesnro;
	}

	public void setMesnro(String mesnro) {
		this.mesnro = mesnro;
	}

	@Column(name="Dias")
	public Short getDias() {
		return this.dias;
	}

	public void setDias(Short dias) {
		this.dias = dias;
	}

	@Column(name = "Horas")
	public String getHoras() {
		return this.horas;
	}

	public void setHoras(String horas) {
		this.horas = horas;
	}

	@Column(name = "Tarjeta", nullable = false)
	public Short getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

	@Column(name="Veces")
	public Short getVeces() {
		return this.veces;
	}

	public void setVeces(Short veces) {
		this.veces = veces;
	}

}