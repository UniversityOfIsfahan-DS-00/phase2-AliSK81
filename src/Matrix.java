import java.util.Arrays;

public class Matrix {
    Node[] R;
    Node[] C;

    public Matrix(int[][] M, int height, int width) {
        R = new Node[height];
        C = new Node[width];

        // LinkedList in rows

        for (int row = 0; row < height; row++) {

            int col = 0;
            while (col < width && M[row][col] == 0)
                col++;

            Node cur = null;
            if (col < width) {
                int value = M[row][col];
                cur = new Node(row, col, value);
                R[row] = cur;
            }

            while (col < width - 1) {
                col++;
                int value = M[row][col];

                if (value != 0) {
                    Node newest = new Node(row, col, value);
                    cur.next_in_row = newest;
                    cur = newest;
                }
            }
        }

        // LinkedList in columns

        for (int row = 0; row < height; row++) {

            Node cur1 = R[row];
            while (cur1 != null) {
                int col = cur1.col;
                if (C[col] == null)
                    C[col] = cur1;

                for (int row2 = row + 1; row2 < height; row2++) {

                    Node cur2 = R[row2];
                    while (cur2 != null && cur2.col < col)
                        cur2 = cur2.next_in_row;

                    if (cur2 != null && cur2.col == col) {
                        cur1.next_in_col = cur2;
                        break;
                    }
                }
                cur1 = cur1.next_in_row;
            }
        }
    }

    public void print() {

        System.out.println("ROW   COL   VAL    NIR    NIC");

        for (Node head : R) {
            Node cur = head;
            while (cur != null) {
                System.out.printf("%-5d %-5d %-6d %-6s %-6s\n",
                        cur.row, cur.col, cur.value,
                        cur.next_in_row, cur.next_in_col);

                cur = cur.next_in_row;
            }
        }

    }
}
