package uy.org.aladi.admrh.jpadomain.entities;

// Generated 09/10/2014 04:22:01 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Fdatosdistribintereses generated by hbm2java
 */
@Entity
@Table(name = "fdatosdistribintereses")
public class Fdatosdistribintereses implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 634268960403300692L;
	private Long idfdatosdistribintereses;
	private String mesDistrib;
	private BigDecimal resultadoAdistrib;
	private BigDecimal totBaseDistrib;

	public Fdatosdistribintereses() {
	}

	public Fdatosdistribintereses(String mesDistrib,
			BigDecimal resultadoAdistrib, BigDecimal totBaseDistrib) {
		this.mesDistrib = mesDistrib;
		this.resultadoAdistrib = resultadoAdistrib;
		this.totBaseDistrib = totBaseDistrib;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idfdatosdistribintereses", unique = true, nullable = false)
	public Long getIdfdatosdistribintereses() {
		return this.idfdatosdistribintereses;
	}

	public void setIdfdatosdistribintereses(Long idfdatosdistribintereses) {
		this.idfdatosdistribintereses = idfdatosdistribintereses;
	}

	@Column(name = "MesDistrib", length = 6)
	@Size(max = 6)
	public String getMesDistrib() {
		return this.mesDistrib;
	}

	public void setMesDistrib(String mesDistrib) {
		this.mesDistrib = mesDistrib;
	}

	@Column(name = "ResultadoADistrib", precision = 10)
	public BigDecimal getResultadoAdistrib() {
		return this.resultadoAdistrib;
	}

	public void setResultadoAdistrib(BigDecimal resultadoAdistrib) {
		this.resultadoAdistrib = resultadoAdistrib;
	}

	@Column(name = "TotBaseDistrib", precision = 10)
	public BigDecimal getTotBaseDistrib() {
		return this.totBaseDistrib;
	}

	public void setTotBaseDistrib(BigDecimal totBaseDistrib) {
		this.totBaseDistrib = totBaseDistrib;
	}

}
