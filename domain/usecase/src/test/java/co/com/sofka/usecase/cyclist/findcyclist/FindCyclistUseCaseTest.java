package co.com.sofka.usecase.cyclist.findcyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindCyclistUseCaseTest {

    @InjectMocks
    FindCyclistUseCase findCyclistUseCase;

    @Mock
    CyclistRepository cyclistRepository;

    @Test
    public void findCyclist() {
        Cyclist cyclist = new Cyclist("1", "Miller", 124, null, "colombia");

        when(cyclistRepository.findById("1")).thenReturn(Mono.just(cyclist));

        StepVerifier.create(findCyclistUseCase.findCyclist("1"))
                .expectNext(cyclist)
                .expectComplete()
                .verify();
    }

}