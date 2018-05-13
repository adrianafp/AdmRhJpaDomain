package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class FuncionarioConResultadosDistribucion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2871959735839528142L;
	private Short tarjeta;
	private String nombre;
	private Integer colsCuadroDistri;
	private String anchoColsDistri;
	private String [] mesesFinales;
	private BigDecimal[] totalDistribuido;
	private BigDecimal[] participacionIndividual;
	private BigDecimal[] resultadoIndividual;
	
	public FuncionarioConResultadosDistribucion(){
		
	}

	public FuncionarioConResultadosDistribucion(Short tarjeta, String nombre, int cantMeses, Integer cols,
			String anchos){
		this.tarjeta = tarjeta;
		this.nombre = nombre;
		this.colsCuadroDistri = cols;
		this.anchoColsDistri = anchos;
		this.mesesFinales = new String[cantMeses];
		this.totalDistribuido = new BigDecimal[cantMeses];
		this.participacionIndividual = new BigDecimal[cantMeses];
		this.resultadoIndividual = new BigDecimal[cantMeses];
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

	public String [] getMesesFinales() {
		return mesesFinales;
	}

	public void setMesesFinales(String [] mesesFinales) {
		this.mesesFinales = mesesFinales;
	}

	public BigDecimal[] getTotalDistribuido() {
		return totalDistribuido;
	}

	public void setTotalDistribuido(BigDecimal[] totalDistribuido) {
		this.totalDistribuido = totalDistribuido;
	}

	public BigDecimal[] getParticipacionIndividual() {
		return participacionIndividual;
	}

	public void setParticipacionIndividual(BigDecimal[] participacionIndividual) {
		this.participacionIndividual = participacionIndividual;
	}

	public BigDecimal[] getResultadoIndividual() {
		return resultadoIndividual;
	}

	public void setResultadoIndividual(BigDecimal[] resultadoIndividual) {
		this.resultadoIndividual = resultadoIndividual;
	}

	public Integer getColsCuadroDistri() {
		return colsCuadroDistri;
	}

	public void setColsCuadroDistri(Integer colsCuadroDistri) {
		this.colsCuadroDistri = colsCuadroDistri;
	}

	public String getAnchoColsDistri() {
		return anchoColsDistri;
	}

	public void setAnchoColsDistri(String anchoColsDistri) {
		this.anchoColsDistri = anchoColsDistri;
	}
}
