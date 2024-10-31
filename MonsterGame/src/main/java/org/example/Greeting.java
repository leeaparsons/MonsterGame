package org.example;

import java.util.Scanner;

public class Greeting {
    private String name;
    private int gridNumber;
    private static GameBoard gameBoard;

    // Print welcome function and ask users for name and board size.
    public void welcome() {
        System.out.println("Welcome!! This is a Text-based Grid Game:)");
        System.out.print("What's your name? ");
        Scanner scan = new Scanner(System.in);
        this.setName(scan.nextLine());

        System.out.println("Nice to meet you, " + name + ". You will need to find the treasure, and avoid the monsters on the way. ");

//        System.out.print("How many grids do you want? (e.g. input '3' for 3x3) ");
//        this.setGridNumber(scan.nextInt());
        selectBoardSize();
        //initialiseGame();
        startGame();
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

    // can move selectBoardSize elsewhere if necessary
    private static void selectBoardSize() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Select the board size:");
        System.out.println("1. 5x5");
        System.out.println("2. 10x10");
        System.out.println("3. 15x15");

        int choice = scan.nextInt();
        scan.nextLine();

        switch (choice) {
            case 1:
                gameBoard = new GameBoard(5, 5);
                System.out.println("You Chose a 5 x 5 board!");
                break;
            case 2:
                gameBoard = new GameBoard(10, 10);
                System.out.println("You Chose a 10 x 10 board!");
                break;
            case 3:
                gameBoard = new GameBoard(15, 15);
                System.out.println("You Chose a 15 x 15 board!");
                break;
            default:
                System.out.println("Invalid choice. Defaulting to 5x5.");
                gameBoard = new GameBoard(5, 5);
        }
        initialiseGame(); // sets player, treasure & location
    }

    private static void initialiseGame() {
        gameBoard.setPlayerLoc(0, 0); // currently fixed locations for player, treasure & monster
        gameBoard.setTreasureLoc(2, 2);
        gameBoard.setMonsterLoc(3, 3);
        gameBoard.printBoard();
    }

    private static void startGame() {
        Move move = new Move(gameBoard);
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.print("Enter command (move/exit): ");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("move")) {
                move.askDirection();
            } else if (command.equalsIgnoreCase("exit")) {
                System.out.println("Thanks for playing!");
                isRunning = false;
            } else {
                System.out.println("Invalid command.");
            }
        }
    }
}