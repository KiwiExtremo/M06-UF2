package model;

import java.util.ArrayList;
import java.sql.Date;

public class Empleat {
	private Integer codiEmpleat;
	private String cognomEmpleat;
	private String oficiEmpleat;
	private Integer capEmpleat;
	private Date dataAltaEmpleat;
	private Double salariEmpleat;
	private Double comisioEmpleat;
	private Departament departamentEmpleat;
	
	public Empleat() {
		super();
	}

	public Empleat(Integer codiEmpleat, String cognomEmpleat, String oficiEmpleat, Integer capEmpleat, Date dataAltaEmpleat, Double salariEmpleat,
			Double comisioEmpleat, Departament departamentEmpleat) {
		super();
		this.codiEmpleat = codiEmpleat;
		this.cognomEmpleat = cognomEmpleat;
		this.oficiEmpleat = oficiEmpleat;
		this.capEmpleat = capEmpleat;
		this.dataAltaEmpleat = dataAltaEmpleat;
		this.salariEmpleat = salariEmpleat;
		this.comisioEmpleat = comisioEmpleat;
		this.departamentEmpleat = departamentEmpleat;
	}

	public Integer getCodiEmpleat() {
		return codiEmpleat;
	}

	public void setCodiEmpleat(Integer codiEmpleat) {
		this.codiEmpleat = codiEmpleat;
	}

	public String getCognomEmpleat() {
		return cognomEmpleat;
	}

	public void setCognomEmpleat(String cognomEmpleat) {
		this.cognomEmpleat = cognomEmpleat;
	}

	public String getOficiEmpleat() {
		return oficiEmpleat;
	}

	public void setOficiEmpleat(String oficiEmpleat) {
		this.oficiEmpleat = oficiEmpleat;
	}

	public Integer getCapEmpleat() {
		return capEmpleat;
	}

	public void setCapEmpleat(Integer capEmpleat) {
		this.capEmpleat = capEmpleat;
	}

	public Date getDataAltaEmpleat() {
		return dataAltaEmpleat;
	}

	public void setDataAltaEmpleat(Date dataAltaEmpleat) {
		this.dataAltaEmpleat = dataAltaEmpleat;
	}

	public Double getSalariEmpleat() {
		return salariEmpleat;
	}

	public void setSalariEmpleat(Double salariEmpleat) {
		this.salariEmpleat = salariEmpleat;
	}

	public Double getComisioEmpleat() {
		return comisioEmpleat;
	}

	public void setComisioEmpleat(Double comisioEmpleat) {
		this.comisioEmpleat = comisioEmpleat;
	}

	public Departament getDepartamentEmpleat() {
		return departamentEmpleat;
	}

	public void setDepartamentEmpleat(Departament departamentEmpleat) {
		this.departamentEmpleat = departamentEmpleat;
	}
	
	@Override
	public String toString() {
		String resultat = "";
		
		if (departamentEmpleat.getLlistaEmpleats().isEmpty()) {
			resultat = "\tEmpleat " + codiEmpleat
				+ ": Cognom: " + cognomEmpleat 
				+ ", Ofici: " + oficiEmpleat 
				+ ", Cap: " + capEmpleat 
				+ ", Data d'alta: " 
				+ dataAltaEmpleat + ", Salari: " 
				+ salariEmpleat + ", Comisió: " 
				+ comisioEmpleat + ", Departament: " 
				+ departamentEmpleat.getNomDepartament() 
				+ "\n";
			
		} else {
			resultat = "\tEmpleat " + codiEmpleat
					+ ": Cognom: " + cognomEmpleat
					+ ", Ofici: " + oficiEmpleat 
					+ ", Cap: " + capEmpleat 
					+ ", Data d'alta: " + dataAltaEmpleat 
					+ ", Salari: " + salariEmpleat 
					+ ", Comisió: " + comisioEmpleat 
					+ "\n";
		}
		
		return resultat;
	}
}
