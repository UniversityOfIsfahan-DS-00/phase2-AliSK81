import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        File f = new File("J:\\Code\\Git\\DS\\phase2-AliSK81");

        FilenameFilter textFilter = (dir, name) -> name.endsWith(".csv");
        File[] files = f.listFiles(textFilter);
        assert files != null;

        for (int i = 0; i < files.length; i++) {
            System.out.println(i + ") " + files[i].getName());
        }

        System.out.print("Choose a file: ");

        String filename = files[sc.nextInt()].getName();
        int height = Integer.parseInt(filename.split("\\(")[1].split(",")[0]);
        int width = Integer.parseInt(filename.split("\\)")[0].split(",")[1]);

        int[][] matrix = new int[height][];

        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;

        for (int c = 0; (line = br.readLine()) != null; c++) {
            matrix[c] = Stream.of(line.split(","))
                    .mapToInt(Integer::parseInt).toArray();
        }

        Matrix M = new Matrix(matrix, height, width);
        System.out.println("matrix created.");

        while (true) {

            System.out.println("MENU:");
            System.out.println("0) Insert -row -col -value");
            System.out.println("1) Delete -row -col");
            System.out.println("2) Search -value");
            System.out.println("3) Update -row -col -value");
            System.out.println("4) Print");
            System.out.println("6) Exit");

            try {
                switch (sc.nextInt()) {
                    case 0 -> {
                        M.insert(sc.nextInt(), sc.nextInt(), sc.nextInt());
                        System.out.println("new node inserted.");
                    }
                    case 1 -> {
                        M.delete(sc.nextInt(), sc.nextInt());
                        System.out.println("node deleted.");
                    }
                    case 2 -> {
                        System.out.println("search result:");
                        M.search(sc.nextInt());
                    }
                    case 3-> {
                        M.update(sc.nextInt(), sc.nextInt(), sc.nextInt());
                        System.out.println("node updated.");
                    }
                    case 4 -> M.print();
                    case 6 -> System.exit(0);
                }
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
