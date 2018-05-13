package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;

public class AusenciaSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2602142055451571905L;

	private Long idRausentes;
    private Short idRcodigos;
    private Short tarjeta;
    private String nombre;
    private String sfechac;
    private String sfechaf;
    private String motivo;

	public AusenciaSummary(){
		super();
	}

	public Long getIdRausentes() {
		return idRausentes;
	}

	public void setIdRausentes(Long idRausentes) {
		this.idRausentes = idRausentes;
	}

	public Short getIdRcodigos() {
		return idRcodigos;
	}

	public void setIdRcodigos(Short idRcodigos) {
		this.idRcodigos = idRcodigos;
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

	public String getSfechac() {
		return sfechac;
	}

	public void setSfechac(String sfechac) {
		this.sfechac = sfechac;
	}

	public String getSfechaf() {
		return sfechaf;
	}

	public void setSfechaf(String sfechaf) {
		this.sfechaf = sfechaf;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	
}
