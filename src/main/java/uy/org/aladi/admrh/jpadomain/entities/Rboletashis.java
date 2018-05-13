package uy.org.aladi.admrh.jpadomain.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the rboletashis database table.
 * 
 */
@Entity
@Table(name="rboletashis")
public class Rboletashis implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idRboletashis;
	private Boolean autorizada;
	private Boolean enviadaJefe;
	private Boolean enviadaRH;
	private Date fecha;
	private Time horaDesde;
	private Time horaHasta;
	private Long idGplanta;
	private Short idRCodigos;
	private String jefeAutorizante;
	private String jefeEmail;
	private Short jefeTarjeta;
	private String motivo;
	private Boolean procesadaRH;

	public Rboletashis() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idRboletashis", unique = true, nullable = false)
	public Long getIdRboletashis() {
		return idRboletashis;
	}


	public void setIdRboletashis(Long idRboletashis) {
		this.idRboletashis = idRboletashis;
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

	@Column(name="idGplanta")
	public Long getIdGplanta() {
		return this.idGplanta;
	}

	public void setIdGplanta(Long idGplanta) {
		this.idGplanta = idGplanta;
	}

	@Column(name="idRCodigos")
	public short getIdRCodigos() {
		return this.idRCodigos;
	}

	public void setIdRCodigos(short idRCodigos) {
		this.idRCodigos = idRCodigos;
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

	@Column(name="jefeTarjeta")
	public short getJefeTarjeta() {
		return this.jefeTarjeta;
	}

	public void setJefeTarjeta(short jefeTarjeta) {
		this.jefeTarjeta = jefeTarjeta;
	}

	@Column(name="motivo")
	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@Column(name="autorizada")
	public Boolean getAutorizada() {
		return autorizada;
	}


	public void setAutorizada(Boolean autorizada) {
		this.autorizada = autorizada;
	}

	@Column(name="enviadaJefe")
	public Boolean getEnviadaJefe() {
		return enviadaJefe;
	}


	public void setEnviadaJefe(Boolean enviadaJefe) {
		this.enviadaJefe = enviadaJefe;
	}

	@Column(name="enviadaRH")
	public Boolean getEnviadaRH() {
		return enviadaRH;
	}


	public void setEnviadaRH(Boolean enviadaRH) {
		this.enviadaRH = enviadaRH;
	}

	@Column(name="procesadaRH")
	public Boolean getProcesadaRH() {
		return procesadaRH;
	}


	public void setProcesadaRH(Boolean procesadaRH) {
		this.procesadaRH = procesadaRH;
	}

}