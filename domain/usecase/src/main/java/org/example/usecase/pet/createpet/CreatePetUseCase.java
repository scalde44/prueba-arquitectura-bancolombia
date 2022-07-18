package org.example.usecase.pet.createpet;

import lombok.RequiredArgsConstructor;
import org.example.model.pet.Pet;
import org.example.model.pet.gateways.PetRepository;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class CreatePetUseCase implements Function<Pet, Mono<Pet>> {
    private final PetRepository petRepository;


    @Override
    public Mono<Pet> apply(Pet pet) {
        return this.petRepository.save(pet);
    }
}
