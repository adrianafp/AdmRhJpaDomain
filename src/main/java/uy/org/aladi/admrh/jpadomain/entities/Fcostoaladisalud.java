package uy.org.aladi.admrh.jpadomain.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the fcostoaladisalud database table.
 * 
 */
@Entity
public class Fcostoaladisalud implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idfcostoaladisalud;

	private Long idGplanta;

	private BigDecimal importe;

	private String mesLiquidacion;

	private String moneda;

	private Short tarjeta;

	public Fcostoaladisalud() {
	}

	public Integer getIdfcostoaladisalud() {
		return this.idfcostoaladisalud;
	}

	public void setIdfcostoaladisalud(Integer idfcostoaladisalud) {
		this.idfcostoaladisalud = idfcostoaladisalud;
	}

	public Long getIdGplanta() {
		return this.idGplanta;
	}

	public void setIdGplanta(Long idGplanta) {
		this.idGplanta = idGplanta;
	}

	public BigDecimal getImporte() {
		return this.importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public String getMesLiquidacion() {
		return this.mesLiquidacion;
	}

	public void setMesLiquidacion(String mesLiquidacion) {
		this.mesLiquidacion = mesLiquidacion;
	}

	public String getMoneda() {
		return this.moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public Short getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Short tarjeta) {
		this.tarjeta = tarjeta;
	}

}