package com.slice.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MainClass {

    public static void main(String[] args) {
        PizzaBot bot = null;

        try {
            String boardSize = args[0];
            StringTokenizer boardSizeTokenizer = new StringTokenizer(boardSize, "x");
            int boardWidth = Integer.parseInt(boardSizeTokenizer.nextToken());
            int boardHeight = Integer.parseInt(boardSizeTokenizer.nextToken());
            bot = new PizzaBot(boardWidth, boardHeight);
        } catch (Exception e) {
            System.out.println("Error while parsing board dimension input. Terminate.");
            System.exit(-1);
        }

        List<Pair> directions = new ArrayList<>();
        try {
            for (int i = 1; i < args.length; i+= 2) {
                String xCoordinate = args[i].replace("(", "").replace(",", "").trim();
                String yCoordinate = args[i + 1].replace(")", "").replace(",", "").trim();
                Pair pair = new Pair(Integer.parseInt(xCoordinate), Integer.parseInt(yCoordinate));
                directions.add(pair);
            }
        } catch (Exception e) {
            System.out.println("Error while parsing instructions input. Terminate.");
            System.exit(-1);
        }


        System.out.println(bot.deliver(directions));
    }
}
