package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HaberesResumenSummary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7448713694141438232L;
	private String tipo;
	private Short codigo;
	private String descripCodigo;
	private BigDecimal dolares;
	private BigDecimal pesos;
	private String moneda;
	private List<HaberesLiqPorCodigoSummary> lstHaberes = new ArrayList<HaberesLiqPorCodigoSummary>();
	
	public HaberesResumenSummary(){
		
	}

	public HaberesResumenSummary(String tipo, Short codigo, String descripCodigo, BigDecimal dolares,
				BigDecimal pesos, String moneda, List<HaberesLiqPorCodigoSummary> lstHaberes){
		this.tipo = tipo;
		this.codigo = codigo;
		this.descripCodigo = descripCodigo;
		this.dolares = dolares;
		this.pesos = pesos;
		this.moneda = moneda;
		this.lstHaberes = lstHaberes;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Short getCodigo() {
		return codigo;
	}

	public void setCodigo(Short codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getDolares() {
		return dolares;
	}

	public void setDolares(BigDecimal dolares) {
		this.dolares = dolares;
	}

	public String getDescripCodigo() {
		return descripCodigo;
	}

	public void setDescripCodigo(String descripCodigo) {
		this.descripCodigo = descripCodigo;
	}

	public BigDecimal getPesos() {
		return pesos;
	}

	public void setPesos(BigDecimal pesos) {
		this.pesos = pesos;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public List<HaberesLiqPorCodigoSummary> getLstHaberes() {
		return lstHaberes;
	}

	public void setLstHaberes(List<HaberesLiqPorCodigoSummary> lstHaberes) {
		this.lstHaberes = lstHaberes;
	}
}
