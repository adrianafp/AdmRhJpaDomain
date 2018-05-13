package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;

public class RboletaSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -378366908127653402L;
	private Long idRboleta;
	private Long idGplanta;
	private String nombreFunc;
	private String nombreAutorizante;
	private String fecha;
	private String horaDesde;
	private String horaHasta;
	private String motivo;
	private Short idRcodigos;
	private String descCodigo;
	private String situacion;
	private Boolean selected;
	
	public RboletaSummary(){
		super();
	}
	
	public Long getIdRboleta() {
		return idRboleta;
	}

	public void setIdRboleta(Long idRboleta) {
		this.idRboleta = idRboleta;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHoraDesde() {
		return horaDesde;
	}

	public void setHoraDesde(String horaDesde) {
		this.horaDesde = horaDesde;
	}

	public String getHoraHasta() {
		return horaHasta;
	}

	public void setHoraHasta(String horaHasta) {
		this.horaHasta = horaHasta;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
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

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

}
