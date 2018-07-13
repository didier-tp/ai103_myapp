//import.sql est un script SQL automatiquement déclenché par hibernate 
//au démarrage de appli (ou test) en mode hibernate.hbm2ddl.auto=create  

INSERT INTO Client(numClient,prenom,nom,email,adresse,telephone,password) VALUES (1,'jean','Bon','jean.bon@gmail.com','1 rue elle 75000 Paris','0102030405' , 'pwd1')

INSERT INTO Client(numClient,prenom,nom,email,adresse,telephone,password) VALUES (2,'axelle','Aire','axelle.aire@gmail.com','1 rue lionceau 69000 Lyon','0504030201' , 'pwd2')