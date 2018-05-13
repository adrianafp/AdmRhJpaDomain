package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;


public class FamiliarSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4601409404477653558L;
	private Integer idGcargas;
	private Short tarjetaFunc;
	private String nombreFunc;
	private String nombreFamiliar;
	private String parentesco;
	private String nacimiento;
	private String discapacitado;
	private String sexo;
	private String mutualista;
	private Integer nroSocio;
	private String reembolso;
	private String afaladiSS;
	private String fonasa;
	private String motivoCambio;
	private String fechaCambio;
	
	public FamiliarSummary(){
		super();
	}

	public Integer getIdGcargas() {
		return idGcargas;
	}

	public void setIdGcargas(Integer idGcargas) {
		this.idGcargas = idGcargas;
	}

	public Short getTarjetaFunc() {
		return tarjetaFunc;
	}

	public void setTarjetaFunc(Short tarjetaFunc) {
		this.tarjetaFunc = tarjetaFunc;
	}

	public String getNombreFunc() {
		return nombreFunc;
	}

	public void setNombreFunc(String nombreFunc) {
		this.nombreFunc = nombreFunc;
	}

	public String getNombreFamiliar() {
		return nombreFamiliar;
	}

	public void setNombreFamiliar(String nombreFamiliar) {
		this.nombreFamiliar = nombreFamiliar;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getDiscapacitado() {
		return discapacitado;
	}

	public void setDiscapacitado(String discapacitado) {
		this.discapacitado = discapacitado;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getMutualista() {
		return mutualista;
	}

	public void setMutualista(String mutualista) {
		this.mutualista = mutualista;
	}

	public Integer getNroSocio() {
		return nroSocio;
	}

	public void setNroSocio(Integer nroSocio) {
		this.nroSocio = nroSocio;
	}

	public String getReembolso() {
		return reembolso;
	}

	public void setReembolso(String reembolso) {
		this.reembolso = reembolso;
	}

	public String getAfaladiSS() {
		return afaladiSS;
	}

	public void setAfaladiSS(String afaladiSS) {
		this.afaladiSS = afaladiSS;
	}

	public String getFonasa() {
		return fonasa;
	}

	public void setFonasa(String fonasa) {
		this.fonasa = fonasa;
	}

	public String getMotivoCambio() {
		return motivoCambio;
	}

	public void setMotivoCambio(String motivoCambio) {
		this.motivoCambio = motivoCambio;
	}

	public String getFechaCambio() {
		return fechaCambio;
	}

	public void setFechaCambio(String fechaCambio) {
		this.fechaCambio = fechaCambio;
	}
}
