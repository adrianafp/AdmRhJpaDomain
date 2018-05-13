package uy.org.aladi.admrh.jpadomain.entities;

// Generated 06/10/2014 08:58:58 AM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Fadpermanentes generated by hbm2java
 */
@Entity
@Table(name = "fadpermanentes")
public class Fadpermanentes implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7581736716033408844L;
	private Long idFadpermanentes;
	private Fcodigos fcodigos;
	private Gplanta gplanta;
	private Short tarjeta;
	private String mesNro;
	private Date fechaDesde;
	private Date fechaHasta;
	private Integer orden;
	private Short sumaResta;
	private Short cantidad;
	private BigDecimal importe;
	private String moneda;
	private Short registro;

	public Fadpermanentes() {
	}

	public Fadpermanentes(Long idFadpermanentes, Fcodigos fcodigos,
			Gplanta gplanta, Short tarjeta, String mesNro, Short sumaResta,
			Short cantidad, BigDecimal importe, String moneda) {
		this.idFadpermanentes = idFadpermanentes;
		this.fcodigos = fcodigos;
		this.gplanta = gplanta;
		this.tarjeta = tarjeta;
		this.mesNro = mesNro;
		this.sumaResta = sumaResta;
		this.cantidad = cantidad;
		this.importe = importe;
		this.moneda = moneda;
	}

	public Fadpermanentes(Long idFadpermanentes, Fcodigos fcodigos,
			Gplanta gplanta, Short tarjeta, String mesNro, Date fechaDesde,
			Date fechaHasta, Integer orden, Short sumaResta, Short cantidad,
			BigDecimal importe, String moneda, Short registro) {
		this.idFadpermanentes = idFadpermanentes;
		this.fcodigos = fcodigos;
		this.gplanta = gplanta;
		this.tarjeta = tarjeta;
		this.mesNro = mesNro;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.orden = orden;
		this.sumaResta = sumaResta;
		this.cantidad = cantidad;
		this.importe = importe;
		this.moneda = moneda;
		this.registro = registro;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idFADPermanentes", unique = true, nullable = false)
	public Long getIdFadpermanentes() {
		return this.idFadpermanentes;
	}

	public void setIdFadpermanentes(Long idFadpermanentes) {
		this.idFadpermanentes = idFadpermanentes;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idFCodigos", nullable = false)
	@NotNull
	public Fcodigos getFcodigos() {
		return this.fcodigos;
	}

	public void setFcodigos(Fcodigos fcodigos) {
		this.fcodigos = fcodigos;
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

	@Column(name = "Tarjeta", nullable = false)
	public Short getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

	@Column(name = "MesNro", nullable = false, length = 6)
	@NotNull
	@Size(max = 6)
	public String getMesNro() {
		return this.mesNro;
	}

	public void setMesNro(String mesNro) {
		this.mesNro = mesNro;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FechaDesde", length = 10)
	public Date getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "FechaHasta", length = 10)
	public Date getFechaHasta() {
		return this.fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	@Column(name = "Orden")
	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	@Column(name = "SumaResta", nullable = false)
	public Short getSumaResta() {
		return this.sumaResta;
	}

	public void setSumaResta(Short sumaResta) {
		this.sumaResta = sumaResta;
	}

	@Column(name = "Cantidad", nullable = false)
	public Short getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Short cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "Importe", nullable = false, precision = 8)
	@NotNull
	public BigDecimal getImporte() {
		return this.importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	@Column(name = "Moneda", nullable = false, length = 7)
	@NotNull
	@Size(max = 7)
	public String getMoneda() {
		return this.moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	@Column(name = "Registro")
	public Short getRegistro() {
		return this.registro;
	}

	public void setRegistro(Short registro) {
		this.registro = registro;
	}

}
