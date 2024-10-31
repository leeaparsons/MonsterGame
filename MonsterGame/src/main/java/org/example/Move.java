package org.example;

import java.util.Scanner;

public class Move {
    private GameBoard gameBoard;

    public Move(GameBoard gameBoard){
        this.gameBoard = gameBoard;
    }

    public void askDirection() {
        Scanner scan = new Scanner(System.in);
        String direction; // CHECK
        boolean validDirection = false;

        while(!validDirection) {
            System.out.print("Input direction (up/ down/ left/ right: ");
            direction = scan.nextLine().toLowerCase();

            switch (direction) {
                case "up":
                    this.moveUp();
                    validDirection = true;
                    break;
                case "down":
                    this.moveDown();
                    validDirection = true;
                    break;
                case "left":
                    this.moveLeft();
                    validDirection = true;
                    break;
                case "right":
                    this.moveRight();
                    validDirection = true;
                    break;
                default:
                    System.out.println("Invalid direction. Please enter up, down, left, or right.");
                    break;
            }
        }
        gameBoard.printBoard();
        checkMonster(); // checks is player landed on the monster
        checkTreasure(); // checks is player landed on the monster
    }

    public void moveRight() {
        movePlayer(0, 1);
    }

    public void moveLeft() {
        movePlayer(0, -1);
    }

    public void moveUp() {
        movePlayer(-1, 0);
    }

    public void moveDown() {
        movePlayer(1, 0);
    }

    private void movePlayer(int moveX, int moveY) {
        int[] playerLoc = gameBoard.getPlayerLoc();
        int newX = playerLoc[0] + moveX;
        int newY = playerLoc[1] + moveY;

        // checks new position is within the board boundaries
        if (newX >= 0 && newX < gameBoard.getHeight() && newY >= 0 && newY < gameBoard.getWidth()) {
            gameBoard.setPlayerLoc(newX, newY);
            System.out.println("You moved to [" + newX + ", " + newY + "].");
        } else {
            System.out.println("You can't move there.");
        }
    }


    // new code
    private void checkMonster() {
        int[] playerLoc = gameBoard.getPlayerLoc();
        int[] monsterLoc = gameBoard.getMonsterLoc();

        if (playerLoc[0] == monsterLoc[0] && playerLoc[1] == monsterLoc[1]) {
            System.out.println("Oh no! You've sat on the monster! Game Over.");
            System.exit(0); // exit the game
        }
    }

    // new code
    private void checkTreasure(){
        int[] playerLoc = gameBoard.getPlayerLoc();
        int[] treasureLoc = gameBoard.getTreasureLoc();

        if (playerLoc[0] == treasureLoc[0] && playerLoc[1] == treasureLoc[1]) {
            System.out.println("Well done. You found the treasure! YOU WIN!");
            System.exit(0); // exit the game
        }
    }
}
