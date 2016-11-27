Meta:

Narrative:
As a user
I want to rent a car
So that I see the car as rent to a client

Scenario: Louer une voiture a un nouveau client
Given la voiture A1 est disponible
And Paul est un nouveau client
When Paul sélectionne la voiture A1
Then Paul est un client actif
And la voiture A1 est louée par Paul

Scenario: Louer une voiture a un ancien client
Given la voiture A1 est disponible
And Paul est un ancien client
When Paul sélectionne la voiture A1
Then la voiture A1 est louée par Paul

Scenario: Louer une voiture deja louees a un client
Given la voiture A1 est déjà louée à Jean
When Paul sélectionne la voiture A1
Then la voiture A1 est louée par Jean
