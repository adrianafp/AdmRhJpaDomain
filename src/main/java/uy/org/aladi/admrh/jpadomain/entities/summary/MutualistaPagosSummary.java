package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.math.BigDecimal;

public class MutualistaPagosSummary implements Serializable{

	private static final long serialVersionUID = 3100952922055159740L;
	private String mutualista;
	private BigDecimal pagoAladi;
	private BigDecimal pagoDiferencia;
	private BigDecimal pagoFuncionario;
	
	public MutualistaPagosSummary(){
		
	}
	
	public MutualistaPagosSummary(String mutualista, BigDecimal pagoAladi, BigDecimal pagoDiferencia, BigDecimal pagoFunc){
		this.mutualista = mutualista;
		this.setPagoAladi(pagoAladi);
		this.setPagoDiferencia(pagoDiferencia);
		this.setPagoFuncionario(pagoFunc);
	}
	
	public String getMutualista() {
		return mutualista;
	}
	public void setMutualista(String mutualista) {
		this.mutualista = mutualista;
	}

	public BigDecimal getPagoAladi() {
		return pagoAladi;
	}

	public void setPagoAladi(BigDecimal pagoAladi) {
		this.pagoAladi = pagoAladi;
	}

	public BigDecimal getPagoFuncionario() {
		return pagoFuncionario;
	}

	public void setPagoFuncionario(BigDecimal pagoFuncionario) {
		this.pagoFuncionario = pagoFuncionario;
	}

	public BigDecimal getPagoDiferencia() {
		return pagoDiferencia;
	}

	public void setPagoDiferencia(BigDecimal pagoDiferencia) {
		this.pagoDiferencia = pagoDiferencia;
	}
	
}
