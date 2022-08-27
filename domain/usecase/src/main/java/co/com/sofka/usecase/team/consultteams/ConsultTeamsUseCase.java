package co.com.sofka.usecase.team.consultteams;

import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ConsultTeamsUseCase {
    private final TeamRepository teamRepository;

    public Flux<Team> listTeams() {
        return teamRepository.findAll();
    }
}
