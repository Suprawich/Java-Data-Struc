package datastr;

public class Edge {
    private Vertex st, end;
    public Edge(Vertex b, Vertex e) {
        st = b;
        end = e;
    }

    public int getSource() {
        return st.getName();
    }

    public int getDest() {
        return end.getName();
    }

    @Override
    public String toString() {
        return st + " - " + end;
    }
}
