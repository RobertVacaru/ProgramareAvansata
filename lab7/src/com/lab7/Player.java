package com.lab7;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Player implements Runnable {
    private String name;
    public Board board;
    List<Token> playerTokens=new LinkedList<>();
    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
    }
    @Override
    public void run() {
        while(!board.boardTokens.isEmpty())
        {
            Random rand=new Random();
            int index= rand.nextInt(10);
            playerTokens.add(board.returnToken(index));
            System.out.println(name + "choose" +playerTokens.get(playerTokens.size()-1));
        }
    }
}
