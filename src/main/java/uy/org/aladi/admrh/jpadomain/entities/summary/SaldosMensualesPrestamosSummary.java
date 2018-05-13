package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.math.BigDecimal;
import java.io.Serializable;

public class SaldosMensualesPrestamosSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6987213223618707482L;
	private Integer nroPrestamo;
	private String tipoPrestamo;
	private BigDecimal saldoInicial;
	private BigDecimal interes;
	private BigDecimal cuota;
	private BigDecimal amortizacion;
	private BigDecimal saldoFinal;
	private String mes;
	private Integer nroCuota;
	
	public SaldosMensualesPrestamosSummary(){}
	
	public SaldosMensualesPrestamosSummary(Integer nroPrestamo, String tipoPrestamo, 
			BigDecimal saldoInicial, BigDecimal interes, BigDecimal cuota, 
			BigDecimal amortizacion, BigDecimal saldoFinal, String mes, Integer nroCuota){
		this.nroPrestamo = nroPrestamo;
		this.tipoPrestamo = tipoPrestamo;
		this.saldoInicial = saldoInicial;
		this.interes = interes;
		this.cuota = cuota;
		this.amortizacion = amortizacion;
		this.saldoFinal = saldoFinal;
		this.mes = mes;
		this.nroCuota = nroCuota;
	}
	
	public Integer getNroPrestamo() {
		return nroPrestamo;
	}
	public void setNroPrestamo(Integer nroPrestamo) {
		this.nroPrestamo = nroPrestamo;
	}
	public String getTipoPrestamo() {
		return tipoPrestamo;
	}
	public void setTipoPrestamo(String tipoPrestamo) {
		this.tipoPrestamo = tipoPrestamo;
	}
	public BigDecimal getSaldoInicial() {
		return saldoInicial;
	}
	public void setSaldoInicial(BigDecimal saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
	public BigDecimal getInteres() {
		return interes;
	}
	public void setInteres(BigDecimal interes) {
		this.interes = interes;
	}
	public BigDecimal getCuota() {
		return cuota;
	}
	public void setCuota(BigDecimal cuota) {
		this.cuota = cuota;
	}
	public BigDecimal getAmortizacion() {
		return amortizacion;
	}
	public void setAmortizacion(BigDecimal amortizacion) {
		this.amortizacion = amortizacion;
	}
	public BigDecimal getSaldoFinal() {
		return saldoFinal;
	}
	public void setSaldoFinal(BigDecimal saldoFinal) {
		this.saldoFinal = saldoFinal;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public Integer getNroCuota() {
		return nroCuota;
	}
	public void setNroCuota(Integer nroCuota) {
		this.nroCuota = nroCuota;
	}
	
}
