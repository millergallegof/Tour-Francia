package co.com.sofka.usecase.cyclist.listcyclists;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListCyclistsUseCase {
    private final CyclistRepository cyclistRepository;

    public Flux<Cyclist> listCyclists() {
        return cyclistRepository.findAll();
    }
}
