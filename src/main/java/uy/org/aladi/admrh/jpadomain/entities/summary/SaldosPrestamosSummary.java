package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class SaldosPrestamosSummary implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3484510248531024606L;
	private Short tarjeta;
	private BigDecimal saldoPrestamo;
    
	public SaldosPrestamosSummary(){
		
	}
	
	public SaldosPrestamosSummary(Short tarjeta, BigDecimal saldoPrestamo){
		this.tarjeta = tarjeta;
		this.saldoPrestamo = saldoPrestamo;
	}
	
	public Short getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}
	public BigDecimal getSaldoPrestamo() {
		return saldoPrestamo;
	}
	public void setSaldoPrestamo(BigDecimal saldoPrestamo) {
		this.saldoPrestamo = saldoPrestamo;
	}

}
