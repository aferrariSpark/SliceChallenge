package com.slice.challenge;

public class RangeValidator {

    private Board board;

    public RangeValidator(Board board) {
        this.board = board;
    }

    /**
     *
     * @param destination: The destination coordinate.
     * @param axis: The axis on witch the movement is to be done.
     * @return true if the destination coordinate is valid, false otherwise.
     */
    public boolean isDestinationValid(int destination, Axis axis) {
        switch (axis) {
            case X_AXIS:
                return destination >= 0 && destination <= board.getBoardWidth();
            case Y_AXIS:
                return destination >= 0 && destination <= board.getBoardHeight();
            default:
                return true;
        }
    }
}
