package org.example;

import java.util.Scanner;

public class Move {

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

    }

    public void moveLeft() {

    }

    public void moveUp() {

    }

    public void moveDown() {

    }


}
