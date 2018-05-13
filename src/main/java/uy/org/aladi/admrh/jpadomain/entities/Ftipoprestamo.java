package uy.org.aladi.admrh.jpadomain.entities;

// Generated 07/10/2014 01:58:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

/**
 * Ftipoprestamo generated by hbm2java
 */
@Entity
@Table(name = "ftipoprestamo", uniqueConstraints = @UniqueConstraint(columnNames = "TipoPrestamo"))
public class Ftipoprestamo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8298371026923037337L;
	private Integer idFtipoPrestamo;
	private Short tipoPrestamo;
	private String descripcion;
	private List<Fprestamos> fprestamos = new ArrayList<Fprestamos>();
	
	public Ftipoprestamo() {
	}

	public Ftipoprestamo(Short tipoPrestamo, String descripcion) {
		this.tipoPrestamo = tipoPrestamo;
		this.descripcion = descripcion;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idFTipoPrestamo", unique = true, nullable = false)
	public Integer getIdFtipoPrestamo() {
		return this.idFtipoPrestamo;
	}

	public void setIdFtipoPrestamo(Integer idFtipoPrestamo) {
		this.idFtipoPrestamo = idFtipoPrestamo;
	}

	@Column(name = "TipoPrestamo", unique = true)
	public Short getTipoPrestamo() {
		return this.tipoPrestamo;
	}

	public void setTipoPrestamo(Short tipoPrestamo) {
		this.tipoPrestamo = tipoPrestamo;
	}

	@Column(name = "Descripcion", length = 50)
	@Size(max = 50)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ftipoprestamo")
	public List<Fprestamos> getFprestamos() {
		return fprestamos;
	}

	public void setFprestamos(List<Fprestamos> fprestamos) {
		this.fprestamos = fprestamos;
	}


}