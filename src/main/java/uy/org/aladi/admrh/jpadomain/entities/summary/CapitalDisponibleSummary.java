package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class CapitalDisponibleSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -845295264812908622L;
	private Short tarjeta;
	private String nombre;
	private BigDecimal capDispAntes;
	private BigDecimal amortizacion;
	private BigDecimal cancelacion;
	private BigDecimal nuevosPrest;
	private BigDecimal totalMov;
	private BigDecimal totalMovNom;
	private BigDecimal capDispActual;
	private String mesLiquidacion;
	private BigDecimal numerales;
	private BigDecimal interesesDistrib;
	
	public CapitalDisponibleSummary(){
		
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

	public BigDecimal getCapDispAntes() {
		return capDispAntes;
	}

	public void setCapDispAntes(BigDecimal capDispAntes) {
		this.capDispAntes = capDispAntes;
	}

	public BigDecimal getAmortizacion() {
		return amortizacion;
	}

	public void setAmortizacion(BigDecimal amortizacion) {
		this.amortizacion = amortizacion;
	}

	public BigDecimal getCancelacion() {
		return cancelacion;
	}

	public void setCancelacion(BigDecimal cancelacion) {
		this.cancelacion = cancelacion;
	}

	public BigDecimal getNuevosPrest() {
		return nuevosPrest;
	}

	public void setNuevosPrest(BigDecimal nuevosPrest) {
		this.nuevosPrest = nuevosPrest;
	}

	public BigDecimal getTotalMov() {
		return totalMov;
	}

	public void setTotalMov(BigDecimal totalMov) {
		this.totalMov = totalMov;
	}

	public BigDecimal getTotalMovNom() {
		return totalMovNom;
	}

	public void setTotalMovNom(BigDecimal totalMovNom) {
		this.totalMovNom = totalMovNom;
	}

	public BigDecimal getCapDispActual() {
		return capDispActual;
	}

	public void setCapDispActual(BigDecimal capDispActual) {
		this.capDispActual = capDispActual;
	}

	public String getMesLiquidacion() {
		return mesLiquidacion;
	}

	public void setMesLiquidacion(String mesLiquidacion) {
		this.mesLiquidacion = mesLiquidacion;
	}

	public BigDecimal getNumerales() {
		return numerales;
	}

	public void setNumerales(BigDecimal numerales) {
		this.numerales = numerales;
	}

	public BigDecimal getInteresesDistrib() {
		return interesesDistrib;
	}

	public void setInteresesDistrib(BigDecimal interesesDistrib) {
		this.interesesDistrib = interesesDistrib;
	}
	
}
