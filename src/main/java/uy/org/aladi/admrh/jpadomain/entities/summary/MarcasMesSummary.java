package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;

public class MarcasMesSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 231786656668169727L;
	private Integer idRmarcames;
	private String tarjeta;
	private String nombre;
	private String fecha1;
	private String hora1;
	private String fecha2;
	private String hora2;
	private String fechaAnalisis;
	private String Observaciones;
	private Short idRcodigos;
	
	public MarcasMesSummary(){
		super();
	}

	public Integer getIdRmarcames() {
		return idRmarcames;
	}

	public void setIdRmarcames(Integer idRmarcames) {
		this.idRmarcames = idRmarcames;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha1() {
		return fecha1;
	}

	public void setFecha1(String fecha1) {
		this.fecha1 = fecha1;
	}

	public String getHora1() {
		return hora1;
	}

	public void setHora1(String hora1) {
		this.hora1 = hora1;
	}

	public String getFecha2() {
		return fecha2;
	}

	public void setFecha2(String fecha2) {
		this.fecha2 = fecha2;
	}

	public String getHora2() {
		return hora2;
	}

	public void setHora2(String hora2) {
		this.hora2 = hora2;
	}

	public String getObservaciones() {
		return Observaciones;
	}

	public void setObservaciones(String observaciones) {
		Observaciones = observaciones;
	}

	public String getFechaAnalisis() {
		return fechaAnalisis;
	}

	public void setFechaAnalisis(String fechaAnalisis) {
		this.fechaAnalisis = fechaAnalisis;
	}

	public Short getIdRcodigos() {
		return idRcodigos;
	}

	public void setIdRcodigos(Short idRcodigos) {
		this.idRcodigos = idRcodigos;
	}

}
