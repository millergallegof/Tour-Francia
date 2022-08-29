package co.com.sofka.usecase.team.deleteteam;

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
class DeleteTeamUseCaseTest {
    @InjectMocks
    DeleteTeamUseCase deleteTeamUseCase;

    @Mock
    TeamRepository teamRepository;

    @Test
    public void deleteTeam() {
        Team team1 = new Team("1", "Escarabajos", "ABC", "colombia", null);

        when(teamRepository.deleteById(Mockito.anyString())).thenReturn(Mono.empty());

        StepVerifier.create(deleteTeamUseCase.deleteTeam(team1.getIdTeam()))
                .expectNext()
                .expectComplete()
                .verify();
    }


}