Simulates competition and cooperation strategies in simple repetitive game theory setups:
* Prisoner's Dilemma: Only one strategy
* Rock / Paper / Scissors: Various strategies, also tailor-made counter-strategies *("killer")* by [phoyh](https://github.com/phoyh) and [M1ngXU](https://github.com/m1ngxu)

The strategies can participate in
* Matches: predefined number of repetitions,
    * `PlayMatch`: between strategies
    * `PlayHumanMatch`: between human and randomly chosen strategy (not visible to the hum)
* Tournaments: including various strategies as participants and global standings,
    * `PlayTournament`
* Populations: reproduction is linked to strategy success.
    * `SimulatePopulation`
