package co.com.sofka.api.team;

import co.com.sofka.model.team.CodeCyclist;
import co.com.sofka.model.team.Team;
import co.com.sofka.usecase.team.associatecyclistteam.AssociateCyclistTeamUseCase;
import co.com.sofka.usecase.team.consultteam.ConsultTeamUseCase;
import co.com.sofka.usecase.team.consultteams.ConsultTeamsUseCase;
import co.com.sofka.usecase.team.consultteamsbycountry.ConsultTeamsByCountryUseCase;
import co.com.sofka.usecase.team.createteam.CreateTeamUseCase;
import co.com.sofka.usecase.team.deleteteam.DeleteTeamUseCase;
import co.com.sofka.usecase.team.updateteam.UpdateTeamUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerTeam {
    private final CreateTeamUseCase createTeamUseCase;
    private final ConsultTeamsByCountryUseCase consultTeamsByCountryUseCase;
    private final DeleteTeamUseCase deleteTeamUseCase;
    private final ConsultTeamUseCase consultTeamUseCase;
    private final ConsultTeamsUseCase consultTeamsUseCase;
    private final UpdateTeamUseCase updateTeamUseCase;
    private final AssociateCyclistTeamUseCase associateCyclistTeamUseCase;

    public Mono<ServerResponse> createTeamPOSTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Team.class)
                .flatMap(team -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(createTeamUseCase.createTeam(team), Team.class));
    }

    public Mono<ServerResponse> listTeamsByCountryGETUseCase(ServerRequest serverRequest) {
        var country = serverRequest.pathVariable("country");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(consultTeamsByCountryUseCase.consultTeamByCountry(country), Team.class);
    }

    public Mono<ServerResponse> deleteTeamGETUseCase(ServerRequest serverRequest) {
        var idTeam = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deleteTeamUseCase.deleteTeam(idTeam), Team.class);
    }

    public Mono<ServerResponse> consultTeamGETUseCase(ServerRequest serverRequest) {
        var idTeam = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(consultTeamUseCase.findTeam(idTeam), Team.class);
    }

    public Mono<ServerResponse> consultTeamsGETUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(consultTeamsUseCase.listTeams(), Team.class);
    }

    public Mono<ServerResponse> updateTeamGETUseCase(ServerRequest serverRequest) {
        var idTeam = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Team.class)
                .flatMap(team -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(updateTeamUseCase.updateTeam(idTeam, team), Team.class));
    }

    public Mono<ServerResponse> associateCyclistPOSTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(CodeCyclist.class)
                .flatMap(data -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(associateCyclistTeamUseCase.associateCyclistTeam(data.getCodeTeam(), data.getIdCyclist()), Team.class));
    }
}
