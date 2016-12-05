Meta:

Narrative:
As a user
I want to display an existing customer
So that I can see  the customer display

Scenario: Je veux chercher un client existant
Given On a une base de recherche de client avec un permis P1
When Je cherche le client A1 avec sont permis : AM002300
Then je devrais avoir les detailles de client A1: <Nom> <Prenom> <Numerotel> <Adresse>
Examples:
          | Nom     | Prenom  | Numerotel  | Adresse               |
          | Armelle | Tenekeu | 5147718969 | 1345 rue saint charles|

