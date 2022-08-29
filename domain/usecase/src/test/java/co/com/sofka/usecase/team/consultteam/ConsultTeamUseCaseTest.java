package co.com.sofka.usecase.team.consultteam;

import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsultTeamUseCaseTest {
    @InjectMocks
    ConsultTeamUseCase consultTeamUseCase;

    @Mock
    TeamRepository teamRepository;

    @Test
    public void consultTeam() {
        Team team = new Team("1", "Escarabajos", "ABC", "colombia", null);

        when(teamRepository.findById(Mockito.any(String.class))).thenReturn(Mono.just(team));

        StepVerifier.create(consultTeamUseCase.findTeam(team.getIdTeam()))
                .expectNextMatches(team1 -> team1.getCountryTeam().equals("colombia"))
                .expectComplete()
                .verify();

    }

}