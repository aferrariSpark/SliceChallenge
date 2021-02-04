package com.slice.challenge;

import java.util.List;

public class PizzaBot {

    private Board board;
    private Delivery delivery;

    public PizzaBot(int width, int height) {
        board = new Board(width, height);
        delivery = new Delivery(board);
    }

    /**
     *
     * @param destinations: List of pairs representing the coordinates of the delivery points.
     * @return a String with the output movements.
     */
    public String deliver(List<Pair> destinations) {

        for (Pair destination : destinations) delivery.moveTo(destination);
        return delivery.getPath();
    }
}