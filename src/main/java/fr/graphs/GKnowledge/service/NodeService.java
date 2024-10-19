package fr.graphs.GKnowledge.service;

import org.springframework.stereotype.Service;

import fr.graphs.GKnowledge.model.KeyValuePair;
import fr.graphs.GKnowledge.model.Node;
import fr.graphs.GKnowledge.repository.NodeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class NodeService {

    @Autowired
    private NodeRepository nodeRepository;

    public Node getNodeById(String id) {
        return nodeRepository.findById(id).orElse(null);
    }

    public List<Node> getAllNodes() {
        return nodeRepository.findAll();
    }

    public Node createNode(String name, String type, List<KeyValuePair> properties) {
        Node node = new Node(null, name, type, properties);
        return nodeRepository.save(node);
    }
}
