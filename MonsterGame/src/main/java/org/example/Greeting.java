package org.example;

import java.util.Scanner;

public class Greeting {
    private String name;
    private int gridNumber;

    // Print welcome function and ask users for name and grid number.
    public void welcome() {
        System.out.println("Welcome!! This is a Text-based Grid Game:)");
        System.out.print("What's your name? ");
        Scanner scan = new Scanner(System.in);
        this.setName(scan.nextLine());

        System.out.println("Nice to meet you, " + name + ". You will need to find the treasure, and avoid the monsters on the way. ");

        System.out.print("How many grids do you want? (e.g. input '3' for 3x3) ");
        this.setGridNumber(scan.nextInt());
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getGridNumber() {
        return gridNumber;
    }

    public void setGridNumber(int gridNumber) {
        this.gridNumber = gridNumber;
    }

    public void setName(String name) {
        this.name = name;
    }


}
