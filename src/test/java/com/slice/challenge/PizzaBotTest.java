package com.slice.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PizzaBotTest {

    PizzaBot pizzaBot;

    @BeforeEach
    void init() {
        pizzaBot = new PizzaBot(5, 5);
    }

    @Test
    void deliver() {
        List<Pair> instructions = new ArrayList();
        instructions.add(new Pair(0,0));
        instructions.add(new Pair(1,3));
        instructions.add(new Pair(4,4));
        instructions.add(new Pair(4,2));
        instructions.add(new Pair(4,2));
        instructions.add(new Pair(0,1));
        instructions.add(new Pair(3,2));
        instructions.add(new Pair(2,3));
        instructions.add(new Pair(4,1));
        Assertions.assertEquals("DENNNDEEENDSSDDWWWWSDEEENDWNDEESSD", pizzaBot.deliver(instructions));
    }
}