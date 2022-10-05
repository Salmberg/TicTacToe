import java.util.*;

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


    public void printOutPlayingBoard() { //This for loop prints out the playingboard
        for (char[] row : playingBoard) {
            for (char col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }

    public char getPosition(int selectPos) {
        switch (selectPos) {
            case 1 -> {
                return playingBoard[0][0];
            }
            case 2 -> {
                return playingBoard[0][2];
            }
            case 3 -> {
                return playingBoard[0][4];
            }
            case 4 -> {
                return playingBoard[2][0];
            }
            case 5 -> {
                return playingBoard[2][2];
            }
            case 6 -> {
                return playingBoard[2][4];
            }
            case 7 -> {
                return playingBoard[4][0];
            }
            case 8 -> {
                return playingBoard[4][2];
            }
            case 9 -> {
                return playingBoard[4][4];
            }
            default -> {
                return 0;
            }
        }
    }

    public void placeYourDraw(Player player) { //This is the method that lets the player place their "X" or "O".

        Scanner sc = new Scanner(System.in);
        char symbol = ' ';
        int cpuPos;
        
        if (player.id.equals("X")) {
            symbol = 'X';
        } else if (player.id.equals("O")) {
            symbol = 'O';
        }
        
        boolean isOccupide = true;
        while (isOccupide) {

            if (Objects.equals(player.name, "Cpu")) {
                Random random = new Random();
                cpuPos = random.nextInt(10);
                System.out.println(player.name + " make your draw (1-9):");


                char getCurrentPositionChar = getPosition(cpuPos); //Kollar om positionen är tom
                if (Character.toString(getCurrentPositionChar).equals(" ")) { //Om den är tom går det att placera in X/O

                    //Lägger till X/O
                    if (player.id.equals("X")) {
                        p1Pos.add(cpuPos);
                    } else if (player.id.equals("O")) {
                        p2Pos.add(cpuPos);
                    }

                    //Placerar in X/O på respektive plats
                    switch (cpuPos) {
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
                    break;
                } else {
                    System.out.println("Already taken, try again!:");

                }
            }
            else {
                int position = TicTacToe.getValidPosition(sc, player.name); //Verifierar att användaren skriver in en siffra.
                char getCurrentPositionChar = getPosition(position); //Kollar om positionen är tom
                if (Character.toString(getCurrentPositionChar).equals(" ")) { //Om den är tom går det att placera in X/O

                    //Lägger till X/O
                    if (player.id.equals("X")) {
                        p1Pos.add(position);
                    } else if (player.id.equals("O")) {
                        p2Pos.add(position);
                    }

                    //Placerar in X/O på respektive plats
                    switch (position) {
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
                    break;
                } else {
                    System.out.println("Already taken, try again!:");

                }
                
            }

            
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




