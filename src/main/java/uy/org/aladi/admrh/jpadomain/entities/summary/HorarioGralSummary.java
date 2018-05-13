package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;

public class HorarioGralSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6317393217627723920L;
	private Integer idparam;
	private String fecha_act;
	private String fechac;
	private String fechaf;
	private String horaEntrada;
	private String horaSalida;
	private String motivo;
	private Boolean modifFechaf;
	private Boolean modifTodo;
	
	public HorarioGralSummary(){
		super();
	}

	public Integer getIdparam() {
		return idparam;
	}

	public void setIdparam(Integer idparam) {
		this.idparam = idparam;
	}

	public String getFecha_act() {
		return fecha_act;
	}

	public void setFecha_act(String fecha_act) {
		this.fecha_act = fecha_act;
	}

	public String getFechac() {
		return fechac;
	}

	public void setFechac(String fechac) {
		this.fechac = fechac;
	}

	public String getFechaf() {
		return fechaf;
	}

	public void setFechaf(String fechaf) {
		this.fechaf = fechaf;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Boolean getModifFechaf() {
		return modifFechaf;
	}

	public void setModifFechaf(Boolean modifFechaf) {
		this.modifFechaf = modifFechaf;
	}

	public Boolean getModifTodo() {
		return modifTodo;
	}

	public void setModifTodo(Boolean modifTodo) {
		this.modifTodo = modifTodo;
	}
}
