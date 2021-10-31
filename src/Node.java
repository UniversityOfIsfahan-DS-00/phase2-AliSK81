public class Node {
    int row;
    int col;
    int value;
    public Node next_in_row;
    public Node next_in_col;

    public Node(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public String toString() {
        return String.valueOf(value);
    }
}
