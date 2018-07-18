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
     /*
     VARIANTE 1 exploitant le lien "@OneToMany"
     
     //lorsque cette méthode sera exécutée dans jboss, il faudra que jboss initialise un 
     //debut de transaction. Et pour ça le "entityManager" doit quelquefois être créé au même moment
     public List<Operation> operationsDuCompte(Long numCompte){
    	 Compte cpt = daoCompte.rechercherCompteParNumero(numCompte);
    	 //for(Operation op : cpt.getDernieresOperations()) { }
    	 int n = cpt.getDernieresOperations().size(); //temporaire pour eviter lazy exception
    	 //Soit via une boucle for , soit via un appel à .size() on provoque volontairement
    	 //une remontée immédiate des valeurs de la tables "operation" vers des objets
    	 //de la liste dernieresOperations avant qu'il ne soit trop tard pour le faire
    	 System.out.println("le compte " + numCompte + " a " + n + " operations");
    	 return cpt.getDernieresOperations();
     //à la fin de l'exécution de cette méthode jboss déclenche automatiquement commit 
     // tout va bien ou rollback si exception
     // et quelquefois le entityManager est fermé ici (si avait été crée dans le haut de cette méthode)
     }
     */
     
     // VARIANTE 2 s'appyant sur une requête spécifique du DAO:
     public List<Operation> operationsDuCompte(Long numCompte){
        return daoCompte.dernieresOperations(numCompte);
     }
     
     
     
     
}
