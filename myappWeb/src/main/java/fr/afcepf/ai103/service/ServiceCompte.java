package fr.afcepf.ai103.service;

import java.util.ArrayList;
import java.util.List;

import fr.afcepf.ai103.data.Compte;

public class ServiceCompte {
     public List<Compte> comptesDuClient(Long numClient){
    	 List<Compte> listeComptes = new ArrayList<Compte>();
    	 //simulation de valeurs récupérées en base:
    	 Compte cpt1 = new Compte();
    	 cpt1.setNumero(123456L);
    	 cpt1.setLabel("compte courant");
    	 cpt1.setSolde(500.0);
    	 listeComptes.add(cpt1);
    	 
    	 Compte cpt2 = new Compte();
    	 cpt2.setNumero(97855245L);
    	 cpt2.setLabel("compte épargne (livret A)");
    	 cpt2.setSolde(400.0);
    	 listeComptes.add(cpt2);
    	 
    	 return listeComptes;
     }
     
     //...
}
