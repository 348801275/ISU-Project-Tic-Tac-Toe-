# ISU-Project-Tic-Tac-Toe-
By: Claire Lamanna

Part 1: Main Variable Descriptions

Variables:
status - Contains the user’s choice to play against an AI or a player (A/B).
squaresPlayedCounter - Records the number of occupied slots. Used to automatically end the game if a draw occurs. 
currentPlayerTurn - Contains the game token of the current player. Used to track turns and place marks on slots.
currentTurn - Serves the same purpose as currentPlayerTurn, but is designed specifically for the AI section.
firstPlayer - Contains a randomly generated number between 1-2. Used to randomly select a player to go first and be represented as ‘x’. 
input - Contains the user’s chosen slot to occupy with their game token. 
gameplay - Creates a game loop that allows for replayability across both game options (but mainly controls player mode).
AIGame - Creates a game loop that allows for replayability across the AI game option.
AIMove - Acts as a tracker for the AI's moves, and updates depending on its ability/need to move at a given turn. 
answer - Contains the users response to either replay the game or to exit permanently. 
userResponse - Serves the same purpose as answer, but is designed specifically for the AI section. 
i - Used for indexing and checking process related to the AI's decision making. 

Arrays:
boardSlots - Contains integer numbers 1-9 to represent the gameboard slots. Used to place the game tokens on the gameboard. 
gameboard - Contains integer numbers 1-8 to help create the gameboard structuring, display, and positioning in the gameboard display.
corners - Contains the corner positions on the board for AI movement purposes.

Static Methods:
displayGameboard - Contains the gameboard structure, display, and visualization. 
main - Contains the main code and program. 


Part 2: Logic/Structure Explanation

For this assignment, I designed this program to flow with chronological order and priority. Each block of code is designed with a rubric aspect in mind and structured in order of appearance and process. It begins with an introduction, finishes with potential conclusions, and includes a lengthy process of gameplay and processing between those spaces. The exception to this is the development of the Tic Tac Toe board towards the beginning of the program. Overall, it is optimized for readability and functions through a combination of user inputs and processing.
