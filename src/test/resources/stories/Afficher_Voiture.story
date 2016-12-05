Meta:

Narrative:
As a user
I want to perform an action
So that I can achieve a business goal

Scenario: scenario description
Given Une voiture enregistre avec le matricule : 20162004
When Je cherche la voiture
Then Je devrais avoir les detailles de la voiture : <Matricule> <Marque> <Model> <Type> <Year> <Price> <Etat>
Examples:
        Matricule |Marque  |Model   |Type   |Year  |Price  |Etat
        20162004  |Honda   |Accord  |SEDAN  |2016  |120    |Disponible