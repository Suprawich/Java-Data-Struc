import datastr.ArrayStack;
import datastr.Stack;

public class Main {
    private static final int SPACE = -1;
    private static final int BLOCK = -9;
    private static final int[][] map = new int[10][10];

    private static class Pos {
        int row, col;

        public Pos(int r, int c) {
            row = r;
            col = c;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = Math.random() < 0.2 ? BLOCK : SPACE;
            }
        }
        findPath(new Pos(0, 0), new Pos(0, map[0].length - 1));
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.printf("%4d", map[i][j]);
            }
            System.out.println();
        }
    }

    static void findPath(Pos source, Pos target) {
        map[source.row][source.col] = 0; //ให้จุดเริ่มต้นเป็น 0
        map[target.row][target.col] = SPACE; //เส้นชัย จะเป็น SPACE เท่านั้นไม่ใช่ BLOCK
        Stack s = new ArrayStack();
        s.push(source);
        while (!s.isEmpty()) {
            Pos p = (Pos) s.pop();
            if (p.row == target.row && p.col == target.col) {
                break;
            }
            expand(s, p.row + 1, p.col, map[p.row][p.col]);
            expand(s, p.row - 1, p.col, map[p.row][p.col]);
            expand(s, p.row, p.col + 1, map[p.row][p.col]);
            expand(s, p.row, p.col - 1, map[p.row][p.col]);
        }
    }

    static void expand(Stack s1, int x, int y, int k) {
        if (x < 0 || x >= map.length || y < 0 || y >= map[x].length || map[x][y] != SPACE) {
            return;
        }
        map[x][y] = k + 1;
        s1.push(new Pos(x, y));
    }

}