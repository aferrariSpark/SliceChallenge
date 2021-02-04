package com.slice.challenge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.validation.Validator;

import static org.junit.jupiter.api.Assertions.*;

class RangeValidatorTest {

    Board board;
    RangeValidator validator;

    @BeforeEach
    void init() {
        board = new Board(5,5);
        validator = new RangeValidator(board);
    }

    @Test
    void isDestinationValidSuccessTest() {
        Assertions.assertTrue(validator.isDestinationValid(3, Axis.X_AXIS));
    }

    @Test
    void isDestinationValidErrorTest() {
        Assertions.assertFalse(validator.isDestinationValid(6, Axis.Y_AXIS));
    }
}