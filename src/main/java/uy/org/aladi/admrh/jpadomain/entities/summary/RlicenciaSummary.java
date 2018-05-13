package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;

public class RlicenciaSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -378366908127653402L;
	private Long idRlicencia;
	private Long idGplanta;
	private String tarjeta;
	private String nombreFunc;
	private String nombreAutorizante;
	private String fechaSolicitud;
	private String fechaDesde;
	private String fechaHasta;
	private String direccion;
	private String telefono;
	private Integer dias;
	private Integer saldoActual;
	private Integer saldoAnterior;
	private Integer saldoPreAnterior;
	private Integer saldoCompensacion;
	private Integer saldoAntActual;
	private Integer saldoAntAnterior;
	private Integer saldoAntPreAnterior;
	private Integer saldoAntCompensacion;
	private Short idRcodigos;
	private String descCodigo;
	private String situacion;
	
	public RlicenciaSummary(){
		super();
	}
	
	public Long getIdRlicencia() {
		return idRlicencia;
	}


	public void setIdRlicencia(Long idRlicencia) {
		this.idRlicencia = idRlicencia;
	}


	public Long getIdGplanta() {
		return idGplanta;
	}
	public void setIdGplanta(Long idGplanta) {
		this.idGplanta = idGplanta;
	}
	public String getNombreFunc() {
		return nombreFunc;
	}
	public void setNombreFunc(String nombreFunc) {
		this.nombreFunc = nombreFunc;
	}

	public String getNombreAutorizante() {
		return nombreAutorizante;
	}

	public void setNombreAutorizante(String nombreAutorizante) {
		this.nombreAutorizante = nombreAutorizante;
	}

	public Short getIdRcodigos() {
		return idRcodigos;
	}

	public void setIdRcodigos(Short idRcodigos) {
		this.idRcodigos = idRcodigos;
	}

	public String getDescCodigo() {
		return descCodigo;
	}

	public void setDescCodigo(String descCodigo) {
		this.descCodigo = descCodigo;
	}

	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	public String getFechaDesde() {
		return fechaDesde;
	}


	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}


	public String getFechaHasta() {
		return fechaHasta;
	}


	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Integer getSaldoAnterior() {
		return saldoAnterior;
	}


	public void setSaldoAnterior(Integer saldoAnterior) {
		this.saldoAnterior = saldoAnterior;
	}


	public Integer getSaldoPreAnterior() {
		return saldoPreAnterior;
	}


	public void setSaldoPreAnterior(Integer saldoPreAnterior) {
		this.saldoPreAnterior = saldoPreAnterior;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Integer getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(Integer saldoActual) {
		this.saldoActual = saldoActual;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

	public Integer getSaldoCompensacion() {
		return saldoCompensacion;
	}

	public void setSaldoCompensacion(Integer saldoCompensacion) {
		this.saldoCompensacion = saldoCompensacion;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Integer getSaldoAntActual() {
		return saldoAntActual;
	}

	public void setSaldoAntActual(Integer saldoAntActual) {
		this.saldoAntActual = saldoAntActual;
	}

	public Integer getSaldoAntAnterior() {
		return saldoAntAnterior;
	}

	public void setSaldoAntAnterior(Integer saldoAntAnterior) {
		this.saldoAntAnterior = saldoAntAnterior;
	}

	public Integer getSaldoAntPreAnterior() {
		return saldoAntPreAnterior;
	}

	public void setSaldoAntPreAnterior(Integer saldoAntPreAnterior) {
		this.saldoAntPreAnterior = saldoAntPreAnterior;
	}

	public Integer getSaldoAntCompensacion() {
		return saldoAntCompensacion;
	}

	public void setSaldoAntCompensacion(Integer saldoAntCompensacion) {
		this.saldoAntCompensacion = saldoAntCompensacion;
	}

}
