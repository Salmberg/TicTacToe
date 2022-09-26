import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        System.out.println("Welcome to this Tic Tac Toe Game!");



        char[][] playingBoard = {{' ', '|', ' ', '|', ' '}, //This is the playingboard
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printPlayingBoard.printOutPlayingBoard(playingBoard); //This one is calling in the method "PrintOutPlayingBoard"

        Scanner sc = new Scanner(System.in);
        System.out.print("Make your draw (1-9)");
        int pos = sc.nextInt();

        placeDraw.placeYourDraw(playingBoard, pos, "player");

        printPlayingBoard.printOutPlayingBoard(playingBoard);

    }
}
