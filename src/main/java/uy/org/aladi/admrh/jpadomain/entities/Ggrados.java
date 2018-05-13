package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ggrados database table.
 * 
 */
@Entity
@Table(name="ggrados")
public class Ggrados implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Short idGGrados;

	@Column
	private Integer idGCategoria;
	
	@Column
	private BigDecimal basico;

	@Column
	private String nomGrado;

	//bi-directional many-to-one association to Gplanta
	@OneToMany(mappedBy="ggrados")
	private List<Gplanta> gplantas;

	public Ggrados() {
	}

	public Short getIdGGrados() {
		return this.idGGrados;
	}

	public void setIdGGrados(Short idGGrados) {
		this.idGGrados = idGGrados;
	}

	public Integer getIdGCategoria() {
		return this.idGCategoria;
	}

	public void setIdGCategoria(Integer idGCategoria) {
		this.idGCategoria = idGCategoria;
	}

	public BigDecimal getBasico() {
		return this.basico;
	}

	public void setBasico(BigDecimal basico) {
		this.basico = basico;
	}

	public String getNomGrado() {
		return this.nomGrado;
	}

	public void setNomGrado(String nomGrado) {
		this.nomGrado = nomGrado;
	}

	public List<Gplanta> getGplantas() {
		return this.gplantas;
	}

	public void setGplantas(List<Gplanta> gplantas) {
		this.gplantas = gplantas;
	}


}