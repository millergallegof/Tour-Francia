package co.com.sofka.usecase.team.updateteam;

import co.com.sofka.model.team.Team;
import co.com.sofka.usecase.team.createteam.CreateTeamUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateTeamUseCase {
    private final CreateTeamUseCase createTeamUseCase;

    public Mono<Team> updateTeam(String id, Team team) {
        team.setIdTeam(id);
        return createTeamUseCase.createTeam(team);
    }
}
