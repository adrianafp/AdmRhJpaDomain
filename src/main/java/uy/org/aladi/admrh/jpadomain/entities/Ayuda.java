package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;

import javax.persistence.*;



/**
 * The persistent class for the ayuda database table.
 * 
 */
@Entity
@Table(name="ayuda")
public class Ayuda implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idayuda;

	@Column
	private String clave;

	@Column
	private String texto;

	public Ayuda() {
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Integer getIdayuda() {
		return this.idayuda;
	}

	public void setIdayuda(Integer idayuda) {
		this.idayuda = idayuda;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}