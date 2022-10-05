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


            Scanner sc = new Scanner(System.in);   //Denna låter använder skriva in ett namn och "setta" det.
            System.out.println("Player 1 (X), enter your name: ");
            Player p1 = new Player();
            p1.setName(sc.nextLine()); //Denna låter användaren "setta" namnet.
            p1.setId("X"); // Denna "settar" id 1 till "X". Detta sätter vi och inte användaren.
            System.out.println("Player 2 (O), enter your name: ");
            Player p2 = new Player();
            p2.setName(sc.nextLine());
            p2.setId("O");


            board.printOutPlayingBoard(); //This one is calling in the method "PrintOutPlayingBoard"


            boolean exitWhileLoop = false; //Denna bool är false by default

            while (!exitWhileLoop) {


                board.placeYourDraw(p1);// Prints out the playingboard + the chosen position of "X".
                board.printOutPlayingBoard();

                String result = board.checkWinner(p1.name, p2.name);


                if (result.length() > 0) { //Om detta är sant så sätts boolen till true och då ska while-loopen sluta
                    System.out.println(result);
                    break;
                }

                //----------------------------------------------------//

                board.placeYourDraw(p2); //Prints out the playingboard + the position of "O".
                board.printOutPlayingBoard();

                result = board.checkWinner(p1.name, p2.name);


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

    public static int getValidPosition(Scanner sc, String player) { //Denna metod tar in en scanner och kollar om player har skrivit in rätt symbol (1-9)
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
