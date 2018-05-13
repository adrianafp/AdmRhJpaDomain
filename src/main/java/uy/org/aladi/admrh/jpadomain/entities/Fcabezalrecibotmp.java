package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the fcabezalrecibotmp database table.
 * 
 */
@Entity
public class Fcabezalrecibotmp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idFCabezalRecibos;

	private BigDecimal adiciones;

	private BigDecimal cotizacion;

	private BigDecimal descuentos;

	private Short idFCodigos;

	private Long idGPlanta;

	private BigDecimal liquido;

	private String mesLiquidacion;

	private String nombre;

	private BigDecimal pctDisponible;

	private String sector;

	private Short tarjeta;

	//bi-directional many-to-one association to Fhaberesliquidadostmp
	@OneToMany(mappedBy="fcabezalrecibotmp")
	private List<Fhaberesliquidadostmp> fhaberesliquidadostmps;

	public Fcabezalrecibotmp() {
	}

	public Integer getIdFCabezalRecibos() {
		return this.idFCabezalRecibos;
	}

	public void setIdFCabezalRecibos(Integer idFCabezalRecibos) {
		this.idFCabezalRecibos = idFCabezalRecibos;
	}

	public BigDecimal getAdiciones() {
		return this.adiciones;
	}

	public void setAdiciones(BigDecimal adiciones) {
		this.adiciones = adiciones;
	}

	public BigDecimal getCotizacion() {
		return this.cotizacion;
	}

	public void setCotizacion(BigDecimal cotizacion) {
		this.cotizacion = cotizacion;
	}

	public BigDecimal getDescuentos() {
		return this.descuentos;
	}

	public void setDescuentos(BigDecimal descuentos) {
		this.descuentos = descuentos;
	}

	public Short getIdFCodigos() {
		return this.idFCodigos;
	}

	public void setIdFCodigos(Short idFCodigos) {
		this.idFCodigos = idFCodigos;
	}

	public Long getIdGPlanta() {
		return this.idGPlanta;
	}

	public void setIdGPlanta(Long idGPlanta) {
		this.idGPlanta = idGPlanta;
	}

	public BigDecimal getLiquido() {
		return this.liquido;
	}

	public void setLiquido(BigDecimal liquido) {
		this.liquido = liquido;
	}

	public String getMesLiquidacion() {
		return this.mesLiquidacion;
	}

	public void setMesLiquidacion(String mesLiquidacion) {
		this.mesLiquidacion = mesLiquidacion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPctDisponible() {
		return this.pctDisponible;
	}

	public void setPctDisponible(BigDecimal pctDisponible) {
		this.pctDisponible = pctDisponible;
	}

	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public Short getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

	public List<Fhaberesliquidadostmp> getFhaberesliquidadostmps() {
		return this.fhaberesliquidadostmps;
	}

	public void setFhaberesliquidadostmps(List<Fhaberesliquidadostmp> fhaberesliquidadostmps) {
		this.fhaberesliquidadostmps = fhaberesliquidadostmps;
	}

}