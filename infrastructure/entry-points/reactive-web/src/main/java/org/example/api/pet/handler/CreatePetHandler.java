package org.example.api.pet.handler;

import lombok.RequiredArgsConstructor;
import org.example.model.pet.Pet;
import org.example.usecase.pet.createpet.CreatePetUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreatePetHandler {
    private final CreatePetUseCase useCase;

    public Mono<ServerResponse> create(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(Pet.class)
                .flatMap(this.useCase::apply)
                .flatMap(pet -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(pet));
    }
}
