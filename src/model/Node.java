package model;

import java.util.HashSet;

public abstract class Node {

    private HashSet<Node> connectedNodes = new HashSet<Node>();

    public void addConnectedNode(Node node) {
        connectedNodes.add(node);
    }

    public HashSet<Node> getConnectedNodes() {
        return connectedNodes;
    }
}
