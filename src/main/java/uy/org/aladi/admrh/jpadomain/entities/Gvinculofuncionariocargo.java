package uy.org.aladi.admrh.jpadomain.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the gvinculofuncionariocargo database table.
 * 
 */
@Entity
@Table(name="gvinculofuncionariocargo")
public class Gvinculofuncionariocargo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idgVinculoFuncionarioCargo;
	private Date fechaInicial;
	private Short idGgrados;
	private Long idGplanta;
	private Short tarjeta;
	private Short vinculo;
	private String vinculoDescrip;
	private Date fechaFinal;
	private BigDecimal valorComplemento;

	public Gvinculofuncionariocargo() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idgVinculoFuncionarioCargo", unique = true, nullable = false)
	public Long getIdgVinculoFuncionarioCargo() {
		return this.idgVinculoFuncionarioCargo;
	}

	public void setIdgVinculoFuncionarioCargo(Long idgVinculoFuncionarioCargo) {
		this.idgVinculoFuncionarioCargo = idgVinculoFuncionarioCargo;
	}

	@Column(name="idGplanta")
	public Long getIdGplanta() {
		return idGplanta;
	}

	public void setIdGplanta(Long idGplanta) {
		this.idGplanta = idGplanta;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="fechaInicial", length = 10)
	public Date getFechaInicial() {
		return this.fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	@Column(name="idGgrados")
	public Short getIdGgrados() {
		return this.idGgrados;
	}

	public void setIdGgrados(Short idGgrados) {
		this.idGgrados = idGgrados;
	}


	@Column(name = "Tarjeta", nullable = false)
	public Short getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

	@Column(name="vinculo")
	public Short getVinculo() {
		return this.vinculo;
	}

	public void setVinculo(Short vinculo) {
		this.vinculo = vinculo;
	}

	@Column(name="vinculoDescrip")
	public String getVinculoDescrip() {
		return this.vinculoDescrip;
	}

	public void setVinculoDescrip(String vinculoDescrip) {
		this.vinculoDescrip = vinculoDescrip;
	}

	public BigDecimal getValorComplemento() {
		return valorComplemento;
	}

	public void setValorComplemento(BigDecimal valorComplemento) {
		this.valorComplemento = valorComplemento;
	}

	@Temporal(TemporalType.DATE)
	@Column(name="fechaFinal", length = 10)
	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}


}