package uy.org.aladi.admrh.jpadomain.entities.summary;

import java.io.Serializable;
import java.util.List;

public class AdicionesDescuentosSummary implements Serializable {

	private static final long serialVersionUID = -168870798554611150L;
	private String sumaResta;
	private List<FuncAdicDescSummary> lstFunc;
	
	public AdicionesDescuentosSummary(){
		
	}
	
	public AdicionesDescuentosSummary(String sumaResta, List<FuncAdicDescSummary> lstFunc){
		this.setSumaResta(sumaResta);
		this.setLstFunc(lstFunc);
	}

	public String getSumaResta() {
		return sumaResta;
	}

	public void setSumaResta(String sumaResta) {
		this.sumaResta = sumaResta;
	}

	public List<FuncAdicDescSummary> getLstFunc() {
		return lstFunc;
	}

	public void setLstFunc(List<FuncAdicDescSummary> lstFunc) {
		this.lstFunc = lstFunc;
	}
		
}
