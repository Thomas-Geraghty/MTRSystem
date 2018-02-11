package model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The <code>AbstractNode</code> class provides specific functionality, for
 * finding the most efficient path from one <code>station</code> to another.
 * 
 * This class uses the search algorithm: Breadth First Search to accomplish
 * finding the most efficient path between two stations.
 * 
 * @author Joshua Gallagher
 * @author Thomas Geraghty
 * @author Dimitar Stoynev
 * 
 * @version 15/10/2017
 */
public abstract class AbstractNode {

	/**
	 * A set of <code>connectedNodes</code> that represent connected stations.
	 */
	private final Set<AbstractNode> connectedNodes = new HashSet<>();

	/**
	 * Adds a <code>node</code> to the <code>connectedNodes</code> <code>Set</code>.
	 * 
	 * @param node
	 *            A node represents a single <code>Station<code> in the system.
	 */
	public void addConnectedNode(AbstractNode node) {
		connectedNodes.add(node);
	}

	/**
	 * Returns the <code>Set</code> of <code>connectedNodes</code>.
	 * 
	 * @return connectedNodes Returns a <code>Set</code> of
	 *         <code>connectedNodes</code> - (connected stations).
	 */
	public Set<AbstractNode> getConnectedNodes() {
		return connectedNodes;
	}

	/**
	 * This method performs Breadth First Search on two stations - the start and end
	 * nodes (stations).
	 * 
	 * First, it performs BFS to find the most efficient path to the end station.
	 * 
	 * Secondly, it takes the found path (if a path is found), and returns it as a
	 * <code>LinkedList</code> so the output can be rendered for the user.
	 * 
	 * @param endNode
	 *            The node (<code>station</code>) that the algorithm should find a
	 *            path to.
	 * @return pathList Returns a <code>List</code> of nodes. The nodes returned are
	 *         all stations needed to reach the <code>endNode</code>.
	 */
	public List<AbstractNode> bfsFromHere(AbstractNode endNode) {
		LinkedList<AbstractNode> queue = new LinkedList<>();
		Set<AbstractNode> visited = new HashSet<>();
		Map<AbstractNode, AbstractNode> parents = new HashMap<>();

		queue.add(this);
		visited.add(this);

		while (!queue.isEmpty()) {
			AbstractNode currentNode = queue.remove();

			for (AbstractNode node : currentNode.getConnectedNodes()) {
				if (!visited.contains(node)) {
					queue.add(node);
					parents.put(node, currentNode);
				}
			}
			visited.add(currentNode);
		}

		List<AbstractNode> pathList = new LinkedList<>();

		if (parents.get(endNode) == null)
			return null;

		for (AbstractNode curNode = endNode; curNode != null;) {
			pathList.add(0, curNode);
			curNode = parents.get(curNode);
		}

		return pathList;
	}
}