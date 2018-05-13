package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rcategorias database table.
 * 
 */
@Entity
@Table(name="rcategorias")
@NamedQuery(name="Rcategoria.findAll", query="SELECT r FROM Rcategorias r")
public class Rcategorias implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idrcategorias;

	private String descripcion;

	//bi-directional many-to-one association to Rprocedimiento
	@OneToMany(mappedBy="rcategorias")
	private List<Rprocedimientos> rprocedimientos;

	public Rcategorias() {
	}

	public int getIdrcategorias() {
		return this.idrcategorias;
	}

	public void setIdrcategorias(int idrcategorias) {
		this.idrcategorias = idrcategorias;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Rprocedimientos> getRprocedimientos() {
		return this.rprocedimientos;
	}

	public void setRprocedimientos(List<Rprocedimientos> rprocedimientos) {
		this.rprocedimientos = rprocedimientos;
	}

	public Rprocedimientos addRprocedimiento(Rprocedimientos rprocedimiento) {
		getRprocedimientos().add(rprocedimiento);
		rprocedimiento.setRcategorias(this);

		return rprocedimiento;
	}

	public Rprocedimientos removeRprocedimiento(Rprocedimientos rprocedimiento) {
		getRprocedimientos().remove(rprocedimiento);
		rprocedimiento.setRcategorias(null);

		return rprocedimiento;
	}

}