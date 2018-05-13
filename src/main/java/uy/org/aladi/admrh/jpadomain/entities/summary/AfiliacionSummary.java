package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class AfiliacionSummary implements Serializable {

	private static final long serialVersionUID = 4358363936226009027L;
	private Long id;
	private Short tarjeta;
	private String nomAfiliado;
	private String nroSocio;
	private String mutualista;
	private String plan;
	private BigDecimal valorCuota;
	private Boolean reembolso;
	private Boolean fonasa;
	private Boolean esFuncionario;
	
	public AfiliacionSummary(){
		
	}
	
	public AfiliacionSummary(Short tarjeta, String nomAfiliado, String nroSocio, String mutualista, 
							String plan, BigDecimal valorCuota, Boolean reembolso, Boolean fonasa, 
							Boolean esFuncionario){
		this.tarjeta = tarjeta;
		this.nomAfiliado = nomAfiliado;
		this.nroSocio = nroSocio;
		this.mutualista = mutualista;
		this.plan = plan;
		this.valorCuota = valorCuota;
		this.reembolso = reembolso;
		this.fonasa = fonasa;
		this.esFuncionario = esFuncionario;
	}
	
	public Short getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}
	public String getNomAfiliado() {
		return nomAfiliado;
	}
	public void setNomAfiliado(String nomAfiliado) {
		this.nomAfiliado = nomAfiliado;
	}
	public String getNroSocio() {
		return nroSocio;
	}
	public void setNroSocio(String nroSocio) {
		this.nroSocio = nroSocio;
	}
	public String getMutualista() {
		return mutualista;
	}
	public void setMutualista(String mutualista) {
		this.mutualista = mutualista;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public BigDecimal getValorCuota() {
		return valorCuota;
	}
	public void setValorCuota(BigDecimal valorCuota) {
		this.valorCuota = valorCuota;
	}

	public Boolean getEsFuncionario() {
		return esFuncionario;
	}

	public void setEsFuncionario(Boolean esFuncionario) {
		this.esFuncionario = esFuncionario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getReembolso() {
		return reembolso;
	}

	public void setReembolso(Boolean reembolso) {
		this.reembolso = reembolso;
	}

	public Boolean getFonasa() {
		return fonasa;
	}

	public void setFonasa(Boolean fonasa) {
		this.fonasa = fonasa;
	}
	
	
}
