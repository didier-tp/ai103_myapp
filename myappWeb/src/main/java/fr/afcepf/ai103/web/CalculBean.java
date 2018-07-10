package fr.afcepf.ai103.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean //de JSF2 , nom logique par défaut = "calculBean" 
             // = nom de la classe avec minuscule au début
@RequestScoped
public class CalculBean {
    private Double x; //à saisir
    private Double res; //à afficher
    
    public String calculerRacine() {
    	this.res = Math.sqrt(this.x);
    	return null; //rester sur la même page pour afficher le resultat
    }

    //+get/set
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getRes() {
		return res;
	}
	public void setRes(Double res) {
		this.res = res;
	}
    
}
