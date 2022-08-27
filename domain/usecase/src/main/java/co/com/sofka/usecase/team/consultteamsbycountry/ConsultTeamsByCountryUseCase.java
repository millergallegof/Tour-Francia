package co.com.sofka.usecase.team.consultteamsbycountry;

import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.Objects;

@RequiredArgsConstructor
public class ConsultTeamsByCountryUseCase {
    private final TeamRepository teamRepository;

    public Flux<Team> consultTeamByCountry(String country) {
        return teamRepository.findAll()
                .filter(team -> Objects.nonNull(team.getCountryTeam()))
                .filter(teamC -> teamC.getCountryTeam().equals(country));
    }
}
