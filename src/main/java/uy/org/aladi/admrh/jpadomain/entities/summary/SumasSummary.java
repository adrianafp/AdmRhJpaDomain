package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class SumasSummary implements Serializable {

	private static final long serialVersionUID = -1222327467557876071L;
	private String literal;
	private BigDecimal valor;
	private Integer valorEntero;
	
	public SumasSummary(){
		
	}
	
	public SumasSummary(String literal, BigDecimal valor, Integer valorEntero){
		this.literal = literal;
		this.valor = valor;
		this.valorEntero = valorEntero;
	}
	
	public String getLiteral() {
		return literal;
	}
	public void setLiteral(String literal) {
		this.literal = literal;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Integer getValorEntero() {
		return valorEntero;
	}
	public void setValorEntero(Integer valorEntero) {
		this.valorEntero = valorEntero;
	}
	
}
