package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class FuncModoCobroSummary implements Serializable {

	private static final long serialVersionUID = 3279787751571457476L;
	private Short tarjeta;
	private String nombre;
	private String ctacte;
	private BigDecimal liquido;
	
	public FuncModoCobroSummary(){
		
	}
	
	public FuncModoCobroSummary(Short tarjeta, String nombre, String ctacte, BigDecimal liquido){
		this.tarjeta = tarjeta;
		this.nombre = nombre;
		this.ctacte = ctacte;
		this.liquido = liquido;
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
	public String getCtacte() {
		return ctacte;
	}
	public void setCtacte(String ctacte) {
		this.ctacte = ctacte;
	}
	public BigDecimal getLiquido() {
		return liquido;
	}
	public void setLiquido(BigDecimal liquido) {
		this.liquido = liquido;
	}
	
}
