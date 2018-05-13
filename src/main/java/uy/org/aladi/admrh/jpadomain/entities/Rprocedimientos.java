package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rprocedimientos database table.
 * 
 */
@Entity
@Table(name="rprocedimientos")
@NamedQuery(name="Rprocedimiento.findAll", query="SELECT r FROM Rprocedimientos r")
public class Rprocedimientos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idrprocedimientos;

	private String descripcion;

	//bi-directional many-to-one association to Rcategoria
	@ManyToOne
	@JoinColumn(name="idrcategorias")
	private Rcategorias rcategorias;

	public Rprocedimientos() {
	}

	public int getIdrprocedimientos() {
		return this.idrprocedimientos;
	}

	public void setIdrprocedimientos(int idrprocedimientos) {
		this.idrprocedimientos = idrprocedimientos;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Rcategorias getRcategorias() {
		return this.rcategorias;
	}

	public void setRcategorias(Rcategorias rcategoria) {
		this.rcategorias = rcategoria;
	}

}