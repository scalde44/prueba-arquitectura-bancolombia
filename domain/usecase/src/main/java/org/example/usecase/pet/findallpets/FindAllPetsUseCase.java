package org.example.usecase.pet.findallpets;

import lombok.RequiredArgsConstructor;
import org.example.model.pet.Pet;
import org.example.model.pet.gateways.PetRepository;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@RequiredArgsConstructor
public class FindAllPetsUseCase implements Supplier<Flux<Pet>> {
    private final PetRepository petRepository;

    @Override
    public Flux<Pet> get() {
        return this.petRepository.findAll();
    }
}
