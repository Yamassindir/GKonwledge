package fr.graphs.GKnowledge.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.graphs.GKnowledge.model.Edge;

public interface EdgeRepository extends MongoRepository<Edge, String> {
    // Custom queries (if needed)
}
