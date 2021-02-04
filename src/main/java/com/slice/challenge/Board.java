package com.slice.challenge;

public class Board {

    public Board(int width, int height) {
        this.boardWidth = width;
        this.boardHeight = height;
    }

    //Used to store the size of the neighborhood.
    private int boardWidth;
    private int boardHeight;

    //Used to store the current position of the pizza bot.
    private int xPosition = 0;
    private int yPosition = 0;

    public int getBoardWidth() { return boardWidth; }

    public int getBoardHeight() { return boardHeight; }

    public int getXPosition() { return xPosition; }
    public void setXPosition(int xPosition) { this.xPosition = xPosition; }

    public int getYPosition() { return yPosition; }
    public void setYPosition(int yPosition) { this.yPosition = yPosition; }
}
