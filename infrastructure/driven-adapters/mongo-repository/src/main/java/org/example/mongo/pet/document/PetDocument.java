package org.example.mongo.pet.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(value = "pet")
public class PetDocument {
    @Id
    private String id;
    private String name;
    private String breed;
}
