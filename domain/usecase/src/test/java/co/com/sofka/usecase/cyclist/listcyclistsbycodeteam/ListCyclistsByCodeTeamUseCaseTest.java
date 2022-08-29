package co.com.sofka.usecase.cyclist.listcyclistsbycodeteam;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import co.com.sofka.usecase.team.associatecyclistteam.AssociateCyclistTeamUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ListCyclistsByCodeTeamUseCaseTest {

    @InjectMocks
    ListCyclistsByCodeTeamUseCase listCyclistsByCodeTeamUseCase;

    @Mock
    AssociateCyclistTeamUseCase associateCyclistTeamUseCase;

    @Mock
    CyclistRepository cyclistRepository;


    @Test
    public void listCyclistsByCode() {
        Cyclist cyclist1 = new Cyclist("1", "Miller", 124, "ABC", "colombia");
        Cyclist cyclist2 = new Cyclist("2", "Esteban", 125, null, "colombia");
        List<Cyclist> cyclists = List.of(cyclist1, cyclist2);

        when(cyclistRepository.findAll()).thenReturn(Flux.fromIterable(cyclists));

        StepVerifier.create(listCyclistsByCodeTeamUseCase.listCyclistsByTeam("ABC"))
                .expectNext(cyclist1)
                .expectComplete()
                .verify();

    }
}