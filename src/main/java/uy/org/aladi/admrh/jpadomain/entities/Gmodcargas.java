package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the gmodcargas database table.
 * 
 */
@Entity
@Table(name="gmodcargas")
public class Gmodcargas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idGModCargas;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Temporal(TemporalType.DATE)
	private Date fechamod;
	
	private Integer idGCargas;
	
	private Long idGplanta;

	private String motivo;

	private String nombreFamiliar;

	private String parentesco;

	private Boolean seProceso;

	private Short tarjeta;

	private short tiporeg;

	public Gmodcargas() {
	}

	public Integer getIdGModCargas() {
		return this.idGModCargas;
	}

	public void setIdGModCargas(Integer idGModCargas) {
		this.idGModCargas = idGModCargas;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechamod() {
		return this.fechamod;
	}

	public void setFechamod(Date fechamod) {
		this.fechamod = fechamod;
	}

	public Long getIdGplanta() {
		return this.idGplanta;
	}

	public void setIdGplanta(Long idGplanta) {
		this.idGplanta = idGplanta;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getNombreFamiliar() {
		return this.nombreFamiliar;
	}

	public void setNombreFamiliar(String nombreFamiliar) {
		this.nombreFamiliar = nombreFamiliar;
	}

	public String getParentesco() {
		return this.parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public Boolean getSeProceso() {
		return this.seProceso;
	}

	public void setSeProceso(Boolean seProceso) {
		this.seProceso = seProceso;
	}

	public Short getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

	public short getTiporeg() {
		return this.tiporeg;
	}

	public void setTiporeg(short tiporeg) {
		this.tiporeg = tiporeg;
	}

	public Integer getIdGCargas() {
		return idGCargas;
	}

	public void setIdGCargas(Integer idGCargas) {
		this.idGCargas = idGCargas;
	}

}