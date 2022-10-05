import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    public ArrayList<Integer> p1Pos = new ArrayList<>();
    public ArrayList<Integer> p2Pos = new ArrayList<>();

    public char[][] playingBoard = fillPlayingBoard();

    public char[][] fillPlayingBoard() {
        return new char[][]{{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
    }


    public static void printOutPlayingBoard(char[][] playingBoard) { //This for loop prints out the playingboard
        for (char[] row : playingBoard) {
            for (char col : row) {
                System.out.print(col);

            }
            System.out.println();
        }
    }

    public void placeYourDraw(int pos, String user) { //This is the method that lets the player place their "X" or "O".

        char symbol = ' ';
        char getCurrentPositionChar = getPosition(pos);


        if (user.equals("player1")) {
            symbol = 'X';
        } else if (user.equals("player2")) {
            symbol = 'O';
        }
        if (Character.toString(getCurrentPositionChar).equals(" ")) { //Om den är tom går det att placera in X/O

            //Lägger till X/O
            if (user.equals("player1")) {
                p1Pos.add(pos);
            } else if (user.equals("player2")) {
                p2Pos.add(pos);
            }

            //Placerar in X/O på respektive plats
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
        } else {
            System.out.println("Already taken, try again!:");//return false/true
        }
    }


    public String checkWinner(String p1, String p2) {
        List firstRow = Arrays.asList(1, 2, 3);
        List secondRow = Arrays.asList(4, 5, 6);
        List thirdRow = Arrays.asList(7, 8, 9);
        List firstCol = Arrays.asList(1, 4, 7);
        List secondCol = Arrays.asList(2, 5, 8);
        List thirdCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(3, 5, 7);

        List<List> winning = new ArrayList<List>();
        winning.add(firstRow);
        winning.add(secondRow);
        winning.add(thirdRow);
        winning.add(firstCol);
        winning.add(secondCol);
        winning.add(thirdCol);
        winning.add(cross1);
        winning.add(cross2);

//        System.out.println("WiningList:: " + winning);
        // System.out.println("Play 1 positions:: " + p1Pos);
        // System.out.println("Play 2 positions:: " + p2Pos);


        for (List l : winning) {
//            System.out.println("List:: " + winning);

            if (p1Pos.containsAll(l)) {
                return p1 + " you  won!";
            } else if (p2Pos.containsAll(l)) {
                return p2 + " you won!";
            }
        }
        if (p1Pos.size() + p2Pos.size() == 9) {
            return "Its a tie!";
        }
        return "";
    }

    public void clearBoard() {
        p1Pos.clear();
        p2Pos.clear();
        playingBoard = fillPlayingBoard();

    }
}




