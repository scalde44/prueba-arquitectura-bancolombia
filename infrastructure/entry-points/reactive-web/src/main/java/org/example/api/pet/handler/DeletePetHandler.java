package org.example.api.pet.handler;

import lombok.RequiredArgsConstructor;
import org.example.usecase.pet.deletepet.DeletePetUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class DeletePetHandler {
    private final DeletePetUseCase useCase;

    public Mono<ServerResponse> deletePet(ServerRequest serverRequest) {
        return Mono.just(serverRequest
                        .pathVariable("id"))
                .flatMap(useCase::apply)
                .flatMap(pet -> ServerResponse
                        .status(HttpStatus.NO_CONTENT)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(pet));
    }
}
