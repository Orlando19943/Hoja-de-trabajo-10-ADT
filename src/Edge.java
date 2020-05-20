/**
 * 
 */

/**
 * @author Orlando
 *
 */
public class Edge {
    private Node start;
    private Node end;
    private double weight;
    private int id;
    public int getId() {
        return this.id;
    }
    public Node getStart() {
        return this.start;
    }
    public int getIdOfStartNode() {
        return this.start.getNodeId();
    }
    public Node getEnd() { 
        return this.end; 
    }
    public int getIdOfEndNode() {
        return this.end.getNodeId();
    }
    
    public double getWeight() {
        return this.weight;
    }
    public Edge(Node s, Node e, double w, int id) {
        this.start = s;
        this.end = e;
        this.weight = w;
        this.id = id;
    }
}
