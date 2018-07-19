package fr.afcepf.ai103.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import fr.afcepf.ai103.data.Client;
import fr.afcepf.ai103.service.IServiceClient;

/*
 * classe java du WS REST lié au client
 */

@Path("client") //avant dernière partie de l'URL
@Produces("application/json") //pour convertir automatiquement réponse java en réponse json
public class ClientRest {
    
	@EJB //ou @Inject
	private IServiceClient serviceClient; 
	
	@Path("/{idClient}") //dernière partie de l'URL
	@GET // GET pour lecture , recherche unique par id/clef primaire
	//URL = http://localhost:8080/myappWeb/services/rest/client/1
	public Client rechercherClientQuiVaBien(@PathParam("idClient")Long numClient) {
		return serviceClient.rechercherInfosClient(numClient);
	}
	
	
	@Path("") //dernière partie de l'URL (éventuellement vide si rien de plus)
	@GET // GET pour lecture , recherche multiple via critère(s) de recherche
	//URL = http://localhost:8080/myappWeb/services/rest/client?nom=Therieur
	public List<Client> rechercherClients(@QueryParam("nom")String nom) {
		return serviceClient.rechercherListeClientsParNom(nom);
	}
	
}
