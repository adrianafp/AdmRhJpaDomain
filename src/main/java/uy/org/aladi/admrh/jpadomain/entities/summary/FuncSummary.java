package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FuncSummary implements Serializable{
	
	private static final long serialVersionUID = -6472408322835534940L;
	private Short tarjeta;
	private String nombre;
	private Date ingreso;
	private BigDecimal basico;
	private Boolean tieneCta;
	private Boolean selected;
	private String nomGrado;
	private Short dias;
	private String vinculoDesc;
	private String fechaIniVinculo;
	
	
	public FuncSummary(){
		
	}
	
	public FuncSummary(Short tarjeta, String nombre, boolean selected){
		this.tarjeta = tarjeta;
		this.nombre = nombre;
		this.selected = selected;
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
	public Date getIngreso() {
		return ingreso;
	}
	public void setIngreso(Date ingreso) {
		this.ingreso = ingreso;
	}
	public BigDecimal getBasico() {
		return basico;
	}
	public void setBasico(BigDecimal basico) {
		this.basico = basico;
	}

	public Boolean getTieneCta() {
		return tieneCta;
	}

	public void setTieneCta(Boolean tieneCta) {
		this.tieneCta = tieneCta;
	}

	public Boolean getSelected(){
		return selected;
	}
	
	public Boolean isSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public String getNomGrado() {
		return nomGrado;
	}

	public void setNomGrado(String nomGrado) {
		this.nomGrado = nomGrado;
	}

	public Short getDias() {
		return dias;
	}

	public void setDias(Short dias) {
		this.dias = dias;
	}

	public String getVinculoDesc() {
		return vinculoDesc;
	}

	public void setVinculoDesc(String vinculoDesc) {
		this.vinculoDesc = vinculoDesc;
	}

	public String getFechaIniVinculo() {
		return fechaIniVinculo;
	}

	public void setFechaIniVinculo(String fechaIniVinculo) {
		this.fechaIniVinculo = fechaIniVinculo;
	}
	

}
