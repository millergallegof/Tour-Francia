package co.com.sofka.usecase.team.associatecyclistteam;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
public class AssociateCyclistTeamUseCase {

    private final TeamRepository teamRepository;
    private final CyclistRepository cyclistRepository;
    private Cyclist cyclist;

    public Mono<Team> associateCyclistTeam(String codeTeam,String idCyclist){
        return teamRepository.findAll()
                .filter(team -> team.getCodeTeam().equals(codeTeam)).next()
                .publishOn(Schedulers.boundedElastic())
                .map(team -> {
                    if (team.getCyclists().size() >= 8)
                        throw new IllegalArgumentException("El equipo esta lleno");
                    cyclistRepository.findById(idCyclist)
                                    .subscribe(cyclist1 -> {
                                        cyclist1.setIdCyclist(idCyclist);
                                        cyclist1.setCodeTeam(codeTeam);
                                        this.cyclist = cyclist1;
                                        cyclistRepository.save(cyclist1).subscribe();
                                    });
                    if (this.cyclist == null) {
                        throw new IllegalArgumentException("error");
                    }
                    team.getCyclists().add(this.cyclist);
                    return team;
                }).retry(2)
                .flatMap(teamRepository::save);
    }
}
