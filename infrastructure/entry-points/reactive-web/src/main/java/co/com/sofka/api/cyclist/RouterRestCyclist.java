package co.com.sofka.api.cyclist;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterRestCyclist {
@Bean
public RouterFunction<ServerResponse> routerFunctionCyclist(HandlerCyclist handlerCyclist) {
    return route(POST("/api/cyclist/create"), handlerCyclist::createCyclistPOSTUseCase)
            .andRoute(DELETE("/api/cyclist/{id}"), handlerCyclist::deleteCyclistDELETEUseCase)
            .andRoute(GET("/api/cyclist/{id}"), handlerCyclist::findCyclistGETUseCase)
            .andRoute(GET("/api/cyclist"), handlerCyclist::findCyclistsGETUseCase)
            .andRoute(GET("/api/cyclist/code-team/{codeTeam}"), handlerCyclist::listCyclistCodeTeamGETUseCase)
            .andRoute(GET("/api/cyclist/country/{country}"), handlerCyclist::listCyclistCountryGETUseCase)
            .andRoute(PUT("/api/cyclist/{id}"), handlerCyclist::updateCyclistPUTUseCase);
    }
}
