package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the fbancos_modocobro database table.
 * 
 */
@Entity
@Table(name="fbancos_modocobro")
@NamedQuery(name="FbancosModocobro.findAll", query="SELECT f FROM FbancosModocobro f")
public class FbancosModocobro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer idBcoMdoCobro;

	@Column
	private String banco;

	@Column
	private String descripModoCobro;

	public FbancosModocobro() {
	}

	public Integer getIdBcoMdoCobro() {
		return this.idBcoMdoCobro;
	}

	public void setIdBcoMdoCobro(Integer idBcoMdoCobro) {
		this.idBcoMdoCobro = idBcoMdoCobro;
	}

	public String getBanco() {
		return this.banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getDescripModoCobro() {
		return this.descripModoCobro;
	}

	public void setDescripModoCobro(String descripModoCobro) {
		this.descripModoCobro = descripModoCobro;
	}

}