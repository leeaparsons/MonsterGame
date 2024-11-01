package org.example;

import java.util.Scanner;

public class Greeting {
    private String name;
    private static int gridNumber = 5;
    private static GameBoard gameBoard;

    // Print welcome function and ask users for name and grid number.
    public void welcome() {
        System.out.println("Welcome!! This is a Text-based Grid Game:)");
        System.out.print("What's your name? ");
        Scanner scan = new Scanner(System.in);
        this.setName(scan.nextLine());

        System.out.println("Nice to meet you, " + name + ". You will need to find the treasure, and avoid the monsters on the way. ");

        selectBoardSize();
        initialiseGame(); // sets player, treasure & location
        startGame();
    }

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
    private void selectBoardSize() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Select the board size:");
        System.out.println("1. 5x5");
        System.out.println("2. 10x10");
        System.out.println("3. 15x15");

        int choice = scan.nextInt();
        scan.nextLine();

        switch (choice) {
            case 1:
                System.out.println("You Chose a 5 x 5 board!");
                break;
            case 2:
                this.setGridNumber(10);
                System.out.println("You Chose a 10 x 10 board!");
                break;
            case 3:
                setGridNumber(15);
                System.out.println("You Chose a 15 x 15 board!");
                break;
            default:
                System.out.println("Invalid choice. Defaulting to 5x5.");
        }
    }

    private static void initialiseGame() {
        gameBoard = new GameBoard(gridNumber,gridNumber);
        gameBoard.setPlayerLoc(genRanNum(gridNumber), genRanNum(gridNumber)); // currently fixed locations for player, treasure & monster
        gameBoard.setTreasureLoc(genRanNum(gridNumber), genRanNum(gridNumber));
        gameBoard.setMonsterLoc(genRanNum(gridNumber), genRanNum(gridNumber));
        gameBoard.printBoard();
    }

    private static void startGame() {
        Move move = new Move(gameBoard);
        boolean isRunning = true;
        while (isRunning) {
            String command = move.askDirection();
            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                isRunning = false;
            }
        }
    }

    public static int genRanNum(int gridNumber) {
        return (int) (Math.random() * gridNumber);
    }
}
