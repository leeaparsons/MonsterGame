package org.example;

public class Player {

    private String name;
    private int score;

    public Player() {
        this.name = "User";
        this.score = 0;
    }

    public Player(String name, int score) {
        this.name;
        this.score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    // display
    public void displayPlayer() {
        System.out.println("Player Name: " + name);
        System.out.println("Score: " + score);
    }
}