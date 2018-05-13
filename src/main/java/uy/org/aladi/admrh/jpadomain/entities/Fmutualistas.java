package uy.org.aladi.admrh.jpadomain.entities;

// Generated 06/10/2014 08:58:58 AM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Fmutualistas generated by hbm2java
 */
@Entity
@Table(name = "fmutualistas")
public class Fmutualistas implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4003411681034608399L;
	private Integer idFmutualistas;
	private String nombreMutual;
	private List<Fmutualistasplanes> fmutualistasplanes = new ArrayList<Fmutualistasplanes>();

	public Fmutualistas() {
	}

	public Fmutualistas(String nombreMutual) {
		this.nombreMutual = nombreMutual;
	}

	public Fmutualistas(String nombreMutual,
			List<Fmutualistasplanes> fmutualistasplaneses) {
		this.nombreMutual = nombreMutual;
		this.fmutualistasplanes = fmutualistasplaneses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "IdFMutualistas", unique = true, nullable = false)
	public Integer getIdFmutualistas() {
		return this.idFmutualistas;
	}

	public void setIdFmutualistas(Integer idFmutualistas) {
		this.idFmutualistas = idFmutualistas;
	}

	@Column(name = "NombreMutual", nullable = false, length = 60)
	@NotNull
	@Size(max = 60)
	public String getNombreMutual() {
		return this.nombreMutual;
	}

	public void setNombreMutual(String nombreMutual) {
		this.nombreMutual = nombreMutual;
	}

	@OneToMany(mappedBy = "fmutualistas", cascade=CascadeType.MERGE)
	public List<Fmutualistasplanes> getFmutualistasplanes() {
		return this.fmutualistasplanes;
	}

	public void setFmutualistasplanes(
			List<Fmutualistasplanes> fmutualistasplaneses) {
		this.fmutualistasplanes = fmutualistasplaneses;
	}

}
