package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class DisponiblesSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9192674551725269206L;
	private String clave;
	private String anioMes;
	private BigDecimal valor;
	
	public DisponiblesSummary()
	{ super();}
	
	public DisponiblesSummary(String clave, String anioMes, BigDecimal valor){
		this.clave = clave;
		this.anioMes = anioMes;
		this.valor = valor;
	}

	public String getanioMes() {
		return anioMes;
	}

	public void setanioMes(String anioMes) {
		this.anioMes = anioMes;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
}
