package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the gorganigrama database table.
 * 
 */
@Entity
@NamedQuery(name="Gorganigrama.findAll", query="SELECT g FROM Gorganigrama g")
public class Gorganigrama implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private short idGOrganigrama;

	@Column
	private String nomDepto;

	@Column
	private String siglaDepto;

	//bi-directional many-to-one association to Gplanta
	@OneToMany(mappedBy="gorganigrama")
	private List<Gplanta> gplantas;

	public Gorganigrama() {
	}

	public short getIdGOrganigrama() {
		return this.idGOrganigrama;
	}

	public void setIdGOrganigrama(short idGOrganigrama) {
		this.idGOrganigrama = idGOrganigrama;
	}

	public String getNomDepto() {
		return this.nomDepto;
	}

	public void setNomDepto(String nomDepto) {
		this.nomDepto = nomDepto;
	}

	public String getSiglaDepto() {
		return this.siglaDepto;
	}

	public void setSiglaDepto(String siglaDepto) {
		this.siglaDepto = siglaDepto;
	}

	public List<Gplanta> getGplantas() {
		return this.gplantas;
	}

	public void setGplantas(List<Gplanta> gplantas) {
		this.gplantas = gplantas;
	}

	public Gplanta addGplanta(Gplanta gplanta) {
		getGplantas().add(gplanta);
		gplanta.setGorganigrama(this);

		return gplanta;
	}

	public Gplanta removeGplanta(Gplanta gplanta) {
		getGplantas().remove(gplanta);
		gplanta.setGorganigrama(null);

		return gplanta;
	}

}