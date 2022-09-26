public class printPlayingBoard extends TicTacToe {


    public printPlayingBoard(char[][] playingBoard) {
        super();
    }

    public static void printOutPlayingBoard(char[][] playingBoard) { //This for loop prints out the playingboard
        for (char[] row : playingBoard) {
            for (char col : row) {
                System.out.print(col);

            }
            System.out.println();
        }
    }

}
