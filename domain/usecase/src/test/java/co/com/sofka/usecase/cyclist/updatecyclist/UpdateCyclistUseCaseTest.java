package co.com.sofka.usecase.cyclist.updatecyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateCyclistUseCaseTest {
    @InjectMocks
    UpdateCyclistUseCase updateCyclistUseCase;

    @Mock
    CyclistRepository cyclistRepository;

    @Test
    public void updateCyclist() {
        Cyclist cyclist = new Cyclist("1", "Miller", 124, null, "colombia");
        Cyclist cyclistNew = new Cyclist("1", "Esteban", 124, "ABC", "colombia");

        when(cyclistRepository.save(Mockito.any(Cyclist.class))).thenReturn(Mono.just(cyclistNew));

        StepVerifier.create(updateCyclistUseCase.updateCyclist(cyclist.getIdCyclist(), cyclistNew))
                .expectNext(cyclistNew)
                .expectComplete()
                .verify();
    }

}