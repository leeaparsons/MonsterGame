package org.example;

public class GameBoard {
    private int width;
    private int height;
    private int[] treasureLoc = new int[2];
    private int[] playerLoc = new int[2];
    private int[] monsterLoc = new int[2];

    public GameBoard(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[] getPlayerLoc() {
        return playerLoc;
    }

    public void setPlayerLoc(int x, int y) {
        this.playerLoc[0] = x;
        this.playerLoc[1] = y;
    }

    public int[] getTreasureLoc() {
        return treasureLoc;
    }

    public void setTreasureLoc(int x, int y) {
        this.treasureLoc[0] = x;
        this.treasureLoc[1] = y;
    }

    public int[] getMonsterLoc() {
        return monsterLoc;
    }

    public void setMonsterLoc(int x, int y) {
        this.monsterLoc[0] = x;
        this.monsterLoc[1] = y;
    }
}