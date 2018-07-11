package fr.afcepf.ai103.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.afcepf.ai103.data.Client;

@ManagedBean
@SessionScoped
public class ClientBean {
    private Long numClient;
    private String password;
    
    private String message;
    
    private Client client; //infos "client" à récupérer
    
    public String verifLogin() {
    	String suite=null; /* si suite reste à null on reste sur même page */
    	//simuler verification du mot de passe:
    	if(password!=null && password.equals("pwd" + numClient)) {
    		//mot de passe considéré comme ok si "pwd" + numClient (ex: "pwd1" )
    		//on demande à naviguer vers la page client
    		suite = "client"; //.jsf (.jsp ou .xhtml)
    	}else {
    		message = "invalid password"; 
    	}
    	return suite;
    }
}
