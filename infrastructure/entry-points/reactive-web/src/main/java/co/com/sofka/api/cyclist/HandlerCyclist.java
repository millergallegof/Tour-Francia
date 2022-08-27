package co.com.sofka.api.cyclist;

import co.com.sofka.model.cyclist.Cyclist;
import co.com.sofka.usecase.cyclist.createcyclist.CreateCyclistUseCase;
import co.com.sofka.usecase.cyclist.deletecyclist.DeleteCyclistUseCase;
import co.com.sofka.usecase.cyclist.findcyclist.FindCyclistUseCase;
import co.com.sofka.usecase.cyclist.listcyclists.ListCyclistsUseCase;
import co.com.sofka.usecase.cyclist.listcyclistsbycodeteam.ListCyclistsByCodeTeamUseCase;
import co.com.sofka.usecase.cyclist.listcyclistsbycountry.ListCyclistsByCountryUseCase;
import co.com.sofka.usecase.cyclist.updatecyclist.UpdateCyclistUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class HandlerCyclist {
    private final CreateCyclistUseCase createCyclistUseCase;
    private final DeleteCyclistUseCase deleteCyclistUseCase;
    private final FindCyclistUseCase findCyclistUseCase;
    private final ListCyclistsUseCase listCyclistsUseCase;
    private final ListCyclistsByCodeTeamUseCase listCyclistsByCodeTeamUseCase;
    private final ListCyclistsByCountryUseCase listCyclistsByCountryUseCase;
    private final UpdateCyclistUseCase updateCyclistUseCase;

    public Mono<ServerResponse> createCyclistPOSTUseCase(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Cyclist.class)
                .flatMap(cyclist -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(createCyclistUseCase.createCyclist(cyclist), Cyclist.class));
    }

    public Mono<ServerResponse> deleteCyclistDELETEUseCase(ServerRequest serverRequest) {
        var idCyclist = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(deleteCyclistUseCase.deleteCyclist(idCyclist), Cyclist.class);
    }

    public Mono<ServerResponse> findCyclistGETUseCase(ServerRequest serverRequest) {
        var idCyclist = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(findCyclistUseCase.findCyclist(idCyclist), Cyclist.class);
    }

    public Mono<ServerResponse> findCyclistsGETUseCase(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listCyclistsUseCase.listCyclists(), Cyclist.class);
    }

    public Mono<ServerResponse> listCyclistCodeTeamGETUseCase(ServerRequest serverRequest) {
        var codeTeam = serverRequest.pathVariable("codeTeam");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listCyclistsByCodeTeamUseCase.listCyclistsByTeam(codeTeam), Cyclist.class);
    }

    public Mono<ServerResponse> listCyclistCountryGETUseCase(ServerRequest serverRequest) {
        var country = serverRequest.pathVariable("country");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(listCyclistsByCountryUseCase.searchCyclistsByCountry(country), Cyclist.class);
    }

    public Mono<ServerResponse> updateCyclistPUTUseCase(ServerRequest serverRequest) {
        var id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Cyclist.class)
                .flatMap(cyclist -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(updateCyclistUseCase.updateCyclist(id, cyclist), Cyclist.class))
                ;
    }
}
