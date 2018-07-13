package fr.afcepf.ai103.test;

import fr.afcepf.ai103.dao.DaoClientJpa;
import fr.afcepf.ai103.dao.IDaoClient;
import fr.afcepf.ai103.data.Client;

public class TestApp {

	public static void main(String[] args) {
		IDaoClient daoClient =  new DaoClientJpa();
		for(Client c :daoClient.rechercherClients()) {
			System.out.println(c.toString());
		}
		//...
		System.exit(0);//pour forcer l'arrêt (pour compenser entityManager.close() )
	}
}
