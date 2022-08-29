package co.com.sofka.usecase.team.consultteamsbycountry;

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
class ConsultTeamsByCountryUseCaseTest {
    @InjectMocks
    ConsultTeamsByCountryUseCase consultTeamsByCountryUseCase;

    @Mock
    TeamRepository teamRepository;

    @Test
    public void teamsByCountry() {
        Team team1 = new Team("1", "Escarabajos", "ABC", "colombia", null);
        Team team2 = new Team("2", "Toros", "AZK", "colombia", null);
        List<Team> teams = List.of(team1, team2);

        when(teamRepository.findAll()).thenReturn(Flux.fromIterable(teams));

        StepVerifier.create(consultTeamsByCountryUseCase.consultTeamByCountry("colombia"))
                .expectNext(team1)
                .expectNext(team2)
                .expectComplete()
                .verify();
    }


}