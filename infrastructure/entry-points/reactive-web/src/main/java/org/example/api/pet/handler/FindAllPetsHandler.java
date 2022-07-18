package org.example.api.pet.handler;

import lombok.RequiredArgsConstructor;
import org.example.model.pet.Pet;
import org.example.usecase.pet.findallpets.FindAllPetsUseCase;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FindAllPetsHandler {
    private final FindAllPetsUseCase useCase;

    public Mono<ServerResponse> findAllPets(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(useCase.get(), Pet.class));
    }
}
