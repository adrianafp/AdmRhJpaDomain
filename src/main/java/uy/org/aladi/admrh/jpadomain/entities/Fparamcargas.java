package uy.org.aladi.admrh.jpadomain.entities;
// Generated 30/03/2015 11:00:05 AM by Hibernate Tools 3.4.0.CR1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * Fparamcargas generated by hbm2java
 */
@Entity
@Table(name="fparamcargas")
public class Fparamcargas  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = -4210069237058198684L;
	private Long idFparamCargas;
	private Gcargas gcargas;
	private Fparametros fparametros;
     private Short cantidad;
     private Date fechaDesde;
     private Date fechaHasta;
     private Short idFcodigos;

    public Fparamcargas() {
    }

	
    public Fparamcargas(Gcargas gcargas, Fparametros fparametros) {
    	this.gcargas = gcargas;
    	this.fparametros = fparametros;
    }

    public Fparamcargas(Gcargas gcargas, Fparametros fparametros, Short cantidad, Date fechaDesde, 
    		Date fechaHasta, Short idFcodigos) {
       this.gcargas = gcargas;
       this.fparametros = fparametros;
       this.cantidad = cantidad;
       this.fechaDesde = fechaDesde;
       this.fechaHasta = fechaHasta;
       this.idFcodigos = idFcodigos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="idFParamCargas", unique=true, nullable=false)
    public Long getIdFparamCargas() {
        return this.idFparamCargas;
    }
    
    public void setIdFparamCargas(Long idFparamCargas) {
        this.idFparamCargas = idFparamCargas;
    }
    

    
    @Column(name="Cantidad")
    public Short getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FechaDesde", length=10)
    public Date getFechaDesde() {
        return this.fechaDesde;
    }
    
    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FechaHasta", length=10)
    public Date getFechaHasta() {
        return this.fechaHasta;
    }
    
    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }


	@ManyToOne
	@JoinColumn(name = "idGCargas", nullable = false)
	@NotNull
	public Gcargas getGcargas() {
		return gcargas;
	}


	public void setGcargas(Gcargas gcargas) {
		this.gcargas = gcargas;
	}


	@ManyToOne
	@JoinColumn(name = "idFParametros", nullable = false)
	@NotNull
	public Fparametros getFparametros() {
		return fparametros;
	}


	public void setFparametros(Fparametros fparametros) {
		this.fparametros = fparametros;
	}


	@Column(name="idFcodigos")
	public Short getIdFcodigos() {
		return idFcodigos;
	}


	public void setIdFcodigos(Short idFcodigos) {
		this.idFcodigos = idFcodigos;
	}

}


