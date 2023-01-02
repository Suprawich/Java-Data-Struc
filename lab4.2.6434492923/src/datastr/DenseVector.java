package datastr;

public class DenseVector implements Vector {
    private static class Element {
        int index;
        double value;
        Element(int i, double v) {
            this.index = i;  this.value = v;
        }
    }
    private int size;
    private int length;
    private DenseVector.Element[] elementData;
    public DenseVector(int length) {
        this.elementData = new DenseVector.Element[0];
        this.size = 0;
        this.length = length;
    }

    @Override
    public int length() {
        return length;
    }
    @Override
    public double get(int index) {
        for(int i=0; i<size; i++) {
            if (elementData[i].index == index)
                return elementData[i].value;
            if (elementData[i].index > index) break;
        }
        return 0.0;
    }

    @Override
    public void set(int index, double value) {
        int i = 0;
        for ( ;i<size; i++ )
            if (elementData[i].index >= index) break;
        if (i<size && elementData[i].index == index)
            elementData[i].value = value;
        else
            add(i, index, value);
    }
    public void add(int i, int index, double value) {
        ensureCapacity(size+1);
        for (int k=size; k>i; k--)
            elementData[k] = elementData[k-1];
        elementData[i] = new DenseVector.Element(index, value);
        ++size;
    }
    public double dot(Vector v2) {
        double r = 0;
        DenseVector v1 = this;
        for (int i = 0; i < v1.length(); i++) {
            r += v1.get(i) * v2.get(i);
        }
        return r;
    }
    public Vector multiply(double c) {
        DenseVector v = new DenseVector(this.size);
        for (int i=0; i<size; i++) {
            v.add(i, elementData[i].index, c*elementData[i].value);
        }
        return v;
    }
    public SparseVector multiply(Matrix m) {
        if (length()!=m.numRows()) throw new ArithmeticException("Incompatibility to multiplication.");
        SparseVector r = new SparseVector(m.numCols());
        if (m instanceof SparseMatrix) {
            for (int i = 0; i < length(); i++) {
                r = r.add(((SparseMatrix)m).rows[i].multiply(get(i)));
            }
        } else if (m instanceof DenseMatrix) {
            for (int i = 0 ; i<m.numCols(); i++) {
                double x=0;
                for (int j = 0; j< m.numRows(); j++) {
                    x += get(j)*m.get(j, i);
                }
                r.set(i, x);
            }
        }
        return r;
    }
    private void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int s = Math.max(capacity, 2*elementData.length);
            DenseVector.Element[] arr = new DenseVector.Element[s];
            for(int i = 0; i < size; i++)
                arr[i] = elementData[i];
            elementData = arr;
        }
    }
    @Override
    public double magnitude() {
        double total = 0;
        for (int i = 0; i < size; i++) {
            total += elementData[i].value*elementData[i].value;
        }
        return Math.sqrt(total);
    }
    @Override
    public Vector add(Vector v) {
        DenseVector d = new DenseVector(length);
        if (this.length() == v.length()) {
            for(int i = 0; i < length; i++) {
                d.set(i, this.get(i)+v.get(i));
            }
        }
        else {
            throw new ArithmeticException("Vector length is not equal.");
        }
        return d;
    }
    @Override
    public Vector subtract(Vector v) {
        DenseVector d = new DenseVector(length);
        if (this.length() == v.length()) {
            for(int i = 0; i < length; i++) {
                d.set(i, this.get(i)-v.get(i));
            }
        }
        else {
            throw new ArithmeticException("Vector length is not equal.");
        }
        return d;
    }
    public String toString() {
        System.out.print("[ "+this.get(0));
        for (int i = 1; i < this.length; i++) {
            System.out.print(", " + this.get(i));
        }
        System.out.println(" ]");
        return null;
    }
}