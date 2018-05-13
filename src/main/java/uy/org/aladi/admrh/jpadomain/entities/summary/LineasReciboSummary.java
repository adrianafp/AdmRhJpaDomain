package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class LineasReciboSummary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7017168486372964081L;
	private Long idHaberesLiquidados;
	private Short tarjeta;
	private Short idFCodigos;
	private String descripcion;
	private Short cantidad;
	private BigDecimal pesos;
	private BigDecimal adiciones;
	private BigDecimal deducciones;
	
	public LineasReciboSummary(){
		
	}
	
	public LineasReciboSummary(Short tarjeta, Short idFcodigos, String descripcion, Short cantidad,
			BigDecimal pesos, BigDecimal adiciones, BigDecimal deducciones){
		this.tarjeta = tarjeta;
		this.idFCodigos = idFcodigos;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.pesos = pesos;
		this.adiciones = adiciones;
		this.deducciones = deducciones;
	}
	

	public Short getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Short getIdFCodigos() {
		return idFCodigos;
	}

	public void setIdFCodigos(Short idFCodigos) {
		this.idFCodigos = idFCodigos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Short getCantidad() {
		return cantidad;
	}

	public void setCantidad(Short cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPesos() {
		return pesos;
	}

	public void setPesos(BigDecimal pesos) {
		this.pesos = pesos;
	}

	public BigDecimal getAdiciones() {
		return adiciones;
	}

	public void setAdiciones(BigDecimal adiciones) {
		this.adiciones = adiciones;
	}

	public BigDecimal getDeducciones() {
		return deducciones;
	}

	public void setDeducciones(BigDecimal deducciones) {
		this.deducciones = deducciones;
	}

	public Long getIdHaberesLiquidados() {
		return idHaberesLiquidados;
	}

	public void setIdHaberesLiquidados(Long idHaberesLiquidados) {
		this.idHaberesLiquidados = idHaberesLiquidados;
	}
}
