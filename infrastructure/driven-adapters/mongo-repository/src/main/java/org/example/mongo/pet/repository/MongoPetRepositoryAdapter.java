package org.example.mongo.pet.repository;

import org.example.model.pet.Pet;
import org.example.model.pet.gateways.PetRepository;
import org.example.mongo.helper.AdapterOperations;
import org.example.mongo.pet.document.PetDocument;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MongoPetRepositoryAdapter
        extends AdapterOperations<Pet, PetDocument, String, MongoDBPetRepository>
        implements PetRepository {

    public MongoPetRepositoryAdapter(MongoDBPetRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Pet.class));
    }
}
