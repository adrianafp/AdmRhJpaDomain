package uy.org.aladi.admrh.jpadomain.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the fsolicitudprestamos database table.
 * 
 */
@Entity
@Table(name="fsolicitudprestamos")
public class Fsolicitudprestamos implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idFSolicitud;
	private Long idGplanta;
	private Integer idFtipoprestamo;
	private String cancelaPrstNros;
	private String cancelaPrstConsumo;
	private Short cantCuotas;
	private BigDecimal capitalPrestamo;
	private Short cesionTarjeta;
	private BigDecimal cuota;
	private Boolean enviadaAFondo;
	private Date fechaSolicitud;
	private BigDecimal interesPrestamo;
	private BigDecimal importeNeto;
	private Boolean enviadaAComision;
	private Boolean enviadaAFinanzas;
	private Boolean procesada;
	private Short tarjeta;
	private Short tipoPrestamo;
	private String motivo;
	private String moneda;
	

	public Fsolicitudprestamos() {
	}

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idFSolicitud", unique=true, nullable=false)
	public Integer getIdFSolicitud() {
		return this.idFSolicitud;
	}

	public void setIdFSolicitud(Integer idFSolicitud) {
		this.idFSolicitud = idFSolicitud;
	}

	@Column(name="CancelaPrstNros")
	public String getCancelaPrstNros() {
		return this.cancelaPrstNros;
	}

	public void setCancelaPrstNros(String cancelaPrstNros) {
		this.cancelaPrstNros = cancelaPrstNros;
	}

	@Column(name="CancelaPrstConsumo")
	public String getCancelaPrstConsumo() {
		return cancelaPrstConsumo;
	}

	public void setCancelaPrstConsumo(String cancelaPrstConsumo) {
		this.cancelaPrstConsumo = cancelaPrstConsumo;
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

	@Column(name="CesionTarjeta")
	public Short getCesionTarjeta() {
		return this.cesionTarjeta;
	}

	public void setCesionTarjeta(Short cesionTarjeta) {
		this.cesionTarjeta = cesionTarjeta;
	}

	@Column(name="Cuota")
	public BigDecimal getCuota() {
		return this.cuota;
	}

	public void setCuota(BigDecimal cuota) {
		this.cuota = cuota;
	}

	@Column(name="EnviadaAFondo")
	public Boolean getEnviadaAFondo() {
		return enviadaAFondo;
	}

	public void setEnviadaAFondo(Boolean enviadaAFondo) {
		this.enviadaAFondo = enviadaAFondo;
	}

	@Column(name="EnviadaAComision")
	public Boolean getEnviadaAComision() {
		return enviadaAComision;
	}

	public void setEnviadaAComision(Boolean enviadaAComision) {
		this.enviadaAComision = enviadaAComision;
	}

	@Column(name="EnviadaAFinanzas")
	public Boolean getEnviadaAFinanzas() {
		return enviadaAFinanzas;
	}

	public void setEnviadaAFinanzas(Boolean enviadaAFinanzas) {
		this.enviadaAFinanzas = enviadaAFinanzas;
	}

	@Column(name="FechaSolicitud")
	@Temporal(TemporalType.DATE)
	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	@Column(name="InteresPrestamo")
	public BigDecimal getInteresPrestamo() {
		return this.interesPrestamo;
	}

	public void setInteresPrestamo(BigDecimal interesPrestamo) {
		this.interesPrestamo = interesPrestamo;
	}

	@Column(name="Procesada")
	public Boolean getProcesada() {
		return this.procesada;
	}

	public void setProcesada(Boolean procesada) {
		this.procesada = procesada;
	}

	@Column(name="Tarjeta")
	public Short getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

	@Column(name="TipoPrestamo")
	public Short getTipoPrestamo() {
		return this.tipoPrestamo;
	}

	public void setTipoPrestamo(Short tipoPrestamo) {
		this.tipoPrestamo = tipoPrestamo;
	}

	@Column(name="idGPlanta")
	public Long getIdGplanta() {
		return idGplanta;
	}

	public void setIdGplanta(Long idGplanta) {
		this.idGplanta = idGplanta;
	}

	@Column(name="idFTipoPrestamo")
	public Integer getIdFtipoprestamo() {
		return idFtipoprestamo;
	}

	public void setIdFtipoprestamo(Integer idFtipoprestamo) {
		this.idFtipoprestamo = idFtipoprestamo;
	}

	@Column(name="ImporteNeto")
	public BigDecimal getImporteNeto() {
		return importeNeto;
	}

	public void setImporteNeto(BigDecimal importeNeto) {
		this.importeNeto = importeNeto;
	}

	@Column(name="Motivo")
	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Column(name="Moneda")
	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

}