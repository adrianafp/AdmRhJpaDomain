package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;

public class ActRegResumenSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7149170697509458849L;

	private String tarjeta;
	private String nombre;
	private String anioMes;
	private String tardee_horas;
	private String pctTardee_horas;
	private String tardee_veces;
	private String pctTardee_veces;
	private String horasAdic;
	private String pctHorasAdic;
	private String tiempoExtraSR;
	private String atFliar_horas;
	private String atFliar_prom;
	private Short diasTrabajados;
	private String depto;
	
	public ActRegResumenSummary(){}
	
	public ActRegResumenSummary(String tarjeta, String nombre){
		this.setTarjeta(tarjeta);
		this.setNombre(nombre);
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAnioMes() {
		return anioMes;
	}

	public void setAnioMes(String anioMes) {
		this.anioMes = anioMes;
	}

	public String getTardee_horas() {
		return tardee_horas;
	}

	public void setTardee_horas(String tardee_horas) {
		this.tardee_horas = tardee_horas;
	}

	public String getPctTardee_horas() {
		return pctTardee_horas;
	}

	public void setPctTardee_horas(String pctTardee_horas) {
		this.pctTardee_horas = pctTardee_horas;
	}

	public String getTardee_veces() {
		return tardee_veces;
	}

	public void setTardee_veces(String tardee_veces) {
		this.tardee_veces = tardee_veces;
	}

	public String getPctTardee_veces() {
		return pctTardee_veces;
	}

	public void setPctTardee_veces(String pctTardee_veces) {
		this.pctTardee_veces = pctTardee_veces;
	}

	public String getHorasAdic() {
		return horasAdic;
	}

	public void setHorasAdic(String horasAdic) {
		this.horasAdic = horasAdic;
	}

	public String getPctHorasAdic() {
		return pctHorasAdic;
	}

	public void setPctHorasAdic(String pctHorasAdic) {
		this.pctHorasAdic = pctHorasAdic;
	}

	public String getTiempoExtraSR() {
		return tiempoExtraSR;
	}

	public void setTiempoExtraSR(String tiempoExtraSR) {
		this.tiempoExtraSR = tiempoExtraSR;
	}

	public String getAtFliar_horas() {
		return atFliar_horas;
	}

	public void setAtFliar_horas(String atFliar_horas) {
		this.atFliar_horas = atFliar_horas;
	}

	public String getAtFliar_prom() {
		return atFliar_prom;
	}

	public void setAtFliar_prom(String atFliar_prom) {
		this.atFliar_prom = atFliar_prom;
	}

	public Short getDiasTrabajados() {
		return diasTrabajados;
	}

	public void setDiasTrabajados(Short diasTrabajados) {
		this.diasTrabajados = diasTrabajados;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}
	
}
