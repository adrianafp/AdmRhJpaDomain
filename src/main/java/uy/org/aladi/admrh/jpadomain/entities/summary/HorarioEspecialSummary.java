package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;

public class HorarioEspecialSummary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5139648775876066003L;

	private Long idHorario;
	private Short tarjeta;
	private String nombre;
	private String dia;
	private String sfechac;
	private String sfechaf;
	private String shoraEntradaM;
	private String shoraSalidaM;
	private String shoraEntradaT;
	private String shoraSalidaT;
	private String motivo;
	private String tipoHorario;

	public HorarioEspecialSummary(){	}

	public Long getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Long idHorario) {
		this.idHorario = idHorario;
	}

	public Short getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getTipoHorario() {
		return tipoHorario;
	}

	public void setTipoHorario(String tipoHorario) {
		this.tipoHorario = tipoHorario;
	}

	public String getSfechac() {
		return sfechac;
	}

	public void setSfechac(String sfechac) {
		this.sfechac = sfechac;
	}

	public String getSfechaf() {
		return sfechaf;
	}

	public void setSfechaf(String sfechaf) {
		this.sfechaf = sfechaf;
	}

	public String getShoraEntradaM() {
		return shoraEntradaM;
	}

	public void setShoraEntradaM(String shoraEntradaM) {
		this.shoraEntradaM = shoraEntradaM;
	}

	public String getShoraSalidaM() {
		return shoraSalidaM;
	}

	public void setShoraSalidaM(String shoraSalidaM) {
		this.shoraSalidaM = shoraSalidaM;
	}

	public String getShoraEntradaT() {
		return shoraEntradaT;
	}

	public void setShoraEntradaT(String shoraEntradaT) {
		this.shoraEntradaT = shoraEntradaT;
	}

	public String getShoraSalidaT() {
		return shoraSalidaT;
	}

	public void setShoraSalidaT(String shoraSalidaT) {
		this.shoraSalidaT = shoraSalidaT;
	}
}
