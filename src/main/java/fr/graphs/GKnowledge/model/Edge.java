package fr.graphs.GKnowledge.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "edges")
public record Edge(
    @Id String id, 
    String sourceNodeId, 
    String targetNodeId, 
    String relationshipType
) {}
