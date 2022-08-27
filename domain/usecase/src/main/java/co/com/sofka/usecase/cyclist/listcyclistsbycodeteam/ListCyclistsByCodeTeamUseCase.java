package co.com.sofka.usecase.cyclist.listcyclistsbycodeteam;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.Objects;

@RequiredArgsConstructor
public class ListCyclistsByCodeTeamUseCase {
    private final CyclistRepository cyclistRepository;

    public Flux<Cyclist> listCyclistsByTeam(String codeTeam) {
        return cyclistRepository.findAll()
                .filter(cyclist -> Objects.nonNull(cyclist.getCodeTeam()))
                .filter(cyclist -> cyclist.getCodeTeam().toLowerCase().equals(codeTeam.toLowerCase()));
    }
}
