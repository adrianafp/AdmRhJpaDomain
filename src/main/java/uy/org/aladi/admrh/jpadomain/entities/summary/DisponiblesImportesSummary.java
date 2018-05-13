package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class DisponiblesImportesSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6617878376962257849L;

	private String tarjetaNombre;
	private BigDecimal[] disponibles;
	
	public DisponiblesImportesSummary(){
		super();
	}
	
	public DisponiblesImportesSummary(String tarjetaNombre, int cantMeses){
		this.tarjetaNombre = tarjetaNombre;
		disponibles = new BigDecimal[cantMeses];
	}
	
	public String getTarjetaNombre() {
		return tarjetaNombre;
	}
	public void setTarjetaNombre(String tarjetaNombre) {
		this.tarjetaNombre = tarjetaNombre;
	}
	public BigDecimal[] getDisponibles() {
		return disponibles;
	}
	public void setDisponibles(BigDecimal[] disponibles) {
		this.disponibles = disponibles;
	}
	
}
