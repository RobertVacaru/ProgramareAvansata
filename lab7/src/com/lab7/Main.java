package com.lab7;

public class Main {

    public static void main(String[] args) {
        Board board = new Board(10);
        board.GenerateBoard();
        Runnable player1 = new Player("Robert",board);
        Runnable player2=new Player("Matei",board);
        new Thread(player1).start();
        new Thread(player2).start();
    }
}
