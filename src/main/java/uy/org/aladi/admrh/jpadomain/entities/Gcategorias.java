package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the gcategorias database table.
 * 
 */
@Entity
@Table(name="gcategorias")
public class Gcategorias implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int idGCatetoria;

	@Column
	private String nomCategoria;

	//bi-directional many-to-one association to Gplanta
	@OneToMany(mappedBy="gcategorias")
	private List<Gplanta> gplantas;

	public Gcategorias() {
	}

	public int getIdGCatetoria() {
		return this.idGCatetoria;
	}

	public void setIdGCatetoria(int idGCatetoria) {
		this.idGCatetoria = idGCatetoria;
	}

	public String getNomCategoria() {
		return this.nomCategoria;
	}

	public void setNomCategoria(String nomCategoria) {
		this.nomCategoria = nomCategoria;
	}

	public List<Gplanta> getGplantas() {
		return this.gplantas;
	}

	public void setGplantas(List<Gplanta> gplantas) {
		this.gplantas = gplantas;
	}


}