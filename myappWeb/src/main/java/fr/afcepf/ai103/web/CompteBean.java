package fr.afcepf.ai103.web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai103.data.Compte;
import fr.afcepf.ai103.service.ServiceCompte;

@ManagedBean
@SessionScoped
public class CompteBean {
	
	private Long numClient = 1L; //sera mélioré plus tard
	
	private ServiceCompte serviceCompte = new ServiceCompte();
	
	private List<Compte> comptes ; //à afficher sous forme de tableau (h:dataTable)
	
	//constructeur par défaut:
	public CompteBean() {
		comptes = serviceCompte.comptesDuClient(numClient);
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public Long getNumClient() {
		return numClient;
	}

	public void setNumClient(Long numClient) {
		this.numClient = numClient;
	}
	
	

}
