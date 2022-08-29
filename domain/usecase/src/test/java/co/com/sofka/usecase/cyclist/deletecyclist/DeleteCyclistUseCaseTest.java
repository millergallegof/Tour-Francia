package co.com.sofka.usecase.cyclist.deletecyclist;

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
class DeleteCyclistUseCaseTest {

    @InjectMocks
    DeleteCyclistUseCase deleteCyclistUseCase;

    @Mock
    CyclistRepository cyclistRepository;

    @Test
    public void deleteCyclist() {
        Cyclist cyclist = new Cyclist("1", "Miller", 124, null, "colombia");

        when(cyclistRepository.deleteById(Mockito.any(String.class))).thenReturn(Mono.empty());

        StepVerifier.create(deleteCyclistUseCase.deleteCyclist("1"))
                .expectNext()
                .expectComplete()
                .verify();
    }

}