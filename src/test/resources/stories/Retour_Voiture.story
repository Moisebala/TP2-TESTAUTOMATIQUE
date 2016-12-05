Meta:

Narrative:
As a user
I want to return a car
So that I can change the car status to available

Scenario: Retour de voiture
Given La Voiture 20162011 est a l'etat louer
When Je retourne la voiture 20162011
Then La voiture devrais avoir l'etat : Disponible




