package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class UserSolicitudPrestamoSummary implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3484510248531024606L;
	private Short tarjeta;
	private String nombre;
	private Integer idFsolicitud;
	private String fechaSolicitud;
	private String tipoPrestamo;
	private BigDecimal capital;
	private BigDecimal tasa;
	private Short cantCuotas;
	private BigDecimal valorCuota;
    private String moneda;
	private Short cesionTarjeta;
    private String cesionNombre;
    private boolean selected;
    private String situacion;
    private String prstCancelados;
    
    
	public UserSolicitudPrestamoSummary(){
		
	}
	
	public UserSolicitudPrestamoSummary(Short tarjeta, String nombre, Integer idFsolicitud, 
			String tipoPrestamo, BigDecimal capital, BigDecimal tasa, Short cantcuotas, 
			BigDecimal vcuota){
		this.tarjeta = tarjeta;
		this.nombre = nombre;
		this.idFsolicitud = idFsolicitud;
		this.tipoPrestamo = tipoPrestamo;
		this.capital = capital;
		this.tasa = tasa;
		this.cantCuotas = cantcuotas;
		this.valorCuota = vcuota;
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

	public String getTipoPrestamo() {
		return tipoPrestamo;
	}
	public void setTipoPrestamo(String tipoPrestamo) {
		this.tipoPrestamo = tipoPrestamo;
	}
	public BigDecimal getCapital() {
		return capital;
	}
	public void setCapital(BigDecimal capital) {
		this.capital = capital;
	}
	public BigDecimal getTasa() {
		return tasa;
	}
	public void setTasa(BigDecimal tasa) {
		this.tasa = tasa;
	}
	public Short getCantCuotas() {
		return cantCuotas;
	}
	public void setCantCuotas(Short cantCuotas) {
		this.cantCuotas = cantCuotas;
	}
	public BigDecimal getValorCuota() {
		return valorCuota;
	}
	public void setValorCuota(BigDecimal valorCuota) {
		this.valorCuota = valorCuota;
	}

	public Short getCesionTarjeta() {
		return cesionTarjeta;
	}

	public void setCesionTarjeta(Short cesionTarjeta) {
		this.cesionTarjeta = cesionTarjeta;
	}

	public String getCesionNombre() {
		return cesionNombre;
	}

	public void setCesionNombre(String cesionNombre) {
		this.cesionNombre = cesionNombre;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public Integer getIdFsolicitud() {
		return idFsolicitud;
	}

	public void setIdFsolicitud(Integer idFsolicitud) {
		this.idFsolicitud = idFsolicitud;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	public String getPrstCancelados() {
		return prstCancelados;
	}

	public void setPrstCancelados(String prstCancelados) {
		this.prstCancelados = prstCancelados;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}


}
