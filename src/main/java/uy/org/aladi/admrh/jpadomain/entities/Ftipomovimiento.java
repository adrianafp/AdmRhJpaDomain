package uy.org.aladi.admrh.jpadomain.entities;

// Generated 06/10/2014 08:58:58 AM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

/**
 * Ftipomovimiento generated by hbm2java
 */
@Entity
@Table(name = "ftipomovimiento", uniqueConstraints = @UniqueConstraint(columnNames = "TipoMovimiento"))
public class Ftipomovimiento implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4398028466437973870L;
	private Integer idFtipoMovimiento;
	private Short tipoMovimiento;
	private String descripcion;
	private List<Fmovimientos> fmovimientos = new ArrayList<Fmovimientos>(0);

	public Ftipomovimiento() {
	}

	public Ftipomovimiento(Short tipoMovimiento, String descripcion,
			List<Fmovimientos> fmovimientoses) {
		this.tipoMovimiento = tipoMovimiento;
		this.descripcion = descripcion;
		this.fmovimientos = fmovimientoses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idFTipoMovimiento", unique = true, nullable = false)
	public Integer getIdFtipoMovimiento() {
		return this.idFtipoMovimiento;
	}

	public void setIdFtipoMovimiento(Integer idFtipoMovimiento) {
		this.idFtipoMovimiento = idFtipoMovimiento;
	}

	@Column(name = "TipoMovimiento", unique = true)
	public Short getTipoMovimiento() {
		return this.tipoMovimiento;
	}

	public void setTipoMovimiento(Short tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	@Column(name = "Descripcion", length = 50)
	@Size(max = 50)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ftipomovimiento")
	public List<Fmovimientos> getFmovimientos() {
		return this.fmovimientos;
	}

	public void setFmovimientos(List<Fmovimientos> fmovimientoses) {
		this.fmovimientos = fmovimientoses;
	}

}
