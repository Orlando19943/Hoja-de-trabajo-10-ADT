/**
 * 
 */

/**
 * @author Orlando
 *
 */
import java.util.*;
public class Graph {
	private List<Node> nodes = new ArrayList<Node>();
	private int numberOfNodes = 0;
	public boolean checkForAvailability() { // will be used in Main.java
		return this.numberOfNodes > 1;
	}
	public void createNode(Node node) {
		this.nodes.add(node);
		this.numberOfNodes++; // a node has been added
	}
	public int getNumberOfNodes() {
		return this.numberOfNodes;
	}
}
