package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class FuncAdicDescSummary implements Serializable {

	private static final long serialVersionUID = 2437673727701156773L;
	private Short tarjeta;
	private String nombre;
	private String descCodigo;
	private String desde;
	private String hasta;
	private Integer sumaresta;
	private String cantidad;
	private BigDecimal importe;
	private String moneda;
	private Boolean selected;
	
	public FuncAdicDescSummary(){
		
	}
	
	public FuncAdicDescSummary(Short tarjeta, String nombre, String descCodigo, String desde, String hasta, 
			BigDecimal importe, 
			String moneda){
		this.tarjeta = tarjeta;
		this.nombre = nombre;
		this.descCodigo = descCodigo;
		this.desde = desde;
		this.hasta = hasta;
		this.importe = importe;
		this.moneda = moneda;
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

	public String getDescCodigo() {
		return descCodigo;
	}

	public void setDescCodigo(String descCodigo) {
		this.descCodigo = descCodigo;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getDesde() {
		return desde;
	}

	public void setDesde(String desde) {
		this.desde = desde;
	}

	public String getHasta() {
		return hasta;
	}

	public void setHasta(String hasta) {
		this.hasta = hasta;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public Integer getSumaresta() {
		return sumaresta;
	}

	public void setSumaresta(Integer sumaresta) {
		this.sumaresta = sumaresta;
	}
	
}
