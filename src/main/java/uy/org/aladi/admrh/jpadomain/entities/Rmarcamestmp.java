package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the rmarcamestmp database table.
 * 
 */
@Entity
public class Rmarcamestmp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idRmarcames;

	@Temporal(TemporalType.DATE)
	private Date fecha1;

	@Temporal(TemporalType.DATE)
	private Date fecha2;

	@Temporal(TemporalType.DATE)
	private Date fechaAnalisis;

	private Time hora1;

	private Time hora2;

	private Long idGPlanta;

	private Short idRCodigos;

	private String observ;

	private Short tarjeta;

	private Boolean ultlect;

	public Rmarcamestmp() {
	}

	public Integer getIdRmarcames() {
		return this.idRmarcames;
	}

	public void setIdRmarcames(Integer idRmarcames) {
		this.idRmarcames = idRmarcames;
	}

	public Date getFecha1() {
		return this.fecha1;
	}

	public void setFecha1(Date fecha1) {
		this.fecha1 = fecha1;
	}

	public Date getFecha2() {
		return this.fecha2;
	}

	public void setFecha2(Date fecha2) {
		this.fecha2 = fecha2;
	}

	public Date getFechaAnalisis() {
		return this.fechaAnalisis;
	}

	public void setFechaAnalisis(Date fechaAnalisis) {
		this.fechaAnalisis = fechaAnalisis;
	}

	public Time getHora1() {
		return this.hora1;
	}

	public void setHora1(Time hora1) {
		this.hora1 = hora1;
	}

	public Time getHora2() {
		return this.hora2;
	}

	public void setHora2(Time hora2) {
		this.hora2 = hora2;
	}

	public Long getIdGPlanta() {
		return this.idGPlanta;
	}

	public void setIdGPlanta(Long idGPlanta) {
		this.idGPlanta = idGPlanta;
	}

	public Short getIdRCodigos() {
		return this.idRCodigos;
	}

	public void setIdRCodigos(Short idRCodigos) {
		this.idRCodigos = idRCodigos;
	}

	public String getObserv() {
		return this.observ;
	}

	public void setObserv(String observ) {
		this.observ = observ;
	}

	public Short getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Boolean getUltlect() {
		return this.ultlect;
	}

	public void setUltlect(Boolean ultlect) {
		this.ultlect = ultlect;
	}

}