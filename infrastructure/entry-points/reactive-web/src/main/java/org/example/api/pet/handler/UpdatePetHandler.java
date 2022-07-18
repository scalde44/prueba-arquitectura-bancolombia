package org.example.api.pet.handler;

import lombok.RequiredArgsConstructor;
import org.example.model.pet.Pet;
import org.example.usecase.pet.updatepet.UpdatePetUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UpdatePetHandler {
    private final UpdatePetUseCase useCase;

    public Mono<ServerResponse> update(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(Pet.class)
                .zipWith(Mono.just(serverRequest.pathVariable("id")))
                .flatMap(objects ->
                        this.useCase.apply(objects.getT1(), objects.getT2())
                )
                .flatMap(pet -> ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(pet));
    }
}
