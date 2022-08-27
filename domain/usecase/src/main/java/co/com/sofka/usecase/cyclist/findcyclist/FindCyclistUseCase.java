package co.com.sofka.usecase.cyclist.findcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FindCyclistUseCase {
    private final CyclistRepository cyclistRepository;

    public Mono<Cyclist> findCyclist(String id) {
        return cyclistRepository.findById(id);
    }
}
