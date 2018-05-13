package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the rlogreloj database table.
 * 
 */
@Entity
@NamedQuery(name="Rlogreloj.findAll", query="SELECT r FROM Rlogreloj r")
public class Rlogreloj implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idRLogReloj;

	private String categoria;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Temporal(TemporalType.DATE)
	private Date fechaCierre;

	private Time hora;

	private String mensajeUsuario;

	private String procedimiento;

	private String tablasleidas;

	private String tablasmodificadas;

	private String usuario;

	public Rlogreloj() {
	}

	public Integer getIdRLogReloj() {
		return this.idRLogReloj;
	}

	public void setIdRLogReloj(Integer idRLogReloj) {
		this.idRLogReloj = idRLogReloj;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaCierre() {
		return this.fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public String getMensajeUsuario() {
		return this.mensajeUsuario;
	}

	public void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = mensajeUsuario;
	}

	public String getProcedimiento() {
		return this.procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public String getTablasleidas() {
		return this.tablasleidas;
	}

	public void setTablasleidas(String tablasleidas) {
		this.tablasleidas = tablasleidas;
	}

	public String getTablasmodificadas() {
		return this.tablasmodificadas;
	}

	public void setTablasmodificadas(String tablasmodificadas) {
		this.tablasmodificadas = tablasmodificadas;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}