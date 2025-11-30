public class CheckerFactory {
    public static SudokuChecker getChecker(int mode) throws Exception {
        switch(mode)
        {
            case 0:
                return new OneThreadChecker();
            case 3:
                return new ThreeThreadChecker();
            case 27:
                return new TwentySevenThreadChecker();
            default:
                throw new Exception("Not a Correct Choice");
        }
    }
}
