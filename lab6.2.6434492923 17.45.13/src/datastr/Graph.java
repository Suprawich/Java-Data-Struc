package datastr;

import java.util.HashMap;
import java.util.Random;

public class Graph {
    private Edge[] edge;
    private Vertex[] vertex;

    HashMap<Edge, Integer> graph = new HashMap<>();


    public Graph(int vertexNum, int edgeNum) {
        Random r = new Random();
        vertex = new Vertex[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            vertex[i] = new Vertex(i);
        }
        edge = new Edge[edgeNum];
        for (int i = 0; i < edgeNum; i++) {
            Edge edge1 = new Edge(vertex[r.nextInt(vertexNum)], vertex[r.nextInt(vertexNum)]);
            if (!graph.containsKey(edge1)) {
                edge[i] = edge1;
                graph.put(edge1, r.nextInt(1, 4));
            }
        }
    }

    public Graph(int[][] adjMatrix) {
        vertex = new Vertex[adjMatrix.length];
        for (int i = 0; i < adjMatrix.length; i++) {
            vertex[i] = new Vertex(i);
        }
        int countE = 0;
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] != 0) {
                    countE += 1;
                }
            }
        }
        int c = 0;
        edge = new Edge[countE];
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] != 0) {
                    Edge edge1 = new Edge(vertex[i], vertex[j]);
                    graph.put(edge1, adjMatrix[i][j]);
                    edge[c++] = edge1;
                }
            }
        }
    }

    public int weight(Edge e) {
        for (int i = 0; i < edge.length; i++) {
            if (edge[i].getDest() == e.getDest() && edge[i].getSource() == e.getSource()) {
                return graph.get(edge[i]);
            }
        }
        return 0;
    }

    public int[][] toMatrix() {
        int[][] adjMatrix = new int[vertex.length][vertex.length];
        for (int i = 0; i < vertex.length; i++) {
            for (int j = 0; j < vertex.length; j++) {
                Edge edge1 = new Edge(new Vertex(i), new Vertex(j));
                if (weight(edge1) != 0) {
                    adjMatrix[i][j] = weight(edge1);
                }
            }
        }
        return adjMatrix;
    }

    public String toString() {
        String s = "";
        int[][] m = toMatrix();
        for (int i = 0; i < vertex.length; i++) {
            for (int j = 0; j < vertex.length; j++) {
                s += m[i][j]+"\t";
            }
            s += "\n";
        }
        return s;
    }
}
