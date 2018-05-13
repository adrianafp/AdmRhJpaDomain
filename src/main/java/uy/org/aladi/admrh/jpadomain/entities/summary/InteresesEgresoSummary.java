package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class InteresesEgresoSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8662709017692381936L;
	private String aniomessiguiente;
	private String aniomes;
	private BigDecimal capDispActual;
	private BigDecimal intereses;
	
	public InteresesEgresoSummary(){
		
	}
	
	public InteresesEgresoSummary(String aniomessiguiente, String aniomes, BigDecimal capDispActual, BigDecimal intereses){
		this.aniomessiguiente = aniomessiguiente;
		this.aniomes = aniomes;
		this.capDispActual = capDispActual;
		this.intereses = intereses;
	}
	
	public String getAniomes() {
		return aniomes;
	}
	public void setAniomes(String aniomes) {
		this.aniomes = aniomes;
	}
	public BigDecimal getCapDispActual() {
		return capDispActual;
	}
	public void setCapDispActual(BigDecimal capDispActual) {
		this.capDispActual = capDispActual;
	}
	public BigDecimal getIntereses() {
		return intereses;
	}
	public void setIntereses(BigDecimal intereses) {
		this.intereses = intereses;
	}

	public String getAniomessiguiente() {
		return aniomessiguiente;
	}

	public void setAniomessiguiente(String aniomessiguiente) {
		this.aniomessiguiente = aniomessiguiente;
	}
	
}
