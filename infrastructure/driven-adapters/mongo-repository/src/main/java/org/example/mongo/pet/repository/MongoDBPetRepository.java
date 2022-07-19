package org.example.mongo.pet.repository;

import org.example.mongo.pet.document.PetDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import reactor.core.publisher.Flux;

public interface MongoDBPetRepository
        extends ReactiveMongoRepository<PetDocument, String>, ReactiveQueryByExampleExecutor<PetDocument> {
}
