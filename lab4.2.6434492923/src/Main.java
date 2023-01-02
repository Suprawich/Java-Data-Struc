import datastr.DenseMatrix;
import datastr.Matrix;
import datastr.SparseMatrix;
import datastr.Vector;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        int row = r.nextInt(2,10);
        int col = r.nextInt(2,10);
        Matrix m1 = new DenseMatrix(row, col);

        for (int i = 0; i < m1.numRows(); i++) {
            int j = 0;
            for (; j < m1.numCols(); j++) {
                m1.set(i, j, r.nextInt(0,10));
            }
        }

        System.out.println("matrix m1 =");
        m1.toString();

        Matrix m2 = new SparseMatrix(col,r.nextInt(2,10));

        for (int i = 0; i < m2.numRows(); i++) {
            int j = 0;
            for (; j < m2.numCols(); j++) {
                m2.set(i, j, r.nextInt(0,10));
            }
        }
        System.out.println("=================================");
        System.out.println("matrix m2 =");
        m2.toString();

        Matrix m3 = new DenseMatrix(row,col);

        for (int i = 0; i < m3.numRows(); i++) {
            int j = 0;
            for (; j < m3.numCols(); j++) {
                m3.set(i, j, r.nextInt(0,10));
            }
        }
        System.out.println("=================================");
        System.out.println("matrix m3 =");
        m3.toString();

        Matrix testM;
        testM = m1.multiply(m2);
        System.out.println("=================================");
        System.out.println("m1*m2 =");
        testM.toString();

        testM = m1.add(m3);
        System.out.println("=================================");
        System.out.println("m1+m3 =");
        testM.toString();
    }
}
