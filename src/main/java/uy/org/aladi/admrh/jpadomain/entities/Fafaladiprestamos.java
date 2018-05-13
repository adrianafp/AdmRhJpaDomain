package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the fafaladiprestamos database table.
 * 
 */
@Entity
@Table(name="fafaladiprestamos")
public class Fafaladiprestamos implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idFAfaladiPrestamos;
	private Short cantCuotas;
	private BigDecimal capitalPrestamo;
	private BigDecimal cuota;
	private Short cuotasPagas;
	private Date fechaPrestamo;
	private Date fechaSaldo;
	private Gplanta gplanta;
	private BigDecimal interesPrestamo;
	private Integer nroPrestamo;
	private Boolean prestamoNuevo;
	private Boolean prestamoSeguroSalud;
	private BigDecimal saldoPrestamo;
	private Short tarjeta;
	private String moneda;
	private List<Fafaladiprstevolucion> fafaladiprstevolucion = new ArrayList<Fafaladiprstevolucion>();
	

	public Fafaladiprestamos() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getIdFAfaladiPrestamos() {
		return this.idFAfaladiPrestamos;
	}

	public void setIdFAfaladiPrestamos(Integer idFAfaladiPrestamos) {
		this.idFAfaladiPrestamos = idFAfaladiPrestamos;
	}

	@Column(name="CantCuotas")
	public Short getCantCuotas() {
		return this.cantCuotas;
	}

	public void setCantCuotas(Short cantCuotas) {
		this.cantCuotas = cantCuotas;
	}

	@Column(name="CapitalPrestamo")
	public BigDecimal getCapitalPrestamo() {
		return this.capitalPrestamo;
	}

	public void setCapitalPrestamo(BigDecimal capitalPrestamo) {
		this.capitalPrestamo = capitalPrestamo;
	}

	@Column(name="Cuota")
	public BigDecimal getCuota() {
		return this.cuota;
	}

	public void setCuota(BigDecimal cuota) {
		this.cuota = cuota;
	}

	@Column(name="CuotasPagas")
	public Short getCuotasPagas() {
		return this.cuotasPagas;
	}

	public void setCuotasPagas(Short cuotasPagas) {
		this.cuotasPagas = cuotasPagas;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="FechaPrestamo", length=10)
	public Date getFechaPrestamo() {
		return this.fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="FechaSaldo", length=10)	
	public Date getFechaSaldo() {
		return this.fechaSaldo;
	}

	public void setFechaSaldo(Date fechaSaldo) {
		this.fechaSaldo = fechaSaldo;
	}

	@Column(name="InteresPrestamo")
	public BigDecimal getInteresPrestamo() {
		return this.interesPrestamo;
	}

	public void setInteresPrestamo(BigDecimal interesPrestamo) {
		this.interesPrestamo = interesPrestamo;
	}

	@Column(name="NroPrestamo")
	public Integer getNroPrestamo() {
		return this.nroPrestamo;
	}

	public void setNroPrestamo(Integer nroPrestamo) {
		this.nroPrestamo = nroPrestamo;
	}

	@Column(name="PrestamoNuevo")
	public Boolean getPrestamoNuevo() {
		return this.prestamoNuevo;
	}

	public void setPrestamoNuevo(Boolean prestamoNuevo) {
		this.prestamoNuevo = prestamoNuevo;
	}

	@Column(name="PrestamoSeguroSalud")
	public Boolean getPrestamoSeguroSalud() {
		return this.prestamoSeguroSalud;
	}

	public void setPrestamoSeguroSalud(Boolean prestamoSeguroSalud) {
		this.prestamoSeguroSalud = prestamoSeguroSalud;
	}

	@Column(name="SaldoPrestamo")
	public BigDecimal getSaldoPrestamo() {
		return this.saldoPrestamo;
	}

	public void setSaldoPrestamo(BigDecimal saldoPrestamo) {
		this.saldoPrestamo = saldoPrestamo;
	}

	@Column(name="Tarjeta")
	public Short getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

	@Column(name="Moneda")
	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	@ManyToOne
	@JoinColumn(name="idGPlanta", nullable=false)
	@NotNull
	public Gplanta getGplanta() {
		return gplanta;
	}

	public void setGplanta(Gplanta gplanta) {
		this.gplanta = gplanta;
	}

	@OneToMany(mappedBy = "fafaladiprestamos", cascade=CascadeType.MERGE)
	public List<Fafaladiprstevolucion> getFafaladiprstevolucion() {
		return fafaladiprstevolucion;
	}

	public void setFafaladiprstevolucion(List<Fafaladiprstevolucion> fafaladiprstevolucion) {
		this.fafaladiprstevolucion = fafaladiprstevolucion;
	}

}