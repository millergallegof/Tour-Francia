package co.com.sofka.usecase.team.createteam;

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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateTeamUseCaseTest {
    @InjectMocks
    CreateTeamUseCase createTeamUseCase;

    @Mock
    TeamRepository teamRepository;

    @Test
    public void createTeam() {
        Team team1 = new Team("1", "Escarabajos", "ABC", "colombia", null);

        when(teamRepository.save(Mockito.any(Team.class))).thenReturn(Mono.just(team1));

        StepVerifier.create(createTeamUseCase.createTeam(team1))
                .expectNextMatches(team -> team.getNameTeam().equals("Escarabajos"))
                .expectComplete()
                .verify();
    }


}