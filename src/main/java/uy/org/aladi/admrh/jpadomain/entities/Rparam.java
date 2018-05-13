package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the rparam database table.
 * 
 */
@Entity
@NamedQuery(name="Rparam.findAll", query="SELECT r FROM Rparam r")
public class Rparam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idRparam;

	private Time ent_gral;

	@Temporal(TemporalType.DATE)
	private Date fecha_act;

	@Temporal(TemporalType.DATE)
	private Date fechac;

	@Temporal(TemporalType.DATE)
	private Date fechaf;

	private String motivo;

	private Time sal_gral;

	public Rparam() {
	}

	public Integer getIdRparam() {
		return this.idRparam;
	}

	public void setIdRparam(Integer idRparam) {
		this.idRparam = idRparam;
	}

	public Time getEnt_gral() {
		return this.ent_gral;
	}

	public void setEnt_gral(Time ent_gral) {
		this.ent_gral = ent_gral;
	}

	public Date getFecha_act() {
		return this.fecha_act;
	}

	public void setFecha_act(Date fecha_act) {
		this.fecha_act = fecha_act;
	}

	public Date getFechac() {
		return this.fechac;
	}

	public void setFechac(Date fechac) {
		this.fechac = fechac;
	}

	public Date getFechaf() {
		return this.fechaf;
	}

	public void setFechaf(Date fechaf) {
		this.fechaf = fechaf;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Time getSal_gral() {
		return this.sal_gral;
	}

	public void setSal_gral(Time sal_gral) {
		this.sal_gral = sal_gral;
	}

}