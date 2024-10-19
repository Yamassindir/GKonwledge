package fr.graphs.GKnowledge.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.graphs.GKnowledge.model.Node;

public interface NodeRepository extends MongoRepository<Node, String> {
    // Custom queries (if needed)
}