package co.com.sofka.usecase.cyclist.listcyclists;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListCyclistsUseCaseTest {

    @InjectMocks
    ListCyclistsUseCase listCyclistsUseCase;

    @Mock
    CyclistRepository cyclistRepository;

    @Test
    public void listCyclists() {
        Cyclist cyclist1 = new Cyclist("1", "Miller", 124, null, "colombia");
        Cyclist cyclist2 = new Cyclist("2", "Esteban", 125, null, "colombia");

        when(cyclistRepository.findAll()).thenReturn(Flux.fromIterable(List.of(cyclist1, cyclist2)));

        StepVerifier.create(listCyclistsUseCase.listCyclists())
                .expectNext(cyclist1)
                .expectNext(cyclist2)
                .expectComplete()
                .verify();
    }

}