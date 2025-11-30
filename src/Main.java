import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main
{
    public static int[][] readCSV(String path) throws Exception {
        int[][] board = new int[9][9];
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        int row = 0;
        while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            for (int col = 0; col < 9; col++) {
                board[row][col] = Integer.parseInt(values[col]);
            }
            row++;
        }
        br.close();
        return board;
    }

    public static void main(String[] args) throws Exception {
        String filepath=args[0];
        int mode= Integer.parseInt(args[1]);
        int[][] board = readCSV(filepath);
        SudokuChecker check= CheckerFactory.getChecker(mode);
        check.verify(board);
    }

}
