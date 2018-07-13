package fr.afcepf.ai103.dao;

import java.util.List;

import javax.persistence.EntityManager;

import fr.afcepf.ai103.data.Client;

public class DaoClientJpa implements IDaoClient {
	
	private EntityManager entityManager;
	
	private void initEntityManagerSansEjb() {
		//...
	}
	
	public DaoClientJpa(){
		initEntityManagerSansEjb();
	}

	@Override
	public Client insererNouveauClient(Client c) {
		//en entrée  la partie c.numClient vaut null
		entityManager.persist(c);//INSERT INTO SQL
		                         //avec auto_increment
		return c; //en retour c.numClient ne sera plus null
	}

	@Override
	public Client rechercherClientParNumero(Long numero) {
		//SELECT FROM ... WHERE numero=?
		return entityManager.find(Client.class, numero);
	}

	@Override
	public List<Client> rechercherClients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mettreAjourClient(Client p) {
		entityManager.merge(p); //UDPATE SQL

	}

	@Override
	public void supprimerClient(Long numero) {
		// TODO Auto-generated method stub

	}

}
