Meta:

Narrative:
As a user
I want to return a car
So that I can change the car status to available

Scenario: Retour de voiture
Given Une voiture $A1 louee par un $client
When "client" retourne la voiture $A1 avec son $Permit
Then l'etat de la voiture $A1 est a Disponible



