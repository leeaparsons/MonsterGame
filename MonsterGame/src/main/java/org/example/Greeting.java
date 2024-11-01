package org.example;

import java.util.Scanner;

import static org.example.Monster.printMonster;

public class Greeting {
    private String name;
    private static int gridNumber = 5;
    private static GameBoard gameBoard;
    private static boolean[][] occupiedPositions;

    // Print welcome function and ask users for name and grid number.
    public void welcome() {
        System.out.println("Welcome!! This is a Text-based Grid Game:)");
        System.out.print("What's your name? ");
        Scanner scan = new Scanner(System.in);
        this.setName(scan.nextLine());
        System.out.println();
        System.out.println("Nice to meet you, " + name + ".");
        System.out.println("You will need to find the treasure, and avoid the monsters on the way. ");

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

        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.print("Select the board size: ");

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
        occupiedPositions = new boolean[gridNumber][gridNumber];
        int[] location1 = genLocation();
        int[] location2 = genLocation();
        int[] location3 = genLocation();

        gameBoard.setPlayerLoc(location1[0], location1[1]);
        gameBoard.setTreasureLoc(location2[0], location2[1]);
        gameBoard.setMonsterLoc(location3[0], location3[1]);

        //System.out.println("Player location" + gameBoard.getPlayerLoc()[0] + gameBoard.getPlayerLoc()[1]);
        System.out.println("Monster location" + gameBoard.getMonsterLoc()[0] + gameBoard.getMonsterLoc()[1]);
        //System.out.println("treasure location" + gameBoard.getTreasureLoc()[0] + gameBoard.getTreasureLoc()[1]);
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

    private static int[] genLocation() {
        int x, y;
        do {
            x = genRanNum(gridNumber);
            y = genRanNum(gridNumber);
        } while (occupiedPositions[x][y]);
        occupiedPositions[x][y] = true;
        return new int[]{x, y};
    }
    public static int genRanNum(int gridNumber) {
        return (int) (Math.random() * gridNumber);
    }
}
