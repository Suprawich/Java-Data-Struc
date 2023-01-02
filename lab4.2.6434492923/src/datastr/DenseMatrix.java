package datastr;

public class DenseMatrix implements Matrix {
    DenseVector[] rows;

    public DenseMatrix(int r, int c) {
        rows = new DenseVector[r];
        for (int i = 0; i < r; i++)
            rows[i] = new DenseVector(c);
    }

    @Override
    public int numRows() {
        return rows.length;
    }

    @Override
    public int numCols() {
        return rows[0].length();
    }

    @Override
    public void set(int r, int c, double v) {
        assertInRange(r, c);
        rows[r].set(c,v);
    }

    @Override
    public double get(int r, int c) {
        assertInRange(r, c);
        return rows[r].get(c);
    }

    private void assertInRange(int r, int c) {
        if (r < 0 || r >= numRows() || c < 0 || c >= numCols())
            throw new IndexOutOfBoundsException(r + "," + c);
    }

    @Override
    public Matrix add(Matrix m) {
        DenseMatrix m1 = this;
        DenseMatrix m3 = new DenseMatrix(numRows(), numCols());
        if (m1.numRows() != m.numRows() || m1.numCols() != m.numCols())
            throw new IllegalArgumentException("Matrix cannot be added.");
        for (int i = 0; i < m3.numRows(); i++) {
            for (int j = 0; j < m3.numCols(); j++) {
                m3.set(i, j, m1.get(i, j) + m.get(i, j));
            }
        }
        return m3;
    }

    @Override
    public Vector multiply(Vector v) {
        if (v.length() != numCols())
            throw new IllegalArgumentException();
        SparseVector r = new SparseVector(numRows());
        for(int i=0; i<numRows(); i++) {
            r.set(i, rows[i].dot(v));
        }
        return (Vector) r;
    }

    @Override
    public Matrix multiply(Matrix m) {
        DenseMatrix m1 = this; // m3 = m1 x m2
        if (m1.numCols() != m.numRows())
            throw new IllegalArgumentException("Incomnpatibility for multiplication.");
        SparseMatrix m3 = new SparseMatrix(m1.numRows(),m.numCols());
        for(int i=0; i<m1.numRows(); i++) {
            m3.rows[i] = m1.rows[i].multiply(m);
        }
        return m3;
    }

    public String toString() {
        for (int i = 0; i < this.numRows(); i++) {
            for (int j = 0 ;j < this.numCols(); j++) {
                System.out.print(this.get(i,j));
                if (this.get(i,j) <10) {
                    System.out.print("\t\t");
                }
                else {
                    System.out.print("\t");
                }
            }
            System.out.println("");
        }
        return null;
    }
}
