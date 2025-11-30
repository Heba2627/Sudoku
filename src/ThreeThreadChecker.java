public class ThreeThreadChecker extends Checker {
    @Override
    public void verify(int[][] board) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                checkRows(board);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                checkColumns(board);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                checkBoxes(board);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start(); Thread.sleep(1000);  t1.join();
        t2.start(); Thread.sleep(1000); t2.join();
        t3.start(); Thread.sleep(1000); t3.join();
        if(state) System.out.println("Valid");
    }

}
