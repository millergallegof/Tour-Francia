package co.com.sofka.usecase.team.associatecyclistteam;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.model.cyclist.gateways.CyclistRepository;
import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AssociateCyclistTeamUseCaseTest {
    @Mock
    AssociateCyclistTeamUseCase associateCyclistTeamUseCase;

    @Test
    public void associateCyclist() {
        Team team = new Team("1", "Escarabajos", "ABC", "colombia", null);
        Cyclist cyclist = new Cyclist("2", "Esteban", 125, null, "colombia");
        Set<Cyclist> cyclists = Set.of(cyclist);
        Team teamNew = new Team("1", "Escarabajos", "ABC", "colombia", cyclists);

        when(associateCyclistTeamUseCase.associateCyclistTeam(team.getCodeTeam(), cyclist.getIdCyclist())).thenReturn(Mono.just(teamNew));

        StepVerifier.create(associateCyclistTeamUseCase.associateCyclistTeam(team.getCodeTeam(), cyclist.getIdCyclist()))
                .expectNext(teamNew)
                .expectComplete()
                .verify();
    }
}