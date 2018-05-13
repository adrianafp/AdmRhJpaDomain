package uy.org.aladi.admrh.jpadomain.entities;

import static javax.persistence.GenerationType.IDENTITY;
import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the rboletas database table.
 * 
 */
@Entity
@Table(name="rboletas")
public class Rboleta implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idrboletas;
	private Boolean autorizada;
	private Boolean enviadaJefe;
	private Boolean enviadaRH;
	private Boolean procesadaRH;
	private Date fecha;
	private Time horaDesde;
	private Time horaHasta;
	private Rcodigos rcodigos;
	private Gplanta gplanta;
	private String jefeAutorizante;
	private String jefeEmail;
	private Short jefeTarjeta;
	private String motivo;

	public Rboleta() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idRboletas", unique = true, nullable = false)
	public Long getIdrboletas() {
		return this.idrboletas;
	}

	public void setIdrboletas(Long idrboletas) {
		this.idrboletas = idrboletas;
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

	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha")
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name="horaDesde")
	public Time getHoraDesde() {
		return this.horaDesde;
	}

	public void setHoraDesde(Time horaDesde) {
		this.horaDesde = horaDesde;
	}

	@Column(name="horaHasta")
	public Time getHoraHasta() {
		return this.horaHasta;
	}

	public void setHoraHasta(Time horaHasta) {
		this.horaHasta = horaHasta;
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

	@Column(name="motivo")
	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
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
}