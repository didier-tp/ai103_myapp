package fr.afcepf.ai103.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai103.data.Client;
import fr.afcepf.ai103.service.ServiceClient;

@ManagedBean
@SessionScoped
public class ClientBean {
    private Long numClient; //à saisir
    private String password; //à saisir
    
    private String message; //à afficher
    
    private Client client; //infos "client" à récupérer
    
    private ServiceClient serviceClient = new ServiceClient();
    
    public String verifLogin() {
    	String suite=null; /* si suite reste à null on reste sur même page */
    	//simuler verification du mot de passe:
    	if(password!=null && password.equals("pwd" + numClient)) {
    		//mot de passe considéré comme ok si "pwd" + numClient (ex: "pwd1" )
    		//on demande à naviguer vers la page client
    		suite = "client"; //.jsf (.jsp ou .xhtml)
    		this.client  =  serviceClient.rechercherInfosClient(numClient);
    	}else {
    		message = "invalid password"; 
    	}
    	return suite;
    }
}
