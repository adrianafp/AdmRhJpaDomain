package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class FuncAfiliaSummary implements Serializable {
	
	private static final long serialVersionUID = -9006811618280854692L;
	private Short tarjeta;
	private String nombre;
	private Short cantidad;
	private BigDecimal importe;
	
	public FuncAfiliaSummary(){
		
	}
	
	public FuncAfiliaSummary(Short tarjeta, String nombre, Short cantidad, BigDecimal importe){
		this.tarjeta = tarjeta;
		this.nombre = nombre;
		this.setCantidad(cantidad);
		this.setImporte(importe);
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

	public Short getCantidad() {
		return cantidad;
	}

	public void setCantidad(Short cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

}
