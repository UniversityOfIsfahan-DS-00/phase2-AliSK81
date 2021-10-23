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

        for (int c = 0; (line = br.readLine()) != null ; c++) {
            matrix[c] = Stream.of(line.split(","))
                    .mapToInt(Integer::parseInt).toArray();
        }

        Matrix M = new Matrix(matrix, height, width);
        System.out.println("matrix created.");
    }
}
