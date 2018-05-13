package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MovimientoSummary implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -600302364149495476L;
	private Short tarjeta;
	private String mesLiquidacion;
	private String tipoMov;
	private Integer nroPrestamo;
	private Short nroCuota;
	private BigDecimal importeMov;
	private BigDecimal importeCapSec;
	private BigDecimal importeIntFunc;
	private BigDecimal saldoAnterior;
	private BigDecimal saldoActual;
	private BigDecimal numerales;
	private Date fechaSaldo;
	
	public MovimientoSummary(){
		
	}
	
	public MovimientoSummary(Short tarjeta, String mesLiquidacion, String tipoMov, Integer nroPrestamo, 
						Short nroCuota, BigDecimal importeMov, BigDecimal importeCapSec,
						BigDecimal importeIntFunc, BigDecimal saldoAnterior,
						BigDecimal saldoActual, BigDecimal numerales, Date fechaSaldo){
		this.tarjeta = tarjeta;
		this.mesLiquidacion = mesLiquidacion;
		this.tipoMov = tipoMov;
		this.nroPrestamo = nroPrestamo;
		this.nroCuota = nroCuota;
		this.importeMov = importeMov;
		this.importeCapSec = importeCapSec;
		this.importeIntFunc = importeIntFunc;
		this.saldoAnterior = saldoAnterior;
		this.saldoActual = saldoActual;
		this.numerales = numerales;
		this.fechaSaldo = fechaSaldo;
	}
	
	public Integer getNroPrestamo() {
		return nroPrestamo;
	}
	public void setNroPrestamo(Integer nroPrestamo) {
		this.nroPrestamo = nroPrestamo;
	}

	public Date getFechaSaldo() {
		return fechaSaldo;
	}
	public void setFechaSaldo(Date fechaSaldo) {
		this.fechaSaldo = fechaSaldo;
	}

	public Short getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getMesLiquidacion() {
		return mesLiquidacion;
	}

	public void setMesLiquidacion(String mesLiquidacion) {
		this.mesLiquidacion = mesLiquidacion;
	}

	public String getTipoMov() {
		return tipoMov;
	}

	public void setTipoMov(String tipoMov) {
		this.tipoMov = tipoMov;
	}

	public Short getNroCuota() {
		return nroCuota;
	}

	public void setNroCuota(Short nroCuota) {
		this.nroCuota = nroCuota;
	}

	public BigDecimal getImporteMov() {
		return importeMov;
	}

	public void setImporteMov(BigDecimal importeMov) {
		this.importeMov = importeMov;
	}

	public BigDecimal getImporteCapSec() {
		return importeCapSec;
	}

	public void setImporteCapSec(BigDecimal importeCapSec) {
		this.importeCapSec = importeCapSec;
	}

	public BigDecimal getImporteIntFunc() {
		return importeIntFunc;
	}

	public void setImporteIntFunc(BigDecimal importeIntFunc) {
		this.importeIntFunc = importeIntFunc;
	}

	public BigDecimal getSaldoAnterior() {
		return saldoAnterior;
	}

	public void setSaldoAnterior(BigDecimal saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}

	public BigDecimal getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(BigDecimal saldoActual) {
		this.saldoActual = saldoActual;
	}

	public BigDecimal getNumerales() {
		return numerales;
	}

	public void setNumerales(BigDecimal numerales) {
		this.numerales = numerales;
	}
	

}
