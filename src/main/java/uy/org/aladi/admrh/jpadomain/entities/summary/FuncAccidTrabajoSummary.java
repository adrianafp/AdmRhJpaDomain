package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class FuncAccidTrabajoSummary implements Serializable{
	
	private static final long serialVersionUID = -3058608510467545505L;
	private Short tarjeta;
	private String nombre;
	private BigDecimal valor;
	
	public FuncAccidTrabajoSummary(){
		
	}
	
	public FuncAccidTrabajoSummary(Short tarjeta, String nombre, BigDecimal valor){
		this.tarjeta = tarjeta;
		this.nombre = nombre;
		this.valor = valor;
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

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	

}
