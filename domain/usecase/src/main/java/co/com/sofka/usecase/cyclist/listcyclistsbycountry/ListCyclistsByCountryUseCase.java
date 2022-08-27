package co.com.sofka.usecase.cyclist.listcyclistsbycountry;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.util.Objects;

@RequiredArgsConstructor
public class ListCyclistsByCountryUseCase {
    private final CyclistRepository cyclistRepository;

    public Flux<Cyclist> searchCyclistsByCountry(String country) {
        return cyclistRepository.findAll()
                .filter(cyclist -> Objects.nonNull(cyclist.getCountryCyclist()))
                .filter(cyclist -> cyclist.getCountryCyclist().toLowerCase().equals(country.toLowerCase()));
    }
}
