package uy.org.aladi.admrh.jpadomain.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.*;



/**
 * The persistent class for the ractreganio database table.
 * 
 */
@Entity
@Table(name="ractreganio")
public class Ractreganio implements Serializable {
	private static final long serialVersionUID = 1L;

	private String idRActRegAnio;
	private String atflia_horas;
	private Short duelo;
	private String enfchse_horas;
	private Short enfcon_dias;
	private String enfcon_horas;
	private String enfRet_horas;
	private Short enfSin_3;
	private Short enfSin_dias;
	private String excat_horas;
	private Short excat_veces;
	private String extCom_horas;
	private String extDob_horas;
	private String extNor_horas;
	private String extSim_horas;
	private Short faltaCon;
	private Short faltaSin;
	private Short licComp;
	private Short licEsp;
	private Short licEst;
	private Short licMat;
	private Short licMatr;
	private Short licOrd;
	private Short licPais;
	private Short licPat;
	private String mesnro;
	private Short mserv_dias;
	private String mserv_horas;
	private String mservr_horas;
	private String salesp_horas;
	private Short sangre;
	private Short suspen;
	private String tardee_horas;
	private Short tardee_veces;
	private Short tarjeta;
	private String tiempX_horas;
	private String tmpXNoLab_horas;
	private Short diasTrabajados;

	public Ractreganio() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idRActRegAnio", unique = true, nullable = false)
	public String getIdRActRegAnio() {
		return this.idRActRegAnio;
	}

	public void setIdRActRegAnio(String idRActRegAnio) {
		this.idRActRegAnio = idRActRegAnio;
	}

	@Column(name="Atflia_horas")
	public String getAtflia_horas() {
		return this.atflia_horas;
	}

	public void setAtflia_horas(String atflia_horas) {
		this.atflia_horas = atflia_horas;
	}

	@Column(name="Duelo")
	public Short getDuelo() {
		return this.duelo;
	}

	public void setDuelo(Short duelo) {
		this.duelo = duelo;
	}

	@Column(name="Enfchse_horas")
	public String getEnfchse_horas() {
		return this.enfchse_horas;
	}

	public void setEnfchse_horas(String enfchse_horas) {
		this.enfchse_horas = enfchse_horas;
	}

	@Column(name="Enfcon_dias")
	public Short getEnfcon_dias() {
		return this.enfcon_dias;
	}

	public void setEnfcon_dias(Short enfcon_dias) {
		this.enfcon_dias = enfcon_dias;
	}

	@Column(name="Enfcon_horas")
	public String getEnfcon_horas() {
		return this.enfcon_horas;
	}

	public void setEnfcon_horas(String enfcon_horas) {
		this.enfcon_horas = enfcon_horas;
	}

	@Column(name="EnfRet_horas")
	public String getEnfRet_horas() {
		return this.enfRet_horas;
	}

	public void setEnfRet_horas(String enfRet_horas) {
		this.enfRet_horas = enfRet_horas;
	}

	@Column(name="EnfSin_3")
	public Short getEnfSin_3() {
		return this.enfSin_3;
	}

	public void setEnfSin_3(Short enfSin_3) {
		this.enfSin_3 = enfSin_3;
	}

	@Column(name="EnfSin_dias")
	public Short getEnfSin_dias() {
		return this.enfSin_dias;
	}

	public void setEnfSin_dias(Short enfSin_dias) {
		this.enfSin_dias = enfSin_dias;
	}

	@Column(name="Excat_horas")
	public String getExcat_horas() {
		return this.excat_horas;
	}

	public void setExcat_horas(String excat_horas) {
		this.excat_horas = excat_horas;
	}

	@Column(name="Excat_veces")
	public Short getExcat_veces() {
		return this.excat_veces;
	}

	public void setExcat_veces(Short excat_veces) {
		this.excat_veces = excat_veces;
	}

	@Column(name="ExtCom_horas")
	public String getExtCom_horas() {
		return this.extCom_horas;
	}

	public void setExtCom_horas(String extCom_horas) {
		this.extCom_horas = extCom_horas;
	}

	@Column(name="ExtDob_horas")
	public String getExtDob_horas() {
		return this.extDob_horas;
	}

	public void setExtDob_horas(String extDob_horas) {
		this.extDob_horas = extDob_horas;
	}

	@Column(name="ExtNor_horas")
	public String getExtNor_horas() {
		return this.extNor_horas;
	}

	public void setExtNor_horas(String extNor_horas) {
		this.extNor_horas = extNor_horas;
	}

	@Column(name="ExtSim_horas")
	public String getExtSim_horas() {
		return this.extSim_horas;
	}

	public void setExtSim_horas(String extSim_horas) {
		this.extSim_horas = extSim_horas;
	}

	@Column(name="FaltaCon")
	public Short getFaltaCon() {
		return this.faltaCon;
	}

	public void setFaltaCon(Short faltaCon) {
		this.faltaCon = faltaCon;
	}

	@Column(name="FaltaSin")
	public Short getFaltaSin() {
		return this.faltaSin;
	}

	public void setFaltaSin(Short faltaSin) {
		this.faltaSin = faltaSin;
	}

	@Column(name="LicComp")
	public Short getLicComp() {
		return this.licComp;
	}

	public void setLicComp(Short compensa) {
		this.licComp = compensa;
	}

	@Column(name="LicEsp")
	public Short getLicEsp() {
		return this.licEsp;
	}

	public void setLicEsp(Short licEsp) {
		this.licEsp = licEsp;
	}

	@Column(name="LicEst")
	public Short getLicEst() {
		return this.licEst;
	}

	public void setLicEst(Short licEst) {
		this.licEst = licEst;
	}

	@Column(name="LicMat")
	public Short getLicMat() {
		return this.licMat;
	}

	public void setLicMat(Short licMat) {
		this.licMat = licMat;
	}

	@Column(name="LicMatr")
	public Short getLicMatr() {
		return this.licMatr;
	}

	public void setLicMatr(Short licMatr) {
		this.licMatr = licMatr;
	}

	@Column(name="LicOrd")
	public Short getLicOrd() {
		return this.licOrd;
	}

	public void setLicOrd(Short licOrd) {
		this.licOrd = licOrd;
	}

	@Column(name="LicPais")
	public Short getLicPais() {
		return this.licPais;
	}

	public void setLicPais(Short licPais) {
		this.licPais = licPais;
	}

	@Column(name="LicPat")
	public Short getLicPat() {
		return this.licPat;
	}

	public void setLicPat(Short licPat) {
		this.licPat = licPat;
	}

	@Column(name = "Mesnro")
	public String getMesnro() {
		return this.mesnro;
	}

	public void setMesnro(String mesnro) {
		this.mesnro = mesnro;
	}

	@Column(name="Mserv_dias")
	public Short getMserv_dias() {
		return this.mserv_dias;
	}

	public void setMserv_dias(Short mserv_dias) {
		this.mserv_dias = mserv_dias;
	}

	@Column(name="Mserv_horas")
	public String getMserv_horas() {
		return this.mserv_horas;
	}

	public void setMserv_horas(String mserv_horas) {
		this.mserv_horas = mserv_horas;
	}

	@Column(name="Mservr_horas")
	public String getMservr_horas() {
		return this.mservr_horas;
	}

	public void setMservr_horas(String mservr_horas) {
		this.mservr_horas = mservr_horas;
	}

	@Column(name="Salesp_horas")
	public String getSalesp_horas() {
		return this.salesp_horas;
	}

	public void setSalesp_horas(String salesp_horas) {
		this.salesp_horas = salesp_horas;
	}

	@Column(name="Sangre")
	public Short getSangre() {
		return this.sangre;
	}

	public void setSangre(Short sangre) {
		this.sangre = sangre;
	}

	@Column(name="Suspen")
	public Short getSuspen() {
		return this.suspen;
	}

	public void setSuspen(Short suspen) {
		this.suspen = suspen;
	}

	@Column(name="Tardee_horas")
	public String getTardee_horas() {
		return this.tardee_horas;
	}

	public void setTardee_horas(String tardee_horas) {
		this.tardee_horas = tardee_horas;
	}

	@Column(name="Tardee_veces")
	public Short getTardee_veces() {
		return this.tardee_veces;
	}

	public void setTardee_veces(Short tardee_veces) {
		this.tardee_veces = tardee_veces;
	}

	@Column(name="Tarjeta")
	public Short getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

	@Column(name="TiempX_horas")
	public String getTiempX_horas() {
		return this.tiempX_horas;
	}

	public void setTiempX_horas(String tiempX_horas) {
		this.tiempX_horas = tiempX_horas;
	}

	@Column(name="TmpXNoLab_horas")
	public String getTmpXNoLab_horas() {
		return this.tmpXNoLab_horas;
	}

	public void setTmpXNoLab_horas(String tmpXNoLab_horas) {
		this.tmpXNoLab_horas = tmpXNoLab_horas;
	}

	@Column(name="DiasTrabajados")
	public Short getDiasTrabajados() {
		return diasTrabajados;
	}

	public void setDiasTrabajados(Short diasTrabajados) {
		this.diasTrabajados = diasTrabajados;
	}

}