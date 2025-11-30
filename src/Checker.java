import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public abstract class Checker implements SudokuChecker{
    protected boolean state=true;
    protected boolean flag=false;
    protected boolean is27;

    protected void checkRows(int[][] board) throws InterruptedException {
        for(int i=0;i<9;i++) {
            checkRow(board,i);
        }
    }

    protected void checkRow(int[][] board, int idx) throws InterruptedException {
        boolean[] exist= new boolean[10];
        List<Integer> duplicates= new ArrayList<>();
        for(int col=0;col<9;col++) {
            int x=board[idx][col];
            if(exist[x] && !duplicates.contains(x)) duplicates.add(x);
            exist[x]=true;
        }
        for (int value:duplicates)
        {
            state=false;
            if(!flag) System.out.println("Invalid");
            flag=true;
            List<Integer> locations = new ArrayList<>();
            for (int col= 0;col<9;col++)
            {
                if (board[idx][col]==value) locations.add(col+1);
            }
            System.out.println("ROW " + (idx+1) + ", #" + value + ", " + locations);
            if(is27) Thread.sleep(1000);
        }
    }

    protected void checkColumns(int[][] board) throws InterruptedException {
        for(int i=0;i<9;i++) {
            checkColumn(board,i);
        }
    }

    protected void checkColumn(int[][] board, int idx) throws InterruptedException {
        boolean[] exist= new boolean[10];
        List<Integer> duplicates= new ArrayList<>();
        for(int row=0;row<9;row++) {
            int x=board[row][idx];
            if(exist[x] && !duplicates.contains(x)) duplicates.add(x);
            exist[x]=true;
        }
        for (int value : duplicates)
        {
            if(!flag) System.out.println("Invalid");
            List<Integer> locations = new ArrayList<>();
            for (int row=0;row<9;row++)
            {
                if (board[row][idx]==value) locations.add(row+1);
            }
            System.out.println("COL " + (idx+1) + ", #" + value + ", " + locations);
            if(is27) Thread.sleep(1000);
        }
    }

    protected void checkBoxes(int[][] board) throws InterruptedException {
        for(int i=0;i<9;i++){
            checkBox(board,i);
        }
    }

    protected void checkBox(int[][] board, int idx) throws InterruptedException {
        int row=(idx/3)*3;
        int col=(idx%3)*3;
        boolean[] exist= new boolean[10];
        List<Integer> duplicates= new ArrayList<>();
        for(int r=row;r<row+3;r++) {
            for(int c=col;c<col+3;c++){
                int x=board[r][c];
                if(exist[x] && !duplicates.contains(x)) duplicates.add(x);
                exist[x]=true;
            }
        }
        for (int value:duplicates)
        {
            if(!flag) System.out.println("Invalid");
            List<Integer> locations = new ArrayList<>();
            for(int r=row;r<row+3;r++) {
                for(int c=col;c<col+3;c++){
                   if(board[r][c]==value) locations.add(((r%3)*3)+(c%3)+1);
                }
            }
            System.out.println("Box " + (idx+1) + ", #" + value + ", " + locations);
            if(is27) Thread.sleep(1000);
        }
    }

}
