package co.com.sofka.model.cyclist.gateways;

import co.com.sofka.model.cyclist.Cyclist;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CyclistRepository {
    Mono<Cyclist> save(Cyclist cyclist);
    Flux<Cyclist> findAll();
    Mono<Void> deleteById(String id);
    Mono<Cyclist> findById(String id);
}
