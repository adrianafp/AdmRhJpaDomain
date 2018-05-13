package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fprocedimientos database table.
 * 
 */
@Entity
@Table(name="fprocedimientos")
public class Fprocedimientos implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idfprocedimientos;

	private String descripcion;

	public Fprocedimientos() {
	}

	public int getIdfprocedimientos() {
		return this.idfprocedimientos;
	}

	public void setIdfprocedimientos(int idfprocedimientos) {
		this.idfprocedimientos = idfprocedimientos;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}