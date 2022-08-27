package co.com.sofka.usecase.team.createteam;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
public class CreateTeamUseCase {

    private final TeamRepository teamRepository;

    public Mono<Team> createTeam(Team team) throws IllegalArgumentException {
        if (team.getCodeTeam().length() != 3)
            throw new IllegalArgumentException("el codigo debe ser de 3 elementos Alfanumericos");
        if (team.getNameTeam() == null)
            throw new IllegalArgumentException("El nombre no puede ser null");
        if (team.getCodeTeam() == null)
            throw new IllegalArgumentException("El codigo de equipo no puede ser null");
        if (team.getCountryTeam() == null)
            throw new IllegalArgumentException("El pais de origen no puede ser null");
        if (team.getCyclists() == null) {
            Set<Cyclist> newCyclist = new HashSet<>();
            team.setCyclists(newCyclist);
        }

        return teamRepository.save(team);
    }
}
