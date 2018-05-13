package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PrestamoSummary implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7119745580137260966L;
	private Integer idFprestamos;
	private Integer nroPrestamo;
	private String tipoPrestamo;
	private BigDecimal saldoPrestamo;
	private Date fechaSaldo;
	
	public PrestamoSummary(){
		
	}
	
	public PrestamoSummary(Integer idFprestamos, Integer nroPrestamo, String tipoPrestamo, 
						BigDecimal saldoPrestamo, Date fechaSaldo){
		
		this.idFprestamos = idFprestamos;
		this.nroPrestamo = nroPrestamo;
		this.tipoPrestamo = tipoPrestamo;
		this.saldoPrestamo = saldoPrestamo;
		this.fechaSaldo = fechaSaldo;
	}
	
	public Integer getIdFprestamos() {
		return idFprestamos;
	}
	public void setIdFprestamos(Integer idFprestamos) {
		this.idFprestamos = idFprestamos;
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
	public BigDecimal getSaldoPrestamo() {
		return saldoPrestamo;
	}
	public void setSaldoPrestamo(BigDecimal saldoPrestamo) {
		this.saldoPrestamo = saldoPrestamo;
	}
	public Date getFechaSaldo() {
		return fechaSaldo;
	}
	public void setFechaSaldo(Date fechaSaldo) {
		this.fechaSaldo = fechaSaldo;
	}
	

}
