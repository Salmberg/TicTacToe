public class placeDraw extends TicTacToe {

    public placeDraw(char[][] playingBoard, int pos, String player) {
        super();
    }

    public static void placeYourDraw (char[][] playingBoard, int pos, String user) {

        char symbol = 'X';

        if(user.equals("player")) {
            symbol = 'X';
        } else if(user.equals("cpu")) {
            symbol = 'O';
        }

        switch (pos) {
            case 1 -> playingBoard[0][0] = symbol;
            case 2 -> playingBoard[0][2] = symbol;
            case 3 -> playingBoard[0][4] = symbol;
            case 4 -> playingBoard[2][0] = symbol;
            case 5 -> playingBoard[2][2] = symbol;
            case 6 -> playingBoard[2][4] = symbol;
            case 7 -> playingBoard[4][0] = symbol;
            case 8 -> playingBoard[4][2] = symbol;
            case 9 -> playingBoard[4][4] = symbol;
            default -> {
            }
        }
    }
}
