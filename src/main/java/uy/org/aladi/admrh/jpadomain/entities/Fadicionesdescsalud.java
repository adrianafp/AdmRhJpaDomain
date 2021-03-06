package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;


/**
 * The persistent class for the fadicionesdescsalud database table.
 * 
 */
@Entity
@Table(name="fadicionesdescsalud")
public class Fadicionesdescsalud implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idFAdicionesDescSalud;
	private Short cantidad;
	private Fcodigos fcodigos;
	private Integer idFMutualistas;
	private Gplanta gplanta;
	private BigDecimal importe;
	private String mesLiquidacion;
	private String moneda;
	private Short sumaResta;
	private Short tarjeta;

	public Fadicionesdescsalud() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdFAdicionesDescSalud() {
		return this.idFAdicionesDescSalud;
	}

	public void setIdFAdicionesDescSalud(Long idFAdicionesDescSalud) {
		this.idFAdicionesDescSalud = idFAdicionesDescSalud;
	}

	@Column(name = "Cantidad")
	public Short getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Short cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "idFMutualistas")
	public Integer getIdFMutualistas() {
		return this.idFMutualistas;
	}

	public void setIdFMutualistas(Integer idFMutualistas) {
		this.idFMutualistas = idFMutualistas;
	}

	@Column(name = "Importe", precision = 8)
	public BigDecimal getImporte() {
		return this.importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	@Column(name = "MesLiquidacion")
	public String getMesLiquidacion() {
		return this.mesLiquidacion;
	}

	public void setMesLiquidacion(String mesLiquidacion) {
		this.mesLiquidacion = mesLiquidacion;
	}

	@Column(name = "Moneda")
	public String getMoneda() {
		return this.moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	@Column(name="SumaResta")
	public Short getSumaResta() {
		return this.sumaResta;
	}

	public void setSumaResta(Short sumaResta) {
		this.sumaResta = sumaResta;
	}

	@Column(name="Tarjeta")
	public Short getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idFCodigos", nullable=false)
	@NotNull
	public Fcodigos getFcodigos() {
		return fcodigos;
	}

	public void setFcodigos(Fcodigos fcodigos) {
		this.fcodigos = fcodigos;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idGPlanta", nullable=false)
	@NotNull
	public Gplanta getGplanta() {
		return gplanta;
	}

	public void setGplanta(Gplanta gplanta) {
		this.gplanta = gplanta;
	}

}