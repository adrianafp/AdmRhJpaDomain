package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;

public class AjustesSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7497801710210475673L;

    private Short tarjeta;
    private String nombre;
    private String mesajuste;
    private String mescierre;
    private String pasade;
    private String pasaa;
    private String horas;
    private String dias;
    private String sfechac;
    private String sfechaf;

	public AjustesSummary(){
		super();
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

	public String getMesajuste() {
		return mesajuste;
	}

	public void setMesajuste(String mesajuste) {
		this.mesajuste = mesajuste;
	}

	public String getMescierre() {
		return mescierre;
	}

	public void setMescierre(String mescierre) {
		this.mescierre = mescierre;
	}

	public String getPasade() {
		return pasade;
	}

	public void setPasade(String pasade) {
		this.pasade = pasade;
	}

	public String getPasaa() {
		return pasaa;
	}

	public void setPasaa(String pasaa) {
		this.pasaa = pasaa;
	}

	public String getHoras() {
		return horas;
	}

	public void setHoras(String horas) {
		this.horas = horas;
	}

	public String getDias() {
		return dias;
	}

	public void setDias(String dias) {
		this.dias = dias;
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
}
