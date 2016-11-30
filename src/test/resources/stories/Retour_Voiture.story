Meta:

Narrative:
As a user
I want to return a car
So that I can change the car status to available

Scenario: Retour de voiture
Given Voiture "A1" est a l'etat louer
Given "Paul" est locataire de voiture "A1"
When J'entre le numero de permis de "Paul"
Then Voite "A1" est l'etat disponible



