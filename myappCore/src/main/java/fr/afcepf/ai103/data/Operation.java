package fr.afcepf.ai103.data;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Operation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numero;
	
	@Temporal(TemporalType.DATE) //seule la date est significative pas l'heure
    private Date date;
	
    private Double montant;
    
    private String label;
    
   
	public Operation() {
		super();
	}
	
	public Operation(Long numero, Date date, Double montant, String label) {
		super();
		this.numero = numero;
		this.date = date;
		this.montant = montant;
		this.label = label;
	}


	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
    
    
}
