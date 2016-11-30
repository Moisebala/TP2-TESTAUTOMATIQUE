Meta:

Narrative:
As a user
I want to display my existing customer
So that I can see all my customer display

Scenario: Je veux afficher les clients existant
Given "Paul" est un client enregistré
And "Jean" est un client enregistré
When j'affiche la liste des clients
Then "Paul" est dans la liste affichée
And "Jean" est dans la liste affichée


