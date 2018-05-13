package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class EstadoDeCuentaSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -653488515007063125L;
	private Short tarjeta;
	private String nombre;
	private BigDecimal basico;
	private BigDecimal capIntegActual;
	private BigDecimal capDispOperable;
	private BigDecimal saldoAcumprsts;
	private BigDecimal saldoDisponible;
	private BigDecimal numerales;
	private BigDecimal totalCuotas;
	private BigDecimal cuarentaporciento;
	private String sfechaHoy;
	private String sfechaEstado;
	private List<SolicitudPrestamoSummary> lstPrstSummary = new ArrayList<SolicitudPrestamoSummary>();
	private List<SolicitudPrestamoSummary> lstPrstConsumoSummary = new ArrayList<SolicitudPrestamoSummary>();
	private FuncionarioConResultadosDistribucion funcCuadroDistribucion;
	private String totalDistribuido;
	private String pctFuncionario;
	private String resultadoIndividuo;
	
	public EstadoDeCuentaSummary(){
		
	}
	
	public EstadoDeCuentaSummary(Short tarjeta, String nombre, BigDecimal basico, BigDecimal capIntegActual, 
				BigDecimal capDispOperable, BigDecimal saldoAcumprsts, BigDecimal saldoDisponible, 
				BigDecimal numerales, BigDecimal totalCuotas, BigDecimal cuarentaporciento, String sfechaHoy, 
				String sfechaEstado, FuncionarioConResultadosDistribucion funcCuadroDistribucion, 
				String totalDistribuido, String pctFuncionario, String resultadoIndividuo){
		this.tarjeta = tarjeta;
		this.nombre = nombre;
		this.basico = basico;
		this.capIntegActual = capIntegActual;
		this.capDispOperable = capDispOperable;
		this.saldoAcumprsts = saldoAcumprsts;
		this.saldoDisponible = saldoDisponible;
		this.numerales = numerales;
		this.totalCuotas = totalCuotas;
		this.cuarentaporciento = cuarentaporciento;
		this.sfechaHoy = sfechaHoy;
		this.sfechaEstado = sfechaEstado;
		this.funcCuadroDistribucion = funcCuadroDistribucion;
		this.totalDistribuido = totalDistribuido;
		this.pctFuncionario = pctFuncionario;
		this.resultadoIndividuo = resultadoIndividuo;
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
	public BigDecimal getBasico() {
		return basico;
	}
	public void setBasico(BigDecimal basico) {
		this.basico = basico;
	}
	public BigDecimal getCapIntegActual() {
		return capIntegActual;
	}
	public void setCapIntegActual(BigDecimal capIntegActual) {
		this.capIntegActual = capIntegActual;
	}
	public BigDecimal getCapDispOperable() {
		return capDispOperable;
	}
	public void setCapDispOperable(BigDecimal capDispOperable) {
		this.capDispOperable = capDispOperable;
	}
	public BigDecimal getSaldoAcumprsts() {
		return saldoAcumprsts;
	}
	public void setSaldoAcumprsts(BigDecimal saldoAcumprsts) {
		this.saldoAcumprsts = saldoAcumprsts;
	}
	public BigDecimal getSaldoDisponible() {
		return saldoDisponible;
	}
	public void setSaldoDisponible(BigDecimal saldoDisponible) {
		this.saldoDisponible = saldoDisponible;
	}
	public BigDecimal getTotalCuotas() {
		return totalCuotas;
	}
	public void setTotalCuotas(BigDecimal totalCuotas) {
		this.totalCuotas = totalCuotas;
	}
	public BigDecimal getCuarentaporciento() {
		return cuarentaporciento;
	}
	public void setCuarentaporciento(BigDecimal cuarentaporciento) {
		this.cuarentaporciento = cuarentaporciento;
	}
	public String getSfechaHoy() {
		return sfechaHoy;
	}
	public void setSfechaHoy(String sfechaHoy) {
		this.sfechaHoy = sfechaHoy;
	}
	public String getSfechaEstado() {
		return sfechaEstado;
	}
	public void setSfechaEstado(String sfechaEstado) {
		this.sfechaEstado = sfechaEstado;
	}
	public List<SolicitudPrestamoSummary> getLstPrstSummary() {
		return lstPrstSummary;
	}
	public void setLstPrstSummary(List<SolicitudPrestamoSummary> lstPrstSummary) {
		this.lstPrstSummary = lstPrstSummary;
	}
	public List<SolicitudPrestamoSummary> getLstPrstConsumoSummary() {
		return lstPrstConsumoSummary;
	}
	public void setLstPrstConsumoSummary(List<SolicitudPrestamoSummary> lstPrstConsumoSummary) {
		this.lstPrstConsumoSummary = lstPrstConsumoSummary;
	}
	public FuncionarioConResultadosDistribucion getFuncCuadroDistribucion() {
		return funcCuadroDistribucion;
	}
	public void setFuncCuadroDistribucion(FuncionarioConResultadosDistribucion funcCuadroDistribucion) {
		this.funcCuadroDistribucion = funcCuadroDistribucion;
	}

	public String getTotalDistribuido() {
		return totalDistribuido;
	}

	public void setTotalDistribuido(String totalDistribuido) {
		this.totalDistribuido = totalDistribuido;
	}

	public String getPctFuncionario() {
		return pctFuncionario;
	}

	public void setPctFuncionario(String pctFuncionario) {
		this.pctFuncionario = pctFuncionario;
	}

	public String getResultadoIndividuo() {
		return resultadoIndividuo;
	}

	public void setResultadoIndividuo(String resultadoIndividuo) {
		this.resultadoIndividuo = resultadoIndividuo;
	}

	public BigDecimal getNumerales() {
		return numerales;
	}

	public void setNumerales(BigDecimal numerales) {
		this.numerales = numerales;
	}
}
