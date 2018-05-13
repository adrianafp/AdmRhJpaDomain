package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class CapitalNominalSummary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7785432771692872715L;
	private Short tarjeta;
	private String nombre;
	private BigDecimal capIntegAntes;
	private BigDecimal capIntegActual;
	private BigDecimal aporteTotal;
	private BigDecimal interesCuotas;
	private BigDecimal otrosBenef;
	private BigDecimal retiro;
	private BigDecimal totalMov;
	private String mesLiquidacion;
	
	public CapitalNominalSummary(){
		
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

	public BigDecimal getCapIntegAntes() {
		return capIntegAntes;
	}

	public void setCapIntegAntes(BigDecimal capIntegAntes) {
		this.capIntegAntes = capIntegAntes;
	}

	public BigDecimal getCapIntegActual() {
		return capIntegActual;
	}

	public void setCapIntegActual(BigDecimal capIntegActual) {
		this.capIntegActual = capIntegActual;
	}

	public BigDecimal getAporteTotal() {
		return aporteTotal;
	}

	public void setAporteTotal(BigDecimal aporteTotal) {
		this.aporteTotal = aporteTotal;
	}

	public BigDecimal getInteresCuotas() {
		return interesCuotas;
	}

	public void setInteresCuotas(BigDecimal interesCuotas) {
		this.interesCuotas = interesCuotas;
	}

	public BigDecimal getOtrosBenef() {
		return otrosBenef;
	}

	public void setOtrosBenef(BigDecimal otrosBenef) {
		this.otrosBenef = otrosBenef;
	}

	public BigDecimal getRetiro() {
		return retiro;
	}

	public void setRetiro(BigDecimal retiro) {
		this.retiro = retiro;
	}

	public BigDecimal getTotalMov() {
		return totalMov;
	}

	public void setTotalMov(BigDecimal totalMov) {
		this.totalMov = totalMov;
	}

	public String getMesLiquidacion() {
		return mesLiquidacion;
	}

	public void setMesLiquidacion(String mesLiquidacion) {
		this.mesLiquidacion = mesLiquidacion;
	}
	
}
