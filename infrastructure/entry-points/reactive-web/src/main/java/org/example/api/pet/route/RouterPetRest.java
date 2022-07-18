package org.example.api.pet.route;

import org.example.api.pet.handler.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RouterPetRest {
    @Bean
    public RouterFunction<ServerResponse> routerCreatePetFunction(CreatePetHandler handler) {
        return route(POST("/api/v1/pet"), handler::create);
    }

    @Bean
    public RouterFunction<ServerResponse> routerFindAllPetsFunction(FindAllPetsHandler handler) {
        return route(GET("/api/v1/pet"), handler::findAllPets);
    }

    @Bean
    public RouterFunction<ServerResponse> routerFindPetFunction(FindPetHandler handler) {
        return route(GET("/api/v1/pet/{id}"), handler::findPet);
    }

    @Bean
    public RouterFunction<ServerResponse> routerUpdatePetFunction(UpdatePetHandler handler) {
        return route(PUT("/api/v1/pet/{id}"), handler::update);
    }

    @Bean
    public RouterFunction<ServerResponse> routerDeletePetFunction(DeletePetHandler handler) {
        return route(DELETE("/api/v1/pet/{id}"), handler::deletePet);
    }
}
