package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SolicitudPrestamoSummary implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3484510248531024606L;
	private Short tarjeta;
	private String nombre;
	private Integer idFprestamos;
	private Integer nroPrestamo;
	private String fechaPrestamo;
	private String tipoPrestamo;
	private BigDecimal capital;
	private BigDecimal tasa;
	private Short cantCuotas;
	private BigDecimal valorCuota;
	private Short cuotasPagas;
	private BigDecimal saldoPrestamo;
	private String moneda;
    private Date fechaSaldo;
    private Boolean prestamoNuevo;
    private Short cesionTarjeta;
    private String cesionNombre;
    private boolean selected;
    private String motivo;
    
	public SolicitudPrestamoSummary(){
		
	}
	
	public SolicitudPrestamoSummary(Short tarjeta, String nombre, Integer idFprestamos, Integer nroPrestamo,
			String tipoPrestamo, BigDecimal capital, BigDecimal tasa, Short cantcuotas, 
			BigDecimal vcuota, BigDecimal saldoPrestamo){
		this.tarjeta = tarjeta;
		this.nombre = nombre;
		this.idFprestamos = idFprestamos;
		this.nroPrestamo = nroPrestamo;
		this.tipoPrestamo = tipoPrestamo;
		this.capital = capital;
		this.tasa = tasa;
		this.cantCuotas = cantcuotas;
		this.valorCuota = vcuota;
		this.saldoPrestamo = saldoPrestamo;
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
	public Integer getIdFprestamos() {
		return idFprestamos;
	}
	public void setIdFprestamos(Integer idFprestamos) {
		this.idFprestamos = idFprestamos;
	}
	public Integer getNroPrestamo() {
		return nroPrestamo;
	}
	public void setNroPrestamo(Integer nroPrestamo) {
		this.nroPrestamo = nroPrestamo;
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
	public BigDecimal getSaldoPrestamo() {
		return saldoPrestamo;
	}
	public void setSaldoPrestamo(BigDecimal saldoPrestamo) {
		this.saldoPrestamo = saldoPrestamo;
	}

	public Date getFechaSaldo() {
		return fechaSaldo;
	}

	public void setFechaSaldo(Date fechaSaldo) {
		this.fechaSaldo = fechaSaldo;
	}

	public Boolean getPrestamoNuevo() {
		return prestamoNuevo;
	}

	public void setPrestamoNuevo(Boolean prestamoNuevo) {
		this.prestamoNuevo = prestamoNuevo;
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

	public Short getCuotasPagas() {
		return cuotasPagas;
	}

	public void setCuotasPagas(Short cuotasPagas) {
		this.cuotasPagas = cuotasPagas;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

}
