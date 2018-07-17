package fr.afcepf.ai103.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compte {
	@Id //identifiant (primary key)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="numCompte")
	private Long numero;
	
	private String label;
	private Double solde;
	
	
	public Compte() {
		super();
	}
	
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public Double getSolde() {
		return solde;
	}
	public void setSolde(Double solde) {
		this.solde = solde;
	}

	
	
}
