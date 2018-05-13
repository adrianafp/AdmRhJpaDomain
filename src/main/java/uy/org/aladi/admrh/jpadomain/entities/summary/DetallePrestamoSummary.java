package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DetallePrestamoSummary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3610332694945900675L;
	private Integer idFprestamos;
	private String nombFuncionario;
    private Date fechaPrestamo;
	private Integer nroPrestamo;
	private String tipoPrestamo;
    private BigDecimal capitalPrestamo;
    private BigDecimal interesPrestamo;
    private BigDecimal cuota;
    private Short cantCuotas;
    private Short plazoCorriente;
    private BigDecimal capitalCorriente;
    private Short plazoNoCorriente;
    private BigDecimal capitalNoCorriente;
    private Short cuotaNoPagas;
	private BigDecimal saldoPrestamo;
	private Date fechaSaldo;
	
	
	public DetallePrestamoSummary(){
		
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

	public String getNombFuncionario() {
		return nombFuncionario;
	}

	public void setNombFuncionario(String nombFuncionario) {
		this.nombFuncionario = nombFuncionario;
	}

	public Date getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(Date fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public BigDecimal getCapitalPrestamo() {
		return capitalPrestamo;
	}

	public void setCapitalPrestamo(BigDecimal capitalPrestamo) {
		this.capitalPrestamo = capitalPrestamo;
	}

	public BigDecimal getInteresPrestamo() {
		return interesPrestamo;
	}

	public void setInteresPrestamo(BigDecimal interesPrestamo) {
		this.interesPrestamo = interesPrestamo;
	}

	public BigDecimal getCuota() {
		return cuota;
	}

	public void setCuota(BigDecimal cuota) {
		this.cuota = cuota;
	}

	public Short getCantCuotas() {
		return cantCuotas;
	}

	public void setCantCuotas(Short cantCuotas) {
		this.cantCuotas = cantCuotas;
	}

	public Short getPlazoCorriente() {
		return plazoCorriente;
	}

	public void setPlazoCorriente(Short plazoCorriente) {
		this.plazoCorriente = plazoCorriente;
	}

	public BigDecimal getCapitalCorriente() {
		return capitalCorriente;
	}

	public void setCapitalCorriente(BigDecimal capitalCorriente) {
		this.capitalCorriente = capitalCorriente;
	}

	public Short getPlazoNoCorriente() {
		return plazoNoCorriente;
	}

	public void setPlazoNoCorriente(Short plazoNoCorriente) {
		this.plazoNoCorriente = plazoNoCorriente;
	}

	public BigDecimal getCapitalNoCorriente() {
		return capitalNoCorriente;
	}

	public void setCapitalNoCorriente(BigDecimal capitalNoCorriente) {
		this.capitalNoCorriente = capitalNoCorriente;
	}

	public Short getCuotaNoPagas() {
		return cuotaNoPagas;
	}

	public void setCuotaNoPagas(Short cuotaNoPagas) {
		this.cuotaNoPagas = cuotaNoPagas;
	}

}
