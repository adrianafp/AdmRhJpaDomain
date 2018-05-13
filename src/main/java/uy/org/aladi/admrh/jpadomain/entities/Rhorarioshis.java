package uy.org.aladi.admrh.jpadomain.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the rhorarioshis database table.
 * 
 */
@Entity
@Table(name="rhorarioshis")
public class Rhorarioshis implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idRHorarioshis;

	private String dia;

	private Time entradaM;

	private Time entradaT;

	@Temporal(TemporalType.DATE)
	private Date fechac;

	@Temporal(TemporalType.DATE)
	private Date fechaf;

	private Long idGPlanta;

	private String motivo;

	private String nombre;

	private Short nroDia;

	private Time salidaM;

	private Time salidaT;

	private Short tarjeta;

	private String tipoHorario;

	public Rhorarioshis() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idRHorarioshis", unique = true, nullable = false)
	public Long getIdRHorarioshis() {
		return this.idRHorarioshis;
	}

	public void setIdRHorarioshis(Long idRHorarioshis) {
		this.idRHorarioshis = idRHorarioshis;
	}

	public String getDia() {
		return this.dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Time getEntradaM() {
		return this.entradaM;
	}

	public void setEntradaM(Time entradaM) {
		this.entradaM = entradaM;
	}

	public Time getEntradaT() {
		return this.entradaT;
	}

	public void setEntradaT(Time entradaT) {
		this.entradaT = entradaT;
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

	public Long getIdGPlanta() {
		return this.idGPlanta;
	}

	public void setIdGPlanta(Long idGPlanta) {
		this.idGPlanta = idGPlanta;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Short getNroDia() {
		return this.nroDia;
	}

	public void setNroDia(Short nroDia) {
		this.nroDia = nroDia;
	}

	public Time getSalidaM() {
		return this.salidaM;
	}

	public void setSalidaM(Time salidaM) {
		this.salidaM = salidaM;
	}

	public Time getSalidaT() {
		return this.salidaT;
	}

	public void setSalidaT(Time salidaT) {
		this.salidaT = salidaT;
	}

	public Short getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getTipoHorario() {
		return this.tipoHorario;
	}

	public void setTipoHorario(String tipoHorario) {
		this.tipoHorario = tipoHorario;
	}

}