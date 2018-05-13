package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class GgradosSummary implements Serializable {

	private static final long serialVersionUID = 8123632591314262914L;
	private Short idGgrados;
	private String nomGrado;
	private BigDecimal basico;
	private String categoria;
	
	public GgradosSummary(){
		super();
	}

	public Short getIdGgrados() {
		return idGgrados;
	}


	public void setIdGgrados(Short idGgrados) {
		this.idGgrados = idGgrados;
	}

	public String getNomGrado() {
		return nomGrado;
	}

	public void setNomGrado(String nomGrado) {
		this.nomGrado = nomGrado;
	}

	public BigDecimal getBasico() {
		return basico;
	}

	public void setBasico(BigDecimal basico) {
		this.basico = basico;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
