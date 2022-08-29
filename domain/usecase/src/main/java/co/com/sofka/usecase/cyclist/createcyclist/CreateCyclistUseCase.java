package co.com.sofka.usecase.cyclist.createcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.team.gateways.TeamRepository;
import co.com.sofka.usecase.team.associatecyclistteam.AssociateCyclistTeamUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateCyclistUseCase {
    private final CyclistRepository cyclistRepository;


    public Mono<Cyclist> createCyclist(Cyclist cyclist) {
        if (cyclist.getCompetitorNumber() > 999 && cyclist.getCompetitorNumber() >= 0)
            throw new IllegalArgumentException("el numero de competidor no puede ser de mas de 3 digitos");
        if (cyclist.getNameCyclist() == null)
            throw new IllegalArgumentException("El nombre es obligatorio");
        if (cyclist.getCountryCyclist() == null)
            throw new IllegalArgumentException("El pais es obligatorio");
        if (cyclist.getCodeTeam() != null)
            throw new IllegalArgumentException("El codigo de equipo no es necesario");

        return cyclistRepository.save(cyclist);
    }
}
