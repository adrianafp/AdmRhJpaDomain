package uy.org.aladi.admrh.jpadomain.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the ftasasprestamo database table.
 * 
 */
@Entity
public class Ftasasprestamo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idFTasasPrestamo;

	private String descripcion;

	private BigDecimal tasa;

	public Ftasasprestamo() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idFTasasPrestamo", unique = true, nullable = false)
	public Integer getIdFTasasPrestamo() {
		return this.idFTasasPrestamo;
	}

	public void setIdFTasasPrestamo(Integer idFTasasPrestamo) {
		this.idFTasasPrestamo = idFTasasPrestamo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getTasa() {
		return this.tasa;
	}

	public void setTasa(BigDecimal tasa) {
		this.tasa = tasa;
	}

}