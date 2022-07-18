package org.example.model.pet.gateways;

import org.example.model.pet.Pet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PetRepository {
    Mono<Pet> save(Pet pet);

    Mono<Pet> findById(String id);

    Flux<Pet> findAll();

    Mono<Void> deleteById(String id);
}
