package uy.org.aladi.admrh.jpadomain.entities;
// Generated 06/10/2014 08:58:58 AM by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * Fprestamos generated by hbm2java
 */
@Entity
@Table(name="fprestamos", uniqueConstraints = @UniqueConstraint(columnNames="NroPrestamo") 
)
public class Fprestamos  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 8670965676765518729L;
	private Integer idFprestamos;
     private Ftipoprestamo ftipoprestamo;
     private Gplanta gplanta;
     private Integer nroPrestamo;
     private Short tarjeta;
     private Date fechaPrestamo;
     private Short tipoPrestamo;
     private BigDecimal capitalPrestamo;
     private BigDecimal interesPrestamo;
     private BigDecimal cuota;
     private Short cantCuotas;
     private Short cuotasPagas;
     private BigDecimal saldoPrestamo;
     private Date fechaSaldo;
     private Boolean prestamoNuevo;
     private Short cesionTarjeta;

    public Fprestamos() {
    }

	
    public Fprestamos(Ftipoprestamo ftipoprestamo, Gplanta gplanta) {
        this.ftipoprestamo = ftipoprestamo;
        this.gplanta = gplanta;
    }
    public Fprestamos(Ftipoprestamo ftipoprestamo, Gplanta gplanta, Integer nroPrestamo, Short tarjeta, 
    		Date fechaPrestamo, BigDecimal capitalPrestamo, BigDecimal interesPrestamo, 
    		BigDecimal cuota, Short cantCuotas, Short cuotasPagas, BigDecimal saldoPrestamo, 
    		Date fechaSaldo, Boolean prestamoNuevo, Short cesionTarjeta) {
       this.ftipoprestamo = ftipoprestamo;
       this.gplanta = gplanta;
       this.nroPrestamo = nroPrestamo;
       this.tarjeta = tarjeta;
       this.fechaPrestamo = fechaPrestamo;
       this.capitalPrestamo = capitalPrestamo;
       this.interesPrestamo = interesPrestamo;
       this.cuota = cuota;
       this.cantCuotas = cantCuotas;
       this.cuotasPagas = cuotasPagas;
       this.saldoPrestamo = saldoPrestamo;
       this.fechaSaldo = fechaSaldo;
       this.prestamoNuevo = prestamoNuevo;
       this.cesionTarjeta = cesionTarjeta;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="idFPrestamos", unique=true, nullable=false)
    public Integer getIdFprestamos() {
        return this.idFprestamos;
    }
    
    public void setIdFprestamos(Integer idFprestamos) {
        this.idFprestamos = idFprestamos;
    }

    @ManyToOne
    @JoinColumn(name="idFtipoPrestamo", nullable=false)
    @NotNull
    public Ftipoprestamo getFtipoprestamo() {
        return this.ftipoprestamo;
    }
    
    public void setFtipoprestamo(Ftipoprestamo ftipoprestamo) {
        this.ftipoprestamo = ftipoprestamo;
    }

    @ManyToOne
    @JoinColumn(name="idGPlanta", nullable=false)
    @NotNull
    public Gplanta getGplanta() {
        return this.gplanta;
    }
    
    public void setGplanta(Gplanta gplanta) {
        this.gplanta = gplanta;
    }

    
    @Column(name="NroPrestamo", unique=true)
    public Integer getNroPrestamo() {
        return this.nroPrestamo;
    }
    
    public void setNroPrestamo(Integer nroPrestamo) {
        this.nroPrestamo = nroPrestamo;
    }

    
    @Column(name="Tarjeta")
    public Short getTarjeta() {
        return this.tarjeta;
    }
    
    public void setTarjeta(Short tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FechaPrestamo", length=10)
    public Date getFechaPrestamo() {
        return this.fechaPrestamo;
    }
    
    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    
    @Column(name="CapitalPrestamo", precision=10)
    public BigDecimal getCapitalPrestamo() {
        return this.capitalPrestamo;
    }
    
    public void setCapitalPrestamo(BigDecimal capitalPrestamo) {
        this.capitalPrestamo = capitalPrestamo;
    }

    
    @Column(name="InteresPrestamo", precision=6)
    public BigDecimal getInteresPrestamo() {
        return this.interesPrestamo;
    }
    
    public void setInteresPrestamo(BigDecimal interesPrestamo) {
        this.interesPrestamo = interesPrestamo;
    }

    
    @Column(name="Cuota", precision=6)
    public BigDecimal getCuota() {
        return this.cuota;
    }
    
    public void setCuota(BigDecimal cuota) {
        this.cuota = cuota;
    }

    
    @Column(name="CantCuotas")
    public Short getCantCuotas() {
        return this.cantCuotas;
    }
    
    public void setCantCuotas(Short cantCuotas) {
        this.cantCuotas = cantCuotas;
    }

    @Column(name="CuotasPagas")
    public Short getCuotasPagas() {
		return cuotasPagas;
	}


	public void setCuotasPagas(Short cuotasPagas) {
		this.cuotasPagas = cuotasPagas;
	}

    
    @Column(name="SaldoPrestamo", precision=10)
    public BigDecimal getSaldoPrestamo() {
        return this.saldoPrestamo;
    }
    
    public void setSaldoPrestamo(BigDecimal saldoPrestamo) {
        this.saldoPrestamo = saldoPrestamo;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FechaSaldo", length=10)
    public Date getFechaSaldo() {
        return this.fechaSaldo;
    }
    
    public void setFechaSaldo(Date fechaSaldo) {
        this.fechaSaldo = fechaSaldo;
    }

    
    @Column(name="PrestamoNuevo")
    public Boolean getPrestamoNuevo() {
        return this.prestamoNuevo;
    }
    
    public void setPrestamoNuevo(Boolean prestamoNuevo) {
        this.prestamoNuevo = prestamoNuevo;
    }

    
    @Column(name="CesionTarjeta")
    public Short getCesionTarjeta() {
        return this.cesionTarjeta;
    }
    
    public void setCesionTarjeta(Short cesionTarjeta) {
        this.cesionTarjeta = cesionTarjeta;
    }

    @Column(name="TipoPrestamo")
	public Short getTipoPrestamo() {
		return tipoPrestamo;
	}


	public void setTipoPrestamo(Short tipoPrestamo) {
		this.tipoPrestamo = tipoPrestamo;
	}


}


