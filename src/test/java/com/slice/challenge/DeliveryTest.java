package com.slice.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryTest {

    Board board;
    Delivery delivery;

    @BeforeEach
    void init() {
        board = new Board(5,5);
        delivery = new Delivery(board);
    }

    @Test
    void moveTo() {
        //Check initial position
        Assertions.assertEquals(0, board.getXPosition());
        Assertions.assertEquals(0, board.getYPosition());

        //Move North
        Pair northCoordinates = new Pair(0,3);
        delivery.moveTo(northCoordinates);
        Assertions.assertEquals(0, board.getXPosition());
        Assertions.assertEquals(3, board.getYPosition());

        //Move East
        Pair eastCoordinates = new Pair(4,3);
        delivery.moveTo(eastCoordinates);
        Assertions.assertEquals(4, board.getXPosition());
        Assertions.assertEquals(3, board.getYPosition());

        //Move South
        Pair southCoordinates = new Pair(4,1);
        delivery.moveTo(southCoordinates);
        Assertions.assertEquals(4, board.getXPosition());
        Assertions.assertEquals(1, board.getYPosition());

        //Move West
        Pair westCoordinates = new Pair(1,1);
        delivery.moveTo(westCoordinates);
        Assertions.assertEquals(1, board.getXPosition());
        Assertions.assertEquals(1, board.getYPosition());
    }

    @Test
    void shouldDropPizzaSuccess() {
        Pair coordinates = new Pair(4,1);
        delivery.moveTo(coordinates);
        Assertions.assertTrue(delivery.shouldDropPizza(4,1));
    }

    @Test
    void shouldDropPizzaError() {
        Pair coordinates = new Pair(4,1);
        delivery.moveTo(coordinates);
        Assertions.assertFalse(delivery.shouldDropPizza(0,1));
    }

    @Test
    void isAlreadyAtCurrentPositionSuccess() {
        Pair coordinates = new Pair(4,1);
        delivery.moveTo(coordinates);
        Assertions.assertTrue(delivery.isAlreadyAtCurrentPosition(4, Axis.X_AXIS));
        Assertions.assertTrue(delivery.isAlreadyAtCurrentPosition(1, Axis.Y_AXIS));
    }

    @Test
    void isAlreadyAtCurrentPositionError() {
        Pair coordinates = new Pair(4,1);
        delivery.moveTo(coordinates);
        Assertions.assertFalse(delivery.isAlreadyAtCurrentPosition(0, Axis.X_AXIS));
        Assertions.assertFalse(delivery.isAlreadyAtCurrentPosition(0, Axis.Y_AXIS));
    }

    @Test
    void getPath() {
        Pair coordinates = new Pair(4,1);
        delivery.moveTo(coordinates);
        Assertions.assertEquals("EEEEND", delivery.getPath());
    }
}