Meta:

Narrative:
As a user
I want to return a car
So that I can change the car status to available

Scenario: Retour de voiture
Given la voiture A1 est louée à Paul
When Paul retourne la voiture A1
Then A1 est disponible