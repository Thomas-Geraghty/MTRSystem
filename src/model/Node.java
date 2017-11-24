package model;

import java.util.HashSet;
import java.util.LinkedList;

public abstract class Node {

    private final HashSet<Node> CONNECTED_NODES = new HashSet<Node>();

    public void addConnectedNode(Node node) {
        CONNECTED_NODES.add(node);
    }

    public HashSet<Node> getConnectedNodes() {
        return CONNECTED_NODES;
    }

    public String bfsFromHere(Node endNode) {
        LinkedList<Node> queue = new LinkedList<Node>();
        HashSet<Node> visited = new HashSet<Node>();

        queue.add(this);
        visited.add(this);


        while(!queue.isEmpty()) {
            Node currentNode = queue.remove();

            if(currentNode == endNode) {
                return "PATH FOUND - SOMEONE IMPLEMENT THE PATH TRACE. IM UNDER THE NODE CLASS";
            } else {
                if(currentNode.getConnectedNodes().isEmpty()) {
                    return "PATH NOT FOUND";
                } else {
                    for (Node node : currentNode.getConnectedNodes()) {
                        if (!visited.contains(node)) {
                            queue.add(node);
                        }
                    }
                }
                visited.add(currentNode);
            }
        }
        return "PATH NOT FOUND";
    }
}
