package model;

import java.util.*;

public class Graph {

    private HashSet<Node> nodeList = new HashSet<Node>();

    public void addNode(Node node) {
        nodeList.add(node);
    }

    public void removeNode(Node node) {
        nodeList.remove(node);
    }

    public String BFS(Node startNode, Node endNode) {
        Queue<Node> queue = new LinkedList<Node>();
        Set<Node> visited = new HashSet<Node>();

        queue.add(startNode);
        visited.add(startNode);


        while(!queue.isEmpty()) {
            Node currentNode = queue.remove();

            if(currentNode == endNode) {
                return "PATH FOUND - SOMEONE IMPLEMENT THE PATH TRACE. IM UNDER THE GRAPH CLASS";
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
