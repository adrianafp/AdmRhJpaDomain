package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReciboHaberesSummary implements Serializable {

	private static final long serialVersionUID = 4433760886709424783L;
	private Short tarjeta;
	private String nombre;
	private String sector;
	private BigDecimal cotizacion;
	private BigDecimal pctDisponible;
	private BigDecimal capIntegActual;
	private BigDecimal capDisponible;
	private BigDecimal numerales;
	private BigDecimal totalAdiciones;
	private BigDecimal totalDeducciones;
	private BigDecimal totalliquido;
	private String sfechaHoy;
	private String smesRecibo;
	private List<LineasReciboSummary> lstLineas = new ArrayList<LineasReciboSummary>();

	public ReciboHaberesSummary(){
		
	}
	
	public ReciboHaberesSummary(Short tarjeta, String nombre, String sector, BigDecimal cotizacion, 
				BigDecimal pctDisponible, BigDecimal capIntegActual, 
				BigDecimal capDisponible, BigDecimal numerales, BigDecimal totalAdiciones, 
				BigDecimal totalDeducciones, BigDecimal totalliquido, String sfechaHoy, 
				String smesRecibo, List<LineasReciboSummary> lstLineas)
	{
		this.tarjeta = tarjeta;
		this.nombre = nombre;
		this.sector = sector;
		this.cotizacion = cotizacion;
		this.pctDisponible = pctDisponible;
		this.capIntegActual = capIntegActual;
		this.capDisponible = capDisponible;
		this.numerales = numerales;
		this.totalAdiciones = totalAdiciones;
		this.totalDeducciones = totalDeducciones;
		this.totalliquido = totalliquido;
		this.sfechaHoy = sfechaHoy;
		this.smesRecibo = smesRecibo;
		this.lstLineas = lstLineas;
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
	public BigDecimal getCapIntegActual() {
		return capIntegActual;
	}
	public void setCapIntegActual(BigDecimal capIntegActual) {
		this.capIntegActual = capIntegActual;
	}
	public String getSfechaHoy() {
		return sfechaHoy;
	}
	public void setSfechaHoy(String sfechaHoy) {
		this.sfechaHoy = sfechaHoy;
	}
	public BigDecimal getNumerales() {
		return numerales;
	}

	public void setNumerales(BigDecimal numerales) {
		this.numerales = numerales;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public BigDecimal getCapDisponible() {
		return capDisponible;
	}

	public void setCapDisponible(BigDecimal capDisponible) {
		this.capDisponible = capDisponible;
	}

	public BigDecimal getTotalAdiciones() {
		return totalAdiciones;
	}

	public void setTotalAdiciones(BigDecimal totalAdiciones) {
		this.totalAdiciones = totalAdiciones;
	}

	public BigDecimal getTotalDeducciones() {
		return totalDeducciones;
	}

	public void setTotalDeducciones(BigDecimal totalDeducciones) {
		this.totalDeducciones = totalDeducciones;
	}

	public BigDecimal getTotalliquido() {
		return totalliquido;
	}

	public void setTotalliquido(BigDecimal totalliquido) {
		this.totalliquido = totalliquido;
	}

	public String getSmesRecibo() {
		return smesRecibo;
	}

	public void setSmesRecibo(String smesRecibo) {
		this.smesRecibo = smesRecibo;
	}

	public BigDecimal getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(BigDecimal cotizacion) {
		this.cotizacion = cotizacion;
	}

	public BigDecimal getPctDisponible() {
		return pctDisponible;
	}

	public void setPctDisponible(BigDecimal pctDisponible) {
		this.pctDisponible = pctDisponible;
	}

	public List<LineasReciboSummary> getLstLineas() {
		return lstLineas;
	}

	public void setLstLineas(List<LineasReciboSummary> lstLineas) {
		this.lstLineas = lstLineas;
	}
}
