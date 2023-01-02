package datastr;

public interface Matrix {
    public int numCols();
    public int numRows();
    public double get(int r, int c);
    public void set(int r, int c, double v);
    public Matrix add(Matrix m);
    public Vector multiply(Vector v);
    public Matrix multiply(Matrix m);

}
