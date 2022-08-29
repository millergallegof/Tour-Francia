package co.com.sofka.usecase.team.consultteam;

import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ConsultTeamUseCase {
    private final TeamRepository teamRepository;

    public Mono<Team> findTeam(String id) {
        return teamRepository.findById(id);
    }
}
