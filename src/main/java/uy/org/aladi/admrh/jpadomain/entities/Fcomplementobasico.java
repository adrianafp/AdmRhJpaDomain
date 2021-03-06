package uy.org.aladi.admrh.jpadomain.entities;

// Generated 16/07/2015 12:21:19 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Fcomplementobasico generated by hbm2java
 */
@Entity
@Table(name = "fcomplementobasico")
public class Fcomplementobasico implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -812566103048923984L;
	private Integer idfcomplementobasico;
	private Long idGplanta;
	private Short tarjeta;
	private BigDecimal importeComplemento;
	private Date fechaDesde;
	private Date fechaHasta;

	public Fcomplementobasico() {
	}

	public Fcomplementobasico(Long idGplanta, Short tarjeta,
			BigDecimal importeComplemento, Date fechaDesde, Date fechaHasta) {
		this.idGplanta = idGplanta;
		this.tarjeta = tarjeta;
		this.importeComplemento = importeComplemento;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idfcomplementobasico", unique = true, nullable = false)
	public Integer getIdfcomplementobasico() {
		return this.idfcomplementobasico;
	}

	public void setIdfcomplementobasico(Integer idfcomplementobasico) {
		this.idfcomplementobasico = idfcomplementobasico;
	}

	@Column(name = "idGplanta")
	public Long getIdGplanta() {
		return this.idGplanta;
	}

	public void setIdGplanta(Long idGplanta) {
		this.idGplanta = idGplanta;
	}

	@Column(name = "tarjeta")
	public Short getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

	@Column(name = "importeComplemento", precision = 8)
	public BigDecimal getImporteComplemento() {
		return this.importeComplemento;
	}

	public void setImporteComplemento(BigDecimal importeComplemento) {
		this.importeComplemento = importeComplemento;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaDesde", length = 10)
	public Date getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaHasta", length = 10)
	public Date getFechaHasta() {
		return this.fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

}
