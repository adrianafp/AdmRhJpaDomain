package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;


/**
 * The persistent class for the fadicionesdesc database table.
 * 
 */
@Entity
@Table(name = "fadicionesdesc")
public class Fadicionesdesc implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long idFAdicionesDesc;

	private Short cantidad;

	private String descripcion;

	private Fcodigos fcodigos;

	private Gplanta gplanta;

	private BigDecimal importe;

	private String mesLiquidacion;

	private String moneda;

	private Short registro;

	private Short sumaResta;

	private Short tarjeta;

	public Fadicionesdesc() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdFAdicionesDesc() {
		return this.idFAdicionesDesc;
	}

	public void setIdFAdicionesDesc(Long idFAdicionesDesc) {
		this.idFAdicionesDesc = idFAdicionesDesc;
	}

	@Column(name = "Cantidad")
	public Short getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Short cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "Descripcion")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "Importe")
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

	@Column(name = "Registro")
	public Short getRegistro() {
		return this.registro;
	}

	public void setRegistro(Short registro) {
		this.registro = registro;
	}

	@Column(name = "SumaResta")
	public Short getSumaResta() {
		return this.sumaResta;
	}

	public void setSumaResta(Short sumaResta) {
		this.sumaResta = sumaResta;
	}

	@Column(name = "Tarjeta")
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