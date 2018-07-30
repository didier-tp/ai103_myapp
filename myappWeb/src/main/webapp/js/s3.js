function initComportementJs(){
	console.log("initComportementJs");
	var btnEnregistrer =  document.querySelector("#btnEnregistrer");
	btnEnregistrer.addEventListener("click",enregistrer,false);
}

function enregistrer(){
		  var nom =  document.querySelector("#nom").value; 
		  var prenom =   document.querySelector("#prenom").value;  
		  
		  var client = {
			numClient : null,
			date : "2018-07-27",
			nom : nom ,
			prenom : prenom 
		  }; //expression "objet lit(t)eral javascript" (très proche du format JSON) .
		  
		  //on peut dynamiquement ajouter des propriétés supplémentaires sur l'objet client :
		  client.telephone = document.querySelector("#telephone").value;
		  client.adresse = document.querySelector("#adresse").value;
		  client.email = document.querySelector("#email").value;
	      var clientAsJsonString = JSON.stringify(client);
          document.querySelector("#spanRes").innerHTML = clientAsJsonString;		  
}