import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    static File[] get_csv_files() {
        File f = new File(".").getAbsoluteFile();
        FilenameFilter textFilter = (dir, name) -> name.endsWith(".csv");
        return f.listFiles(textFilter);
    }

    static int selectFile(File[] files) {
        int i = 0;
        for (File file : files)
            System.out.printf("%d) %s\n", i++, file.getName());

        System.out.print("select a file: ");
        return new Scanner(System.in).nextInt();
    }

    static Matrix createMatrix(String filename) throws IOException {

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            int height = Integer.parseInt(filename.split("\\(")[1].split(",")[0]);
            int width = Integer.parseInt(filename.split("\\)")[0].split(",")[1]);
            int[][] matrix = new int[height][];

            String line;
            for (int c = 0; (line = br.readLine()) != null; c++) {
                matrix[c] = Stream.of(line.split(","))
                        .mapToInt(Integer::parseInt).toArray();
            }
            return new Matrix(matrix, height, width);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            File[] files = get_csv_files();

            int select = selectFile(files);
            String filename = files[select].getName();

            Matrix M = createMatrix(filename);
            System.out.println("matrix created.");

            boolean menu = true;
            while (menu) {

                System.out.println("MENU:");
                System.out.println("0) Insert -row -col -value");
                System.out.println("1) Delete -row -col");
                System.out.println("2) Search -value");
                System.out.println("3) Update -row -col -value");
                System.out.println("4) Print -type [0-1]");
                System.out.println("5) Save File");
                System.out.println("6) Change File ");
                System.out.println("7) Exit");

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
                        case 3 -> {
                            M.update(sc.nextInt(), sc.nextInt(), sc.nextInt());
                            System.out.println("node updated.");
                        }
                        case 4 -> M.print(sc.nextInt());
                        case 5 -> {
                            M.save_file();
                            System.out.println("file saved.");
                        }
                        case 6 -> menu = false;
                        case 7 -> System.exit(0);
                    }
                } catch (RuntimeException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
