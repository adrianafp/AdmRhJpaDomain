package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rmarcorig database table.
 * 
 */
@Entity
@NamedQuery(name="Rmarcorig.findAll", query="SELECT r FROM Rmarcorig r")
public class Rmarcorig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String idrmarcorig;

	private String control;

	private String dverif;

	private String fecha;

	private String hora;

	private String reloj;

	private String superv;

	private String tarjeta;

	private String tipo;

	public Rmarcorig() {
	}

	public String getIdrmarcorig() {
		return this.idrmarcorig;
	}

	public void setIdrmarcorig(String idrmarcorig) {
		this.idrmarcorig = idrmarcorig;
	}

	public String getControl() {
		return this.control;
	}

	public void setControl(String control) {
		this.control = control;
	}

	public String getDverif() {
		return this.dverif;
	}

	public void setDverif(String dverif) {
		this.dverif = dverif;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getReloj() {
		return this.reloj;
	}

	public void setReloj(String reloj) {
		this.reloj = reloj;
	}

	public String getSuperv() {
		return this.superv;
	}

	public void setSuperv(String superv) {
		this.superv = superv;
	}

	public String getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}