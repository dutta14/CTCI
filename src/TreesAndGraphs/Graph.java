package TreesAndGraphs;

import java.util.ArrayList;

/**
 * Created by Anindya on 2/11/2017.
 */

class Node {
    private int data;
    public ArrayList<Node> mNodes;
    public RouteBetweenNodes.State state;

    Node(int data) {
        this.data = data;
        mNodes = new ArrayList<>();
    }

    void addNeighbor(Node n) {
        mNodes.add(n);
    }
}
public class Graph {
    ArrayList<Node> nodes;
    int size;

    Graph(int size) {
        this.size = size;
        nodes = new ArrayList<>(size);
    }

    void createNode(int data) {
        Node n = new Node(data);
        nodes.add(n);
    }

    void addNeighbor(int s, int d) {
        nodes.get(s).addNeighbor(nodes.get(d));
        nodes.get(d).addNeighbor(nodes.get(s));
    }
}