import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {

    static Board board = new Board();

    public static void main(String[] args) {

        boolean whileRunning = true;
        while (whileRunning) {

            System.out.println("Welcome to this Tic Tac Toe Game!");
            System.out.println("<===============================>");
            System.out.println("The rules are simple:");
            System.out.println("1.The game is played on a grid that's 3 squares by 3 squares.");
            System.out.println("2.Player one is X, player two is is O. Players take turns putting their marks in empty squares (1-9)");
            System.out.println("3.The first player to get 3 of her marks in a row (up, down, across, or diagonally) is the winner.");
            System.out.println("4.When all 9 squares are full, the game is over. If no player has 3 marks in a row, the game ends in a tie.");
            System.out.println("<===============================>");


            Scanner sc = new Scanner(System.in);
            System.out.println("Player 1 (X), enter your name: ");
            String p1 = sc.nextLine();
            System.out.println("Player 2 (O), enter your name: ");
            String p2 = sc.nextLine();


            board.printOutPlayingBoard(); //This one is calling in the method "PrintOutPlayingBoard"


            boolean exitWhileLoop = false; //Denna bool är false by default

            while (!exitWhileLoop) {

                //System.out.print(player + " make your draw (1-9):");
                //Här vill jag ha en while loop som kör så länge pos är invalid och positionen är upptagen.
                int pos1 = getValidPosition(sc, p1); //kallar på metoden getValidPosition


                System.out.println(pos1);

                board.placeYourDraw(pos1, "player1");// Prints out the playingboard + the chosen position of "X".
                board.printOutPlayingBoard();

                String result = board.checkWinner(p1, p2);


                if (result.length() > 0) { //Om detta är sant så sätts boolen till true och då ska while-loopen sluta
                    System.out.println(result);
                    break;
                }

                //----------------------------------------------------//


                int pos2 = getValidPosition(sc, p2);

                System.out.println(pos2);

                board.placeYourDraw(pos2, "player2"); //Prints out the playingboard + the position of "O".
                board.printOutPlayingBoard();

                result = board.checkWinner(p1, p2);


                if (result.length() > 0) {
                    System.out.println(result);
                    break;
                }
            }
            board.clearBoard();
            System.out.println("Press Enter to play again!");
            sc.nextLine();
        }
    }

    private static int getValidPosition(Scanner sc, String player) { //Denna metod tar in en scanner och kollar om player har skrivit in rätt symbol (1-9)
        boolean whileInvalid = true;
       int pos = 0;

        System.out.print(player + " make your draw (1-9):");
        while (whileInvalid) {
            String pos1candidate = sc.nextLine(); //Input of player 1 move

            try {
                pos = Integer.parseInt(pos1candidate);
                break;

            } catch (NumberFormatException e) {

                System.out.println("Invalid Symbol, try again! (1-9):");
            }
        }
        return pos;
    }
}
