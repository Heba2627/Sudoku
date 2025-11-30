public class TwentySevenThreadChecker extends Checker{
    TwentySevenThreadChecker() {
        super.is27=true;
    }
    @Override
    public void verify(int[][] board) throws InterruptedException {
        Thread[] threads = new Thread[27];

        int idx = 0;
        for (int i = 0; i < 9; i++) {
            int row = i;
            threads[idx++] = new Thread(() -> {
                try {
                    checkRow(board, row);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        for (int i = 0; i < 9; i++) {
            int col = i;
            threads[idx++] = new Thread(() -> {
                try {
                    checkColumn(board, col);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        for (int i = 0; i < 9; i++) {
            int box = i;
            threads[idx++] = new Thread(() -> {
                try {
                    checkBox(board, box);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        for (Thread t : threads){ t.start();   t.join();}
        if(state) System.out.println("Valid");
    }

}
