package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;

public class MesCierreDiasSummary implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3838040215479212591L;
	private String mesCierre;
	private Integer dias;
	
	public MesCierreDiasSummary(){	
	}

	public MesCierreDiasSummary(String mesCierre, Integer dias){
		this.mesCierre = mesCierre;
		this.dias = dias;
	}
	
	public String getMesCierre() {
		return mesCierre;
	}

	public void setMesCierre(String mesCierre) {
		this.mesCierre = mesCierre;
	}

	public Integer getDias() {
		return dias;
	}

	public void setDias(Integer dias) {
		this.dias = dias;
	}

}
