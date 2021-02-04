package com.slice.challenge;

public class Delivery {

    private Board board;
    private RangeValidator rangeValidator;

    //Used to store the output instructions.
    private StringBuilder output = new StringBuilder();

    public Delivery (Board board) {
        this.board = board;
        rangeValidator = new RangeValidator(board);
    }

    /**
     *
     * @param destination: A pair representing an (X,Y) coordinate.
     */
    public void moveTo(Pair destination) {
        int xDestinationCoordinate = destination.getXCoordinate();
        int yDestinationCoordinate = destination.getYCoordinate();

        //Check if the bot is already at the current position.
        if(shouldDropPizza(xDestinationCoordinate, yDestinationCoordinate))
            output.append(dropPizza());
        else {
            moveOnAxis(xDestinationCoordinate, Axis.X_AXIS);
            moveOnAxis(yDestinationCoordinate, Axis.Y_AXIS);

            //Drop the pizza after moving.
            output.append(dropPizza());
        }
    }

    /**
     *
     * @param xDestination: the x coordinate of the destination position.
     * @param yDestination: the y coordinate of the destination position.
     * @return true if the bot is already at the destination position, false otherwise.
     */
    public boolean shouldDropPizza(int xDestination, int yDestination) {
        return xDestination == board.getXPosition() && yDestination == board.getYPosition();
    }

    /**
     *
     * @return "D" to indicate a pizza was dropped.
     */
    private String dropPizza() {
        return "D";
    }

    /**
     *
     * @param destination: The position on the axis to move to.
     * @param axis: The axis where the movement is to be done.
     */
    private void moveOnAxis(int destination, Axis axis) {

        //If the destination coordinate is not valid log an error and terminate execution.
        if(!rangeValidator.isDestinationValid(destination, axis)) {
            System.out.println("Coordinate " + destination + " on axis " + axis + " is not a valid coordinate. Terminate.");
            System.exit(-1);
        }

        //If not already at the destination position on the axis, move.
        if(!isAlreadyAtCurrentPosition(destination, axis)) {
            switch (axis) {
                case X_AXIS: {
                    if(destination > board.getXPosition())
                        moveEast(destination);
                    else
                        moveWest(destination);

                    break;

                }
                case Y_AXIS: {
                    if(destination > board.getYPosition())
                        moveNorth(destination);
                    else
                        moveSouth(destination);

                    break;
                }
            }
        }
    }

    /**
     *
     * @param destination: The destination coordinate.
     * @param axis: The axis on witch the movement is to be done.
     * @return true if the bot is already at the destination, false otherwise.
     */
    public boolean isAlreadyAtCurrentPosition(int destination, Axis axis) {
        switch (axis) {
            case X_AXIS:
                return destination == board.getXPosition();
            case Y_AXIS:
                return destination == board.getYPosition();
            default:
                return true;
        }
    }

    /**
     *
     * @param destination: Destination position.
     */
    private void moveSouth(int destination) {
        while(board.getYPosition() > destination) {
            board.setYPosition(board.getYPosition() - 1);
            output.append("S");
        }
    }

    /**
     *
     * @param destination: Destination position.
     */
    private void moveNorth(int destination) {
        while(board.getYPosition() < destination) {
            board.setYPosition(board.getYPosition() + 1);
            output.append("N");
        }
    }

    /**
     *
     * @param destination: Destination position.
     */
    private void moveEast(int destination) {
        while(board.getXPosition() < destination) {
            board.setXPosition(board.getXPosition() + 1);
            output.append("E");
        }
    }

    /**
     *
     * @param destination: Destination position.
     */
    private void moveWest(int destination) {
        while(board.getXPosition() > destination) {
            board.setXPosition(board.getXPosition() - 1);
            output.append("W");
        }
    }

    public String getPath() {
        return output.toString();
    }
}
