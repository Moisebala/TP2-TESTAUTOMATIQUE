Meta:

Narrative:
As a user
I want to display car
So that I can see available and rent cars

Scenario: Je veux afficher les voitures disponibles
Given il y a 2 voitures disponibles
And la voiture "A1" est disponible
And la voiture "A2" est disponible
When je veux afficher la liste des voitures disponibles
Then la voiture "A1" est indiquée comme étant disponible
And la voiture "A2" est indiquée comme étant disponible

Scenario: Je veux afficher toutes les voitures, louées ou non
Given la voiture "A1" est louée à Paul
And la voiture "A2" est disponible
When je demande l’affichage de la liste de toutes les voitures
Then la voiture "A1" est indiquée comme louee a Paul
And la voiture "A2"est indiquée comme étant disponible
