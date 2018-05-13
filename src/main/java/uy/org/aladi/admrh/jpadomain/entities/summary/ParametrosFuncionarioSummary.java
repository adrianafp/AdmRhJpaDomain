package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ParametrosFuncionarioSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3292633416357869966L;
	private Long idFparamFuncionario;
	private short tarjeta;
	private Short cantidad;
	private Date fechaDesde;
	private Date fechaHasta;
	private Short idFcodigos;
	private BigDecimal valorParametro;
	private String simbolo;
	private Long idFparametros;
	private String descripcion;


	public ParametrosFuncionarioSummary() {
	}

	public Long getIdFparamFuncionario() {
		return this.idFparamFuncionario;
	}

	public void setIdFparamFuncionario(Long idFparamFuncionario) {
		this.idFparamFuncionario = idFparamFuncionario;
	}

	public short getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(short tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Short getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Short cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaDesde() {
		return this.fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public Date getFechaHasta() {
		return this.fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public Short getIdFcodigos() {
		return idFcodigos;
	}

	public void setIdFcodigos(Short idFcodigos) {
		this.idFcodigos = idFcodigos;
	}

	public BigDecimal getValorParametro() {
		return valorParametro;
	}

	public void setValorParametro(BigDecimal valorParametro) {
		this.valorParametro = valorParametro;
	}

	public String getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getIdFparametros() {
		return idFparametros;
	}

	public void setIdFparametros(Long idFparametros) {
		this.idFparametros = idFparametros;
	}


}
