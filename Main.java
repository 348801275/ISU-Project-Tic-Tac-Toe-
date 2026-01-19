// NAME: Claire Lamanna
import java.util.Scanner;

public class Main {
    // 4. 3x3 Tic Tac Toe Board - Creating the visual of the board with walls and spaces.
    private static void displayGameboard(char[] gameboard) {
        System.out.println(gameboard[0] + " | " + gameboard[1] + " | " + gameboard[2]);
        System.out.println(" - + - + - ");
        System.out.println(gameboard[3] + " | " + gameboard[4] + " | " + gameboard[5]);
        System.out.println(" - + - + - ");
        System.out.println(gameboard[6] + " | " + gameboard[7] + " | " + gameboard[8]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean gameplay = true;

        while (gameplay) {
            // 1-2 Greeting Message/Menu - Introducing the assignment and program, and providing gameplay options
            System.out.println("|| Tic Tac Toe - Final Culminating ||\n\nWelcome to the program!");
            System.out.println("If you would like to play against a player, please enter \"A\". If you would like to play against an AI, please enter \"B\".");
            String status = sc.nextLine().toUpperCase().trim();

            // 4. 3x3 Tic Tac Toe Board (Slots) - Creating an array for each interactive slot on the board.
            char[] boardSlots = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
            int squaresPlayedCounter = 0;
            char currentPlayerTurn = 'x';

            switch (status) {
                case "A":
                    // 3. Player Randomization & Selection - Generating a random first player.
                    System.out.println("Player Vs. Player has been selected. \nGreat choice! Speak with the other player, and declare yourselves as either Player 1 or Player 2.");
                    int firstPlayer = (int) (Math.random() * (2 - 1 + 1) + 1);
                    System.out.println("Player " + firstPlayer + " will be X and has the first turn. The other player will be O.");


                    while (squaresPlayedCounter < 9) {
                        displayGameboard(boardSlots);
                        System.out.println("Current Turn: Player " + currentPlayerTurn + "\nSelect a square to mark your game token: ");
                        int input = sc.nextInt();

                        while (boardSlots[input - 1] == 'x' || boardSlots[input - 1] == 'o') { // Redirecting if chosen slot is occupied.
                            System.out.print("This space is already taken. Please re-select: ");
                            input = sc.nextInt();
                        }

                        boardSlots[input - 1] = currentPlayerTurn; // Marking the token at the chosen board slot.

                        if ((boardSlots[0] + boardSlots[1] + boardSlots[2] == (currentPlayerTurn * 3)) // Row scans
                                || (boardSlots[3] + boardSlots[4] + boardSlots[5] == (currentPlayerTurn * 3))
                                || (boardSlots[6] + boardSlots[7] + boardSlots[8] == (currentPlayerTurn * 3))
                                || (boardSlots[0] + boardSlots[3] + boardSlots[6] == (currentPlayerTurn * 3)) // Column scans
                                || (boardSlots[1] + boardSlots[4] + boardSlots[7] == (currentPlayerTurn * 3))
                                || (boardSlots[2] + boardSlots[5] + boardSlots[8] == (currentPlayerTurn * 3))
                                || (boardSlots[0] + boardSlots[4] + boardSlots[8] == (currentPlayerTurn * 3)) // Diagonal scans
                                || (boardSlots[2] + boardSlots[4] + boardSlots[6] == (currentPlayerTurn * 3))
                        ) {
                            displayGameboard(boardSlots);
                            System.out.println("Player " + currentPlayerTurn + " has won the game!");
                            break;
                        } else {
                            squaresPlayedCounter++;
                            if (currentPlayerTurn == 'x') {
                                currentPlayerTurn = 'o'; // Switching current player token for the next iteration.
                            } else {
                                currentPlayerTurn = 'x';
                            }
                        }
                    }

                    if (squaresPlayedCounter == 9) {
                        displayGameboard(boardSlots);
                        System.out.println("It's a draw!");
                        break;
                    }

                    // 8. Replayability - Making it so that the game is replayable.
                    System.out.println("Would you like to play again? Type Yes/No");
                    sc.nextLine();
                    String answer = sc.nextLine();
                    if (answer.equalsIgnoreCase("yes")) {
                        gameplay = true;
                    } else {
                        gameplay = false;
                    }
                    break;



                case "B":
                    System.out.println("Player Vs. AI has been selected. \nGreat choice! ");
                    System.out.println("You will be X and have the first turn. The AI will be O.");
                    char currentTurn = 'x';
                    boolean AIGame = true;


                    while (AIGame && squaresPlayedCounter < 9) {
                        displayGameboard(boardSlots);

                        System.out.println("Select a square to mark your game token: ");
                        int Userinput = sc.nextInt() - 1;


                        while (boardSlots[Userinput] == 'x' || boardSlots[Userinput] == 'o') {
                            System.out.print("This space is already taken. Please re-select: ");
                            Userinput = sc.nextInt() - 1;
                        }
                        boardSlots[Userinput] = currentTurn;
                        squaresPlayedCounter++;

                        // 8. Play VS. AI Section
                        boolean AIMove = false;


                        // 9. Write the game in a way that AI player will never lose:

                        // Determining if the AI can create a full row.
                        if (boardSlots[0] == 'o' && boardSlots[1] == 'o' && boardSlots[2] != 'x' && boardSlots[2] != 'o') {
                            boardSlots[2] = 'o';
                            AIMove = true;
                        } else if (boardSlots[0] == 'o' && boardSlots[2] == 'o' && boardSlots[1] != 'x' && boardSlots[1] != 'o') {
                            boardSlots[1] = 'o';
                            AIMove = true;
                        } else if (boardSlots[1] == 'o' && boardSlots[2] == 'o' && boardSlots[0] != 'x' && boardSlots[0] != 'o') { //first row
                            boardSlots[0] = 'o';
                            AIMove = true;
                        } else if (boardSlots[3] == 'o' && boardSlots[4] == 'o' && boardSlots[5] != 'x' && boardSlots[5] != 'o') {
                            boardSlots[5] = 'o';
                            AIMove = true;
                        } else if (boardSlots[3] == 'o' && boardSlots[5] == 'o' && boardSlots[4] != 'x' && boardSlots[4] != 'o') {
                            boardSlots[4] = 'o';
                            AIMove = true;
                        } else if (boardSlots[4] == 'o' && boardSlots[5] == 'o' && boardSlots[3] != 'x' && boardSlots[3] != 'o') { //second row
                            boardSlots[3] = 'o';
                            AIMove = true;
                        } else if (boardSlots[6] == 'o' && boardSlots[7] == 'o' && boardSlots[8] != 'x' && boardSlots[8] != 'o') {
                            boardSlots[8] = 'o';
                            AIMove = true;
                        } else if (boardSlots[6] == 'o' && boardSlots[8] == 'o' && boardSlots[7] != 'x' && boardSlots[7] != 'o') {
                            boardSlots[7] = 'o';
                            AIMove = true;
                        } else if (boardSlots[7] == 'o' && boardSlots[8] == 'o' && boardSlots[6] != 'x' && boardSlots[6] != 'o') {  // third row
                            boardSlots[6] = 'o';
                            AIMove = true;
                        } else if (boardSlots[0] == 'o' && boardSlots[3] == 'o' && boardSlots[6] != 'x' && boardSlots[6] != 'o') {
                            boardSlots[6] = 'o';
                            AIMove = true;
                        } else if (boardSlots[0] == 'o' && boardSlots[6] == 'o' && boardSlots[3] != 'x' && boardSlots[3] != 'o') {
                            boardSlots[3] = 'o';
                            AIMove = true;
                        } else if (boardSlots[3] == 'o' && boardSlots[6] == 'o' && boardSlots[0] != 'x' && boardSlots[0] != 'o') { //first column
                            boardSlots[0] = 'o';
                            AIMove = true;
                        } else if (boardSlots[1] == 'o' && boardSlots[4] == 'o' && boardSlots[7] != 'x' && boardSlots[7] != 'o') {
                            boardSlots[7] = 'o';
                            AIMove = true;
                        } else if (boardSlots[1] == 'o' && boardSlots[7] == 'o' && boardSlots[4] != 'x' && boardSlots[4] != 'o') {
                            boardSlots[4] = 'o';
                            AIMove = true;
                        } else if (boardSlots[4] == 'o' && boardSlots[7] == 'o' && boardSlots[1] != 'x' && boardSlots[1] != 'o') { //second column
                            boardSlots[1] = 'o';
                            AIMove = true;
                        } else if (boardSlots[2] == 'o' && boardSlots[5] == 'o' && boardSlots[8] != 'x' && boardSlots[8] != 'o') {
                            boardSlots[8] = 'o';
                            AIMove = true;
                        } else if (boardSlots[2] == 'o' && boardSlots[8] == 'o' && boardSlots[5] != 'x' && boardSlots[5] != 'o') {
                            boardSlots[5] = 'o';
                            AIMove = true;
                        } else if (boardSlots[5] == 'o' && boardSlots[8] == 'o' && boardSlots[2] != 'x' && boardSlots[2] != 'o') { //third column
                            boardSlots[2] = 'o';
                            AIMove = true;
                        } else if (boardSlots[0] == 'o' && boardSlots[4] == 'o' && boardSlots[8] != 'x' && boardSlots[8] != 'o') {
                            boardSlots[8] = 'o';
                            AIMove = true;
                        } else if (boardSlots[0] == 'o' && boardSlots[8] == 'o' && boardSlots[4] != 'x' && boardSlots[4] != 'o') {
                            boardSlots[4] = 'o';
                            AIMove = true;
                        } else if (boardSlots[4] == 'o' && boardSlots[8] == 'o' && boardSlots[0] != 'x' && boardSlots[0] != 'o') { // diagonal1
                            boardSlots[0] = 'o';
                            AIMove = true;
                        } else if (boardSlots[2] == 'o' && boardSlots[4] == 'o' && boardSlots[6] != 'x' && boardSlots[6] != 'o') {
                            boardSlots[6] = 'o';
                            AIMove = true;
                        } else if (boardSlots[2] == 'o' && boardSlots[6] == 'o' && boardSlots[4] != 'x' && boardSlots[4] != 'o') {
                            boardSlots[4] = 'o';
                            AIMove = true;
                        } else if (boardSlots[4] == 'o' && boardSlots[6] == 'o' && boardSlots[2] != 'x' && boardSlots[2] != 'o') {
                            boardSlots[2] = 'o';
                            AIMove = true;


                            // Determining if the AI has to block the player from winning.
                        } else if ((!AIMove && boardSlots[0] == 'x' && boardSlots[1] == 'x' && boardSlots[2] != 'x' && boardSlots[2] != 'o')) {
                            boardSlots[2] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[0] == 'x' && boardSlots[2] == 'x' && boardSlots[1] != 'x' && boardSlots[1] != 'o')) {
                            boardSlots[1] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[1] == 'x' && boardSlots[2] == 'x' && boardSlots[0] != 'x' && boardSlots[0] != 'o')) { // first row prevention
                            boardSlots[0] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[3] == 'x' && boardSlots[4] == 'x' && boardSlots[5] != 'x' && boardSlots[5] != 'o')) {
                            boardSlots[5] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[3] == 'x' && boardSlots[5] == 'x' && boardSlots[4] != 'x' && boardSlots[4] != 'o')) {
                            boardSlots[4] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[4] == 'x' && boardSlots[5] == 'x' && boardSlots[3] != 'x' && boardSlots[3] != 'o')) { //second row prevention
                            boardSlots[3] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[6] == 'x' && boardSlots[7] == 'x' && boardSlots[8] != 'x' && boardSlots[8] != 'o')) {
                            boardSlots[8] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[6] == 'x' && boardSlots[8] == 'x' && boardSlots[7] != 'x' && boardSlots[7] != 'o')) {
                            boardSlots[7] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[7] == 'x' && boardSlots[8] == 'x' && boardSlots[6] != 'x' && boardSlots[6] != 'o')) { //third row prevention
                            boardSlots[6] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[0] == 'x' && boardSlots[3] == 'x' && boardSlots[6] != 'x' && boardSlots[6] != 'o')) {
                            boardSlots[6] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[0] == 'x' && boardSlots[6] == 'x' && boardSlots[3] != 'x' && boardSlots[3] != 'o')) {
                            boardSlots[3] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[3] == 'x' && boardSlots[6] == 'x' && boardSlots[0] != 'x' && boardSlots[0] != 'o')) { //first column prevention
                            boardSlots[0] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[1] == 'x' && boardSlots[4] == 'x' && boardSlots[7] != 'x' && boardSlots[7] != 'o')) {
                            boardSlots[7] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[1] == 'x' && boardSlots[7] == 'x' && boardSlots[4] != 'x' && boardSlots[4] != 'o')) {
                            boardSlots[4] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[4] == 'x' && boardSlots[7] == 'x' && boardSlots[1] != 'x' && boardSlots[1] != 'o')) { //second column prevention
                            boardSlots[1] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[2] == 'x' && boardSlots[5] == 'x' && boardSlots[8] != 'x' && boardSlots[8] != 'o')) {
                            boardSlots[8] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[2] == 'x' && boardSlots[8] == 'x' && boardSlots[5] != 'x' && boardSlots[5] != 'o')) {
                            boardSlots[5] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[5] == 'x' && boardSlots[8] == 'x' && boardSlots[2] != 'x' && boardSlots[2] != 'o')) { //third column prevention
                            boardSlots[2] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[0] == 'x' && boardSlots[4] == 'x' && boardSlots[8] != 'x' && boardSlots[8] != 'o')) {
                            boardSlots[8] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[0] == 'x' && boardSlots[8] == 'x' && boardSlots[4] != 'x' && boardSlots[4] != 'o')) {
                            boardSlots[4] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[4] == 'x' && boardSlots[8] == 'x' && boardSlots[0] != 'x' && boardSlots[0] != 'o')) { //diagonal 1
                            boardSlots[0] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[2] == 'x' && boardSlots[4] == 'x' && boardSlots[6] != 'x' && boardSlots[6] != 'o')) {
                            boardSlots[6] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[2] == 'x' && boardSlots[6] == 'x' && boardSlots[4] != 'x' && boardSlots[4] != 'o')) {
                            boardSlots[4] = 'o';
                            AIMove = true;
                        } else if ((!AIMove && boardSlots[4] == 'x' && boardSlots[6] == 'x' && boardSlots[2] != 'x' && boardSlots[2] != 'o')) { //diagonal 2
                            boardSlots[2] = 'o';
                            AIMove = true;


                            // Placing 'o' in the middle for higher chance of winning on first turn (if it can).
                        } else if (!AIMove && boardSlots[4] != 'x' && boardSlots[4] != 'o') {
                            boardSlots[4] = 'o';
                            AIMove = true;
                        } else if (!AIMove) {
                            int[] corners = {0, 2, 6, 8}; //make an array for the corners
                            for (int i = 0; i < 4 && !AIMove; i++) {
                                if (boardSlots[corners[i]] != 'x' && boardSlots[i] != 'o') {
                                    boardSlots[corners[i]] = 'o';
                                    AIMove = true;
                                }
                            }
                        }

                        // Last Ditch Effort: Fill any other square for a draw.
                        if (!AIMove) {
                            for (int i = 0; i < 9; i++) {
                                if (boardSlots[i] != 'x' && boardSlots[i] != 'o') {
                                    boardSlots[i] = 'o';
                                    AIMove = true;
                                    break;
                                }
                            }
                        }

                        if ((boardSlots[0] + boardSlots[1] + boardSlots[2] == ('o' * 3)) // Row Scan
                                || (boardSlots[3] + boardSlots[4] + boardSlots[5] == ('o' * 3))
                                || (boardSlots[6] + boardSlots[7] + boardSlots[8] == ('o' * 3))
                                || (boardSlots[0] + boardSlots[3] + boardSlots[6] == ('o' * 3)) // Column Scan
                                || (boardSlots[1] + boardSlots[4] + boardSlots[7] == ('o' * 3))
                                || (boardSlots[2] + boardSlots[5] + boardSlots[8] == ('o' * 3))
                                || (boardSlots[0] + boardSlots[4] + boardSlots[8] == ('o' * 3)) // Diagonal Scan
                                || (boardSlots[2] + boardSlots[4] + boardSlots[6] == ('o' * 3))
                        ) {
                            displayGameboard(boardSlots);
                            System.out.println("The AI has won the game!");
                            break;
                        }
                        squaresPlayedCounter++;
                    }
                    if (squaresPlayedCounter == 9) {
                        displayGameboard(boardSlots);
                        System.out.println("It's a draw!");
                    }

                    // 8. Replayability (again)
                    System.out.println("Would you like to play again? [yes/no]");
                    sc.nextLine();
                    String UserAnswer = sc.nextLine();
                    if (UserAnswer.equalsIgnoreCase("yes")) {
                        squaresPlayedCounter = 0;
                        AIGame = true;
                    } else {
                        AIGame = false;
                    }
                    break;

                default:
                    System.out.println("Invalid option. Please re-run the program to try again.");
                    break;
            }
        }
        sc.close();
    }
}
