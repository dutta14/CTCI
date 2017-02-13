package TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Anindya on 2/11/2017.
 */
public class RouteBetweenNodes {

    enum State {
        Unvisited, Visited, Visiting;
    }

    boolean findIfRoute(Graph g, Node src, Node dst) {
        if(src == dst)
            return true;

        Queue<Node> q = new LinkedList<>();
        for(Node i: g.nodes) {
            i.state = State.Unvisited;
        }

        src.state = State.Visiting;
        q.add(src);
        Node u;
        while(!q.isEmpty()) {
            u = q.remove();
            for(Node i: u.mNodes)  {
                if(i.state == State.Unvisited) {
                    if(i==dst)
                        return true;
                    i.state = State.Visiting;
                    q.add(i);
                }
            }
            u.state = State.Visited;
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        Graph g = new Graph(n);
        for(int i=0; i<n; i++)
            g.createNode(i);

        for(int i=0; i<n; i++) {
            System.out.print("n"+i+":");
            int adj = s.nextInt();
            if(adj>0) {
                System.out.print("nlist:");
                for (int j = 0; j < adj; j++)
                    g.addNeighbor(i, s.nextInt());
            }
        }

        int src = s.nextInt(), dst = s.nextInt();

        RouteBetweenNodes obj = new RouteBetweenNodes();
        Node st = g.nodes.get(src), d = g.nodes.get(dst);
        boolean result = obj.findIfRoute(g,st,d);
        System.out.println(result);
    }
}
