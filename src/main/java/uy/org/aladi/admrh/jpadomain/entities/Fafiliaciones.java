package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the fafiliaciones database table.
 * 
 */
@Entity
@Table(name="fafiliaciones")

public class Fafiliaciones implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFAfiliaciones;

	private String codigoMutual;

	@Temporal(TemporalType.TIMESTAMP)
	@Column
	private Date fechaFin;

	@ManyToOne
	@JoinColumn(name="idFMutualistasPlanes")
	private Fmutualistasplanes fmutualistasplanes;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idGPlanta", nullable = false)
	private Gplanta gplanta;

	@Column
	private String nomAfiliado;

	@Column
	private String nroSocio;

	@Column
	private Short tarjeta;

	public Fafiliaciones() {
	}

	public Long getIdFAfiliaciones() {
		return this.idFAfiliaciones;
	}

	public void setIdFAfiliaciones(Long idFAfiliaciones) {
		this.idFAfiliaciones = idFAfiliaciones;
	}

	public String getCodigoMutual() {
		return this.codigoMutual;
	}

	public void setCodigoMutual(String codigoMutual) {
		this.codigoMutual = codigoMutual;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Fmutualistasplanes getFmutualistasplanes() {
		return fmutualistasplanes;
	}

	public void setFmutualistasplanes(Fmutualistasplanes fmutualistasplanes) {
		this.fmutualistasplanes = fmutualistasplanes;
	}

	public Gplanta getGplanta() {
		return gplanta;
	}

	public void setGplanta(Gplanta gplanta) {
		this.gplanta = gplanta;
	}

	public String getNomAfiliado() {
		return this.nomAfiliado;
	}

	public void setNomAfiliado(String nomAfiliado) {
		this.nomAfiliado = nomAfiliado;
	}

	public String getNroSocio() {
		return this.nroSocio;
	}

	public void setNroSocio(String nroSocio) {
		this.nroSocio = nroSocio;
	}

	public Short getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

}