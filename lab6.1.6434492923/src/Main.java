import datastr.Graph;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int r = random.nextInt(5, 11);

        int[][] matrix1 = new int[r][r];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                matrix1[i][j] = random.nextInt(6);
            }
        }

        System.out.println("Random adjacency matrix of graph 1");
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                System.out.print(matrix1[i][j]+"\t");
            }
            System.out.println();
        }
        System.out.println("--------------------------");

        System.out.println("Adjacency matrix created from graph 1");
        Graph g1 = new Graph(matrix1);
        System.out.print(g1);
        System.out.println("--------------------------");

        Graph g2 = new Graph(r, (int) (Math.pow(r, 2))/4);
        System.out.println("Adjacency matrix created from graph 2");
        System.out.print(g2);
        System.out.println("--------------------------");
    }
}