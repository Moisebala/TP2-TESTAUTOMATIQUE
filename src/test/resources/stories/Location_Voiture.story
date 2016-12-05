Meta:

Narrative:
As a user
I want to rent and return a car
So that I can see the status change



Scenario:Louer une voiture
Given Un client enregistre avec un permis : AM002310
Given Une voiture enregistre avec le matricule : 20162004
When Le client AM002310  loue la voiture 20162004
Then L'etat de la voiture 20162004 devrais etre : Louer


Scenario: Retour de voiture
Given Un client enregistre avec un permis : AM002310
Given Une voiture enregistre avec le matricule : 20162004
When Le client AM002310 retourne la voiture 20162004
Then La voiture 20162004 devrais avoir l'etat : Disponible

Scenario: Afficher client
Given Une voiture enregistre avec le matricule : 20162004
When Je cherche la voiture 20162004
Then Je devrais avoir les detailles de la voiture : <Matricule> <Marque> <Model> <Type> <Year> <Price> <Etat>
Examples:
        Matricule |Marque  |Model   |Type   |Year  |Price  |Etat
        20162004  |Honda   |Accord  |SEDAN  |2016  |120    |Disponible


