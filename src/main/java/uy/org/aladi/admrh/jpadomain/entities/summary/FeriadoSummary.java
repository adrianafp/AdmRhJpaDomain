package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;

public class FeriadoSummary implements Serializable {

	private static final long serialVersionUID = -5841642981747807248L;
	
	private Integer idferiado;
	private String sfecha;
	private String motivo;
	private String doble;
	
	public FeriadoSummary(){
		super();
	}

	public String getSfecha() {
		return sfecha;
	}

	public void setSfecha(String sfecha) {
		this.sfecha = sfecha;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getDoble() {
		return doble;
	}

	public void setDoble(String doble) {
		this.doble = doble;
	}

	public Integer getIdferiado() {
		return idferiado;
	}

	public void setIdferiado(Integer idferiado) {
		this.idferiado = idferiado;
	}

}
