package uy.org.aladi.admrh.jpadomain.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the rlicencias database table.
 * 
 */
@Entity
@Table(name="rlicencias")
@NamedQuery(name="Rlicencia.findAll", query="SELECT r FROM Rlicencia r")
public class Rlicencia implements Serializable {
	private static final long serialVersionUID = 1L;


	private Long idRlicencias;
	private Boolean autorizada;
	private Boolean enviadaJefe;
	private Boolean enviadaRH;
	private Boolean procesadaRH;
	private Boolean conformidadSaldo;
	private Date fechaSolicitud;
	private Date fechaDesde;
	private Date fechaHasta;
	private Rcodigos rcodigos;
	private Gplanta gplanta;
	private String jefeAutorizante;
	private String jefeEmail;
	private Short jefeTarjeta;
	private String direccion;
	private String telefono;
	private Integer dias;
	private Integer saldoAnioActual;
	private Integer saldoAnioAnterior;
	private Integer saldoAnioPreAnterior;
	private Integer saldoCompensacion;
	private Integer saldoAntAnioActual;
	private Integer saldoAntAnioAnterior;
	private Integer saldoAntAnioPreAnterior;
	private Integer saldoAntCompensacion;
	
	
	public Rlicencia() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idRlicencias", unique = true, nullable = false)
	public Long getIdRlicencias() {
		return this.idRlicencias;
	}

	public void setIdRlicencias(Long idRlicencias) {
		this.idRlicencias = idRlicencias;
	}

	@Column(name="autorizada")
	public Boolean getAutorizada() {
		return this.autorizada;
	}

	public void setAutorizada(Boolean autorizada) {
		this.autorizada = autorizada;
	}

	@Column(name="enviadaJefe")
	public Boolean getEnviadaJefe() {
		return this.enviadaJefe;
	}

	public void setEnviadaJefe(Boolean enviadaJefe) {
		this.enviadaJefe = enviadaJefe;
	}

	@Column(name="enviadaRH")
	public Boolean getEnviadaRH() {
		return this.enviadaRH;
	}

	public void setEnviadaRH(Boolean enviadaRH) {
		this.enviadaRH = enviadaRH;
	}

	@Column(name="direccion")
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="fechaSolicitud")
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="fechaDesde")
	public Date getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="fechaHasta")
	public Date getFechaHasta() {
		return this.fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRCodigos", nullable = false)
	@NotNull
	public Rcodigos getRcodigos() {
		return this.rcodigos;
	}

	public void setRcodigos(Rcodigos rcodigos) {
		this.rcodigos = rcodigos;
	}

	@Column(name="jefeAutorizante")
	public String getJefeAutorizante() {
		return this.jefeAutorizante;
	}

	public void setJefeAutorizante(String jefeAutorizante) {
		this.jefeAutorizante = jefeAutorizante;
	}

	@Column(name="jefeEmail")
	public String getJefeEmail() {
		return this.jefeEmail;
	}

	public void setJefeEmail(String jefeEmail) {
		this.jefeEmail = jefeEmail;
	}

	@Column(name="procesadaRH")
	public Boolean getProcesadaRH() {
		return procesadaRH;
	}

	public void setProcesadaRH(Boolean procesadaRH) {
		this.procesadaRH = procesadaRH;
	}


	@Column(name="jefeTarjeta")
	public Short getJefeTarjeta() {
		return jefeTarjeta;
	}


	public void setJefeTarjeta(Short jefeTarjeta) {
		this.jefeTarjeta = jefeTarjeta;
	}

	@Column(name="saldoAnioActual")
	public Integer getSaldoAnioActual() {
		return saldoAnioActual;
	}

	public void setSaldoAnioActual(Integer saldoAnioActual) {
		this.saldoAnioActual = saldoAnioActual;
	}

	@Column(name="saldoAnioAnterior")
	public Integer getSaldoAnioAnterior() {
		return this.saldoAnioAnterior;
	}

	public void setSaldoAnioAnterior(Integer saldoAnioAnterior) {
		this.saldoAnioAnterior = saldoAnioAnterior;
	}

	@Column(name="saldoAnioPreAnterior")
	public Integer getSaldoAnioPreAnterior() {
		return this.saldoAnioPreAnterior;
	}

	public void setSaldoAnioPreAnterior(Integer saldoAnioPreAnterior) {
		this.saldoAnioPreAnterior = saldoAnioPreAnterior;
	}

	@Column(name="saldoCompensacion")
	public Integer getSaldoCompensacion() {
		return this.saldoCompensacion;
	}

	public void setSaldoCompensacion(Integer saldoCompensacion) {
		this.saldoCompensacion = saldoCompensacion;
	}

	@Column(name="telefono")
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Column(name="dias")
	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	@Column(name="conformidadSaldo")
	public Boolean getConformidadSaldo() {
		return conformidadSaldo;
	}

	public void setConformidadSaldo(Boolean conformidadSaldo) {
		this.conformidadSaldo = conformidadSaldo;
	}

	@Column(name="saldoAntAnioActual")
	public Integer getSaldoAntAnioActual() {
		return saldoAntAnioActual;
	}

	public void setSaldoAntAnioActual(Integer saldoAntAnioActual) {
		this.saldoAntAnioActual = saldoAntAnioActual;
	}

	@Column(name="saldoAntAnioAnterior")
	public Integer getSaldoAntAnioAnterior() {
		return saldoAntAnioAnterior;
	}

	public void setSaldoAntAnioAnterior(Integer saldoAntAnioAnterior) {
		this.saldoAntAnioAnterior = saldoAntAnioAnterior;
	}

	@Column(name="saldoAntAnioPreAnterior")
	public Integer getSaldoAntAnioPreAnterior() {
		return saldoAntAnioPreAnterior;
	}

	public void setSaldoAntAnioPreAnterior(Integer saldoAntAnioPreAnterior) {
		this.saldoAntAnioPreAnterior = saldoAntAnioPreAnterior;
	}

	@Column(name="saldoAntCompensacion")
	public Integer getSaldoAntCompensacion() {
		return saldoAntCompensacion;
	}

	public void setSaldoAntCompensacion(Integer saldoAntCompensacion) {
		this.saldoAntCompensacion = saldoAntCompensacion;
	}

}