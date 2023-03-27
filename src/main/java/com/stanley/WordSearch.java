package com.stanley;

public class WordSearch {

    private int[][] visited;
    private char[][] board;

    boolean isVisited(Position p)
    {
        return visited[p.i][p.j]==1;
    }

    boolean canVisit(Position p)
    {
        return p.i<visited.length&& p.i>=0 && p.j<visited[0].length && p.j>=0;
    }

    void visit(Position p)
    {
        visited[p.i][p.j]=1;
    }

    void unVisit(Position p)
    {
        visited[p.i][p.j]=0;
    }

    static class Position
    {
        int i;
        int j;
        Position(int i, int j )
        {
            this.i=i;
            this.j=j;
        }

        Position getUpPosition()
        {
            return new Position(this.i-1, this.j);
        }

        Position getDownPosition()
        {
            return new Position(this.i+1, this.j);
        }

        Position getLeftPosition()
        {
            return new Position(this.i, this.j-1);
        }
        Position getRightPosition()
        {
            return new Position(this.i, this.j+1);
        }

    }
    boolean findRemainingLetters(Position p, String word, int wordIndex)
    {

        if(!(wordIndex <word.length()))
        {
            return true;
        }

        Position[] allMoves={p.getUpPosition(), p.getDownPosition(),p.getLeftPosition(),p.getRightPosition()};

        for( Position m: allMoves)
        {
            if( canVisit(m) && ! isVisited(m) && board[m.i][m.j]==word.charAt(wordIndex))
            {
                visit(m);
                // matched up to keep moving
                if( findRemainingLetters( m,  word,  ++wordIndex))
                {
                    return true;
                }
                else
                {
                    wordIndex--;
                    unVisit(m);
                }
            }

        }

        return false;
    }


    public boolean exist(char[][] board, String word) {

        this.board=board;
        for(int i=0; i<board.length;i++)
        {
            for(int j=0; j<board[0].length;j++)
            {
                // found first letter so search for the rest from there...
                if( board[i][j]==word.charAt(0))
                {
                    // reset visited for next word search
                    visited = new int[board.length][board[0].length];
                    Position s = new Position(i,j);
                    visit(s);
                    if( findRemainingLetters(s,word,1) )
                    {
                        return true;
                    }
                }

            }
        }
        return false;

    }
}
