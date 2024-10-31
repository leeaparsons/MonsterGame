package org.example;

import java.util.Scanner;

public class Move {
    private GameBoard gameBoard;

    public Move(GameBoard gameBoard){
        this.gameBoard = gameBoard;
    }

    public void askDirection() {
        System.out.print("Input direction (up/ down/ left/ right: ");
        Scanner scan = new Scanner(System.in);
        String direction = scan.nextLine();

        if (direction.equals("up")) {
            this.moveUp();
        } else if (direction.equals("down")) {
            this.moveDown();
        } else if (direction.equals("right")) {
            this.moveRight();
        } else if (direction.equals("left")) {
            this.moveLeft();
        }
    }

    public void moveRight() {
        movePlayer(0,1);
    }

    public void moveLeft() {
        movePlayer(0,-1);
    }

    public void moveUp() {
        movePlayer(-1,0);
    }

    public void moveDown() {
        movePlayer(1,0);
    }

    private void movePlayer(int moveX, int moveY) {
        int[] playerLoc = gameBoard.getPlayerLoc();
        int newX = playerLoc[0] + moveX;
        int newY = playerLoc[1] + moveY;

        // checks new position is within the boundaries
        if (newX >= 0 && newX < gameBoard.getHeight() && newY >= 0 && newY < gameBoard.getWidth()) {
            gameBoard.setPlayerLoc(newX, newY);
            System.out.println("You moved to [" + newX + ", " + newY + "].");
        } else {
            System.out.println("You can't move there.");
        }
    }
}
