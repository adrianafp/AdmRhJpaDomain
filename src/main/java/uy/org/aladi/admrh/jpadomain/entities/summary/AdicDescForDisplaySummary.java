package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class AdicDescForDisplaySummary implements Serializable{

	private static final long serialVersionUID = -1559385182721186116L;
	private Long idAdicDesc;
	private Short idFcodigo;
	private String tipo;
	private String descripcion;
	private Short cantidad;
	private BigDecimal importe;
	private String moneda;
	private Short tarjeta;
	private String nombre;
	
	public AdicDescForDisplaySummary(){
		
	}

	public Short getIdFcodigo() {
		return idFcodigo;
	}

	public void setIdFcodigo(Short idFcodigo) {
		this.idFcodigo = idFcodigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public Long getIdAdicDesc() {
		return idAdicDesc;
	}

	public void setIdAdicDesc(Long idAdicDesc) {
		this.idAdicDesc = idAdicDesc;
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
	
	
}
