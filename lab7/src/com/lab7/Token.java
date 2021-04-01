package com.lab7;

import java.util.Random;

public class Token {
    private int x;
    private int y;
    private int cost;

    public Token() {
    }

    public void GenerateToken(int n) {
        do {
            Random rand = new Random();
            this.x = rand.nextInt(n);
            this.y = rand.nextInt(n);
            this.cost = rand.nextInt();
        } while (x > y || x == y);
    }
}
