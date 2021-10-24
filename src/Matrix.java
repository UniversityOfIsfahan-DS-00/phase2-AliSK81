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

    public void insert(int row, int col, int value) {
        Node newest = new Node(row, col, value);

        Node cur = R[row];

        if (cur == null || cur.col > col) {
            newest.next_in_row = cur;
            R[row] = newest;

        } else if (cur.col == col) {
            throw new RuntimeException("Cannot insert on existing node.");
        } else {

            while (cur.next_in_row != null && cur.next_in_row.col < col)
                cur = cur.next_in_row;

            if (cur.next_in_row != null && cur.next_in_row.col == col)
                throw new RuntimeException("Cannot insert on existing node.");

            newest.next_in_row = cur.next_in_row;
            cur.next_in_row = newest;
        }

        cur = C[col];

        if (cur == null || cur.row > row) {
            newest.next_in_col = cur;
            C[col] = newest;
        } else {
            while (cur.next_in_col != null && cur.next_in_col.row < row)
                cur = cur.next_in_col;

            newest.next_in_col = cur.next_in_col;
            cur.next_in_col = newest;
        }
    }

    public void delete(int row, int col) {
        Node cur = R[row];

        if (cur == null)
            throw new RuntimeException("Node not exist.");

        else if (cur.col == col)
            R[row] = cur.next_in_row;

        else {
            while (cur.next_in_row != null && cur.next_in_row.col < col)
                cur = cur.next_in_row;

            if (cur.next_in_row != null && cur.next_in_row.col == col)
                cur.next_in_row = cur.next_in_row.next_in_row;
            else
                throw new RuntimeException("Node not exist.");
        }

        cur = C[col];

        if (cur.row == row)
            C[col] = cur.next_in_col;
        else {
            while (cur.next_in_col != null && cur.next_in_col.row < row)
                cur = cur.next_in_col;

            assert cur.next_in_col != null;
            cur.next_in_col = cur.next_in_col.next_in_col;
        }
    }


    public void search(int value) {
        boolean found = false;

        for (Node head : R) {
            Node cur = head;

            while (cur != null) {
                if (cur.value == value) {
                    System.out.printf("(%d, %d)\n", cur.row, cur.col);
                    found = true;
                }
                cur = cur.next_in_row;
            }
        }
        if (!found)
            System.out.println("No result.");

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

    public void update(int row, int col, int value) {
        if (value == 0)
            throw new RuntimeException("Invalid value.");

        Node cur = R[row];

        while (cur != null && cur.col < col)
            cur = cur.next_in_row;

        if (cur == null || cur.col != col)
            throw new RuntimeException("Node not exist.");

        cur.value = value;
    }
}
