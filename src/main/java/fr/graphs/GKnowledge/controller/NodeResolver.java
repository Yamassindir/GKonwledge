package fr.graphs.GKnowledge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import fr.graphs.GKnowledge.model.KeyValuePair;
import fr.graphs.GKnowledge.model.Node;
import fr.graphs.GKnowledge.service.NodeService;

@Controller
public class NodeResolver {

    @Autowired
    private NodeService nodeService;

    @QueryMapping
    public Node getNode(String id) {
        return nodeService.getNodeById(id);
    }

    @QueryMapping
    public List<Node> getAllNodes() {
        return nodeService.getAllNodes();
    }

    @MutationMapping
    public Node createNode( @Argument String name, @Argument String type, @Argument List<KeyValuePair> properties) {
        return nodeService.createNode(name, type, properties);
    }
}
