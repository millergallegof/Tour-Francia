package co.com.sofka.usecase.team.consultteams;

import co.com.sofka.model.team.Team;
import co.com.sofka.model.team.gateways.TeamRepository;
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
class ConsultTeamsUseCaseTest {
    @InjectMocks
    ConsultTeamsUseCase consultTeamsUseCase;

    @Mock
    TeamRepository teamRepository;

    @Test
    public void consultTeams() {
        Team team1 = new Team("1", "Escarabajos", "ABC", "colombia", null);
        Team team2 = new Team("2", "Toros", "AZK", "colombia", null);
        List<Team> teams = List.of(team1, team2);

        when(teamRepository.findAll()).thenReturn(Flux.fromIterable(teams));

        StepVerifier.create(consultTeamsUseCase.listTeams())
                .expectNext(team1)
                .expectNext(team2)
                .expectComplete()
                .verify();
    }

}