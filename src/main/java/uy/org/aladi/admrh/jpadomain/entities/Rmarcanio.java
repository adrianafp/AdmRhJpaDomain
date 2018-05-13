package uy.org.aladi.admrh.jpadomain.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: Rmarcanio
 *
 */
@Entity
@Table(name="rmarcanio")
public class Rmarcanio implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Integer idRmarcanio;
	private Rcodigos rcodigos;
	private Gplanta gplanta;
	private Short tarjeta;
	private Date fecha1;
	private Time hora1;
	private Date fecha2;
	private Time hora2;
	private String observ;
	private Boolean ultlect;
	private Date fechaAnalisis;

	public Rmarcanio() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idRmarcanio", unique = true, nullable = false)
	public Integer getIdRmarcanio() {
		return idRmarcanio;
	}

	public void setIdRmarcanio(Integer idRmarcanio) {
		this.idRmarcanio = idRmarcanio;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idRCodigos", nullable = false)
	@NotNull
	public Rcodigos getRcodigos() {
		return rcodigos;
	}

	public void setRcodigos(Rcodigos rcodigos) {
		this.rcodigos = rcodigos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idGPlanta", nullable = false)
	@NotNull
	public Gplanta getGplanta() {
		return gplanta;
	}

	public void setGplanta(Gplanta gplanta) {
		this.gplanta = gplanta;
	}

	@Column(name = "Tarjeta", nullable = false)
	public Short getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

	@Column(name="Fecha1")
	public Date getFecha1() {
		return fecha1;
	}

	public void setFecha1(Date fecha1) {
		this.fecha1 = fecha1;
	}

	@Column(name="Hora1")
	public Time getHora1() {
		return hora1;
	}

	public void setHora1(Time hora1) {
		this.hora1 = hora1;
	}

	@Column(name="Fecha2")
	public Date getFecha2() {
		return fecha2;
	}

	public void setFecha2(Date fecha2) {
		this.fecha2 = fecha2;
	}

	@Column(name="Hora2")
	public Time getHora2() {
		return hora2;
	}

	public void setHora2(Time hora2) {
		this.hora2 = hora2;
	}

	@Column(name="Observ")
	public String getObserv() {
		return observ;
	}

	public void setObserv(String observ) {
		this.observ = observ;
	}

	@Column(name="Ultlect")
	public Boolean getUltlect() {
		return ultlect;
	}

	public void setUltlect(Boolean ultlect) {
		this.ultlect = ultlect;
	}

	@Column(name="FechaAnalisis")
	public Date getFechaAnalisis() {
		return fechaAnalisis;
	}

	public void setFechaAnalisis(Date fechaAnalisis) {
		this.fechaAnalisis = fechaAnalisis;
	}
   
}
