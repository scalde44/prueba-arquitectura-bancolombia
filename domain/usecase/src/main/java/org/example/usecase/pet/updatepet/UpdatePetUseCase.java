package org.example.usecase.pet.updatepet;

import lombok.RequiredArgsConstructor;
import org.example.model.pet.Pet;
import org.example.model.pet.gateways.PetRepository;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

@RequiredArgsConstructor
public class UpdatePetUseCase implements BiFunction<Pet, String, Mono<Pet>> {
    private final PetRepository petRepository;

    @Override
    public Mono<Pet> apply(Pet pet, String id) {
        return this.petRepository.findById(id)
                .switchIfEmpty(Mono.error(new Exception("No se encontro")))
                .map(pet1 -> pet1.toBuilder()
                        .name(pet.getName())
                        .breed(pet.getBreed())
                        .build())
                .flatMap(this.petRepository::save);
    }
}
