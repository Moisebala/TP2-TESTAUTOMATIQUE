Meta:

Narrative:
As a user
I want to rent and return a car
So that I can see the status change



Scenario:Louer une voiture
Given Un client B enregistre avec un permis : AM002310
Given Une voiture A1 enregistre avec le matricule : 20162004
When Le client B  loue la voiture A1
Then L'etat de la voiture A1 devrais etre : Louer


Scenario: Retour de voiture
Given Un client B enregistre avec un permis : AM002310
Given Une voiture A1 enregistre avec le matricule : 20162004
When Le client B retourne la voiture A1
Then La voiture A1 devrais avoir l'etat : Disponible

Scenario: Afficher une voiture
Given Une voiture A1 enregistre avec le matricule : 20162004
When Je cherche la voiture A1
Then Je devrais avoir les detailles de la voiture A1 : <Matricule> <Marque> <Model> <Type> <Year> <Price> <Etat>
Examples:
        Matricule |Marque  |Model   |Type   |Year  |Price  |Etat
        20162004  |Honda   |Accord  |SEDAN  |2016  |120    |Disponible


