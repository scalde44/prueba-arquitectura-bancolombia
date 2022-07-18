package org.example.usecase.pet.findpet;

import lombok.RequiredArgsConstructor;
import org.example.model.pet.Pet;
import org.example.model.pet.gateways.PetRepository;
import org.example.usecase.exception.PetNotFoundException;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@RequiredArgsConstructor
public class FindPetUseCase implements Function<String, Mono<Pet>> {
    private static final String PET_CON_EL_ID_NO_EXISTE = "Pet con el id %s no existe";
    private final PetRepository petRepository;

    @Override
    public Mono<Pet> apply(String id) {
        return this.petRepository.findById(id)
                .switchIfEmpty(
                        Mono.error(new PetNotFoundException(String.format(PET_CON_EL_ID_NO_EXISTE, id)))
                );
    }
}
