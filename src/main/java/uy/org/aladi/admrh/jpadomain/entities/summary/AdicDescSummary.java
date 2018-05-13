package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AdicDescSummary implements Serializable{

	private static final long serialVersionUID = 6090504846540805614L;
	private Long idAdicDesc;
	private Short idFcodigo;
	private String tipo;
	private String descripcion;
	private Short cantidad;
	private BigDecimal importe;
	private String moneda;
	private Date desde;
	private Date hasta;
	
	public AdicDescSummary(){
		
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

	public Date getDesde() {
		return desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public Date getHasta() {
		return hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
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
	
	
}
