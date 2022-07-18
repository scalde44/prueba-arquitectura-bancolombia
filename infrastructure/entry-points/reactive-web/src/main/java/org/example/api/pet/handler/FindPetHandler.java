package org.example.api.pet.handler;

import lombok.RequiredArgsConstructor;
import org.example.model.pet.Pet;
import org.example.usecase.pet.findpet.FindPetUseCase;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindPetHandler {
    private final FindPetUseCase useCase;

    public Mono<ServerResponse> findPet(ServerRequest serverRequest) {
        return Mono.just(serverRequest
                        .pathVariable("id"))
                .flatMap(useCase::apply)
                .flatMap(pet -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(pet));
    }
}
