package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class RubroInstitucionSummary implements Serializable{

	private static final long serialVersionUID = 2158392663418748430L;
	private String codigoSalud;
	private BigDecimal totalCodigo;
	private List<MutualistaFuncionariosSummary> lstMutualistas;
	
	public RubroInstitucionSummary(){
		
	}

	public String getCodigoSalud() {
		return codigoSalud;
	}

	public void setCodigoSalud(String codigoSalud) {
		this.codigoSalud = codigoSalud;
	}

	public List<MutualistaFuncionariosSummary> getLstMutualistas() {
		return lstMutualistas;
	}

	public void setLstMutualistas(List<MutualistaFuncionariosSummary> lstMutualistas) {
		this.lstMutualistas = lstMutualistas;
	}

	public BigDecimal getTotalCodigo() {
		return totalCodigo;
	}

	public void setTotalCodigo(BigDecimal totalCodigo) {
		this.totalCodigo = totalCodigo;
	}

	
	
}
