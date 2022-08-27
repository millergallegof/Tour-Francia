package co.com.sofka.api.team;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRestTeam {
@Bean
public RouterFunction<ServerResponse> routerFunctionTeam(HandlerTeam handlerTeam) {
    return route(POST("/api/team/create"), handlerTeam::createTeamPOSTUseCase)
            .andRoute(GET("/api/team/country/{country}"), handlerTeam::listTeamsByCountryGETUseCase)
            .andRoute(DELETE("/api/team/{id}"), handlerTeam::deleteTeamGETUseCase)
            .andRoute(GET("/api/team/{id}"), handlerTeam::consultTeamGETUseCase)
            .andRoute(GET("/api/team"), handlerTeam::consultTeamsGETUseCase)
            .andRoute(PUT("/api/team/{id}"), handlerTeam::updateTeamGETUseCase)
            .andRoute(POST("/api/team/cyclist"), handlerTeam::associateCyclistPOSTUseCase);
    }
}
