package fr.graphs.GKnowledge.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "nodes")
public record Node(
    @Id String id, 
    String name, 
    String type, 
    List<KeyValuePair> properties
) {}
