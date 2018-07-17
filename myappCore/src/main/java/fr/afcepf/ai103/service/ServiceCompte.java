package fr.afcepf.ai103.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import fr.afcepf.ai103.dao.IDaoCompte;
import fr.afcepf.ai103.data.Compte;
import fr.afcepf.ai103.data.Operation;
@Stateless
@Local
//avec transactions automatiques sur toutes les méthodes dont transferer()
public class ServiceCompte {
	 @EJB
	 private IDaoCompte daoCompte;

	 
     public void transferer(double montant,long numCptDeb,long numCptCred) {
    	 Compte cptDeb = daoCompte.rechercherCompteParNumero(numCptDeb);
    	 cptDeb.setSolde(cptDeb.getSolde() - montant);
    	 Compte cptCred = daoCompte.rechercherCompteParNumero(numCptCred);
    	 cptCred.setSolde(cptCred.getSolde() + montant);
     }
	
     public List<Compte> comptesDuClient(Long numClient){
    	 List<Compte> listeComptes = new ArrayList<Compte>();
    	 //temporairement en attendant le lien compte-client :
    	 listeComptes.add(daoCompte.rechercherCompteParNumero(1L));
    	 listeComptes.add(daoCompte.rechercherCompteParNumero(2L));
    	 return listeComptes;
     }
     
     public List<Operation> operationsDuCompte(Long numCompte){
    	 Compte cpt = daoCompte.rechercherCompteParNumero(numCompte);
    	 cpt.getDernieresOperations().size(); //temporaire pour eviter lazy exception
    	 return cpt.getDernieresOperations();
     }
     
     
}
