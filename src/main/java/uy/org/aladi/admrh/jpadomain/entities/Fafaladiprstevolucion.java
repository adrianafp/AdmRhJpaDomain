package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;


/**
 * The persistent class for the fafaladiprstevolucion database table.
 * 
 */
@Entity
@Table(name = "fafaladiprstevolucion")
public class Fafaladiprstevolucion implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idFafaladiPrstEvolucion;
	private Fafaladiprestamos fafaladiprestamos;
	private Short nroCuota;
	private BigDecimal saldoPrestamo;
	private BigDecimal valorCuota;

	public Fafaladiprstevolucion() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdFafaladiPrstEvolucion() {
		return this.idFafaladiPrstEvolucion;
	}

	public void setIdFafaladiPrstEvolucion(Integer idFafaladiPrstEvolucion) {
		this.idFafaladiPrstEvolucion = idFafaladiPrstEvolucion;
	}

	@Column(name="NroCuota")
	public Short getNroCuota() {
		return this.nroCuota;
	}

	public void setNroCuota(Short nroCuota) {
		this.nroCuota = nroCuota;
	}

	@Column(name="SaldoPrestamo")
	public BigDecimal getSaldoPrestamo() {
		return this.saldoPrestamo;
	}

	public void setSaldoPrestamo(BigDecimal saldoPrestamo) {
		this.saldoPrestamo = saldoPrestamo;
	}

	@Column(name="ValorCuota")
	public BigDecimal getValorCuota() {
		return this.valorCuota;
	}

	public void setValorCuota(BigDecimal valorCuota) {
		this.valorCuota = valorCuota;
	}

	@ManyToOne
	@JoinColumn(name="idFafaladiPrestamos", nullable=false)
	@NotNull
	public Fafaladiprestamos getFafaladiprestamos() {
		return fafaladiprestamos;
	}

	public void setFafaladiprestamos(Fafaladiprestamos fafaladiprestamos) {
		this.fafaladiprestamos = fafaladiprestamos;
	}

}