package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the rmarcatmp database table.
 * 
 */
@Entity
@NamedQuery(name="Rmarcatmp.findAll", query="SELECT r FROM Rmarcatmp r")
public class Rmarcatmp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idrmarcatmp;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Time hora;

	private Short tarjeta;

	public Rmarcatmp() {
	}

	public int getIdrmarcatmp() {
		return this.idrmarcatmp;
	}

	public void setIdrmarcatmp(int idrmarcatmp) {
		this.idrmarcatmp = idrmarcatmp;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Short getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

}