package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class HaberesDescuentosResumenSummary implements Serializable {

	private static final long serialVersionUID = -7998421188209826843L;
	private String tipo;
	private Short codigo;
	private String descripCodigo;
	private BigDecimal dolares;
	private BigDecimal pesos;
	private String moneda;
	
	public HaberesDescuentosResumenSummary(){
		
	}

	public HaberesDescuentosResumenSummary(String tipo, Short codigo, String descripCodigo, BigDecimal dolares,
				BigDecimal pesos, String moneda){
		this.tipo = tipo;
		this.codigo = codigo;
		this.descripCodigo = descripCodigo;
		this.dolares = dolares;
		this.pesos = pesos;
		this.moneda = moneda;
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

}
