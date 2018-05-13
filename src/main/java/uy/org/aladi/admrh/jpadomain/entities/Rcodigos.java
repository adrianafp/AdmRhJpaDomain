package uy.org.aladi.admrh.jpadomain.entities;

// Generated 06/10/2014 08:58:58 AM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Rcodigos generated by hbm2java
 */
@Entity
@Table(name = "rcodigos")
public class Rcodigos implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 265426229834031590L;
	private Short idRcodigos;
	private String descripcion;
	private Boolean diasAusent;
	private List<Rmarcanio> rmarcanio = new ArrayList<Rmarcanio>(0);
	private List<Rmarcashis> rmarcashis = new ArrayList<Rmarcashis>(0);
	private List<Rausentes> rausentes = new ArrayList<Rausentes>(0);
	private List<Rmarcames> rmarcames = new ArrayList<Rmarcames>(0);

	public Rcodigos() {
	}

	public Rcodigos(Short idRcodigos, Boolean diasAusent) {
		this.idRcodigos = idRcodigos;
		this.diasAusent = diasAusent;
	}

	public Rcodigos(Short idRcodigos, String descripcion, Boolean diasAusent,
			List<Rmarcanio> rmarcanios, List<Rmarcashis> rmarcashises,
			List<Rausentes> rausenteses, List<Rmarcames> rmarcameses) {
		this.idRcodigos = idRcodigos;
		this.descripcion = descripcion;
		this.diasAusent = diasAusent;
		this.rmarcanio = rmarcanios;
		this.rmarcashis = rmarcashises;
		this.rausentes = rausenteses;
		this.rmarcames = rmarcameses;
	}

	@Id
	@Column(name = "idRCodigos", unique = true, nullable = false)
	public Short getIdRcodigos() {
		return this.idRcodigos;
	}

	public void setIdRcodigos(Short idRcodigos) {
		this.idRcodigos = idRcodigos;
	}

	@Column(name = "Descripcion", length = 50)
	@Size(max = 50)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "DiasAusent", nullable = false)
	public Boolean isDiasAusent() {
		return this.diasAusent;
	}

	public void setDiasAusent(Boolean diasAusent) {
		this.diasAusent = diasAusent;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rcodigos")
	public List<Rmarcanio> getRmarcanio() {
		return this.rmarcanio;
	}

	public void setRmarcanio(List<Rmarcanio> rmarcanios) {
		this.rmarcanio = rmarcanios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rcodigos")
	public List<Rmarcashis> getRmarcashis() {
		return this.rmarcashis;
	}

	public void setRmarcashis(List<Rmarcashis> rmarcashises) {
		this.rmarcashis = rmarcashises;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rcodigos")
	public List<Rausentes> getRausentes() {
		return this.rausentes;
	}

	public void setRausentes(List<Rausentes> rausenteses) {
		this.rausentes = rausenteses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "rcodigos")
	public List<Rmarcames> getRmarcames() {
		return this.rmarcames;
	}

	public void setRmarcames(List<Rmarcames> rmarcameses) {
		this.rmarcames = rmarcameses;
	}


}