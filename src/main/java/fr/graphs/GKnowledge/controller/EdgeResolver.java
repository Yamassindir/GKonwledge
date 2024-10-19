package fr.graphs.GKnowledge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import fr.graphs.GKnowledge.model.Edge;
import fr.graphs.GKnowledge.repository.EdgeRepository;

import java.util.List;

@Controller
public class EdgeResolver {

    @Autowired
    private EdgeRepository edgeRepository;

    // Query resolver using @QueryMapping
    @QueryMapping
    public Edge getEdge(String id) {
        return edgeRepository.findById(id).orElse(null);
    }

    @QueryMapping
    public List<Edge> getAllEdges() {
        return edgeRepository.findAll();
    }

    @MutationMapping
    public Edge createEdge(@Argument String sourceNodeId, @Argument String targetNodeId, @Argument String relationshipType) {
        Edge edge = new Edge(null, sourceNodeId, targetNodeId, relationshipType);
        return edgeRepository.save(edge);
    }
}
