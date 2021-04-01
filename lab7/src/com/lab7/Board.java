package com.lab7;

import java.util.LinkedList;
import java.util.List;

public class Board {
    private int numberOfTokens;
    List<Token> boardTokens=new LinkedList<>();
    public Board(int n) {
        this.numberOfTokens=n;
    }
    public void GenerateBoard()
    {     int i=0;
          while(i<numberOfTokens)

          {
              Token token=new Token();
              token.GenerateToken(numberOfTokens);
              boardTokens.add(token);
          }
    }
    public Token returnToken(int x)
    {
        Token auxToken=boardTokens.get(x);
        boardTokens.remove(x);
        numberOfTokens--;
        return auxToken;
    }
}
