package com.slice.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class MainClass {

    public static void main(String[] args) {
        PizzaBot bot = null;

        if(checkBoardSize(args[0])) {
            StringTokenizer boardSizeTokenizer = new StringTokenizer(args[0], "x");
            int boardWidth = Integer.parseInt(boardSizeTokenizer.nextToken());
            int boardHeight = Integer.parseInt(boardSizeTokenizer.nextToken());
            bot = new PizzaBot(boardWidth, boardHeight);
        } else {
            System.out.println("Incorrect board size input format. Terminate.");
            System.exit(-1);
        }

        List<Pair> directions = new ArrayList<>();
        for (int i = 1; i < args.length; i+= 2) {
            if(checkDirection(args[i] + args[i + 1])) {
                String xCoordinate = args[i].replace("(", "").replace(",", "").trim();
                String yCoordinate = args[i + 1].replace(")", "").replace(",", "").trim();
                Pair pair = new Pair(Integer.parseInt(xCoordinate), Integer.parseInt(yCoordinate));
                directions.add(pair);
            } else {
                System.out.println("Incorrect instruction format: " + args[i] + args[i + 1] + ". Terminate.");
                System.exit(-1);
            }
        }

        System.out.println(bot.deliver(directions));
    }

    private static boolean checkBoardSize(String text) {
        return Pattern.compile("\\d[x]\\d").matcher(text).matches();
    }

    private static boolean checkDirection(String text) {
        return Pattern.compile("[(]\\d[, ]\\d[)]").matcher(text).matches();
    }
}
