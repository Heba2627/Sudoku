public class OneThreadChecker extends Checker{
    @Override
    public void verify(int[][] board) throws InterruptedException {
        checkRows(board);
        checkColumns(board);
        checkBoxes(board);
        if(state) System.out.println("Valid");
    }

}
