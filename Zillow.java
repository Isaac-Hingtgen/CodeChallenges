/**
 * You are given a 2-d matrix where each cell represents number of coins in that cell. 
 * Assuming we start at matrix[0][0], and can only move right or down, 
 * find the maximum number of coins you can collect by the bottom right corner.
 */

import java.util.*;

public class Zillow {
    public static void main(String[] argv) {
        int[][] inputMatrix = { 
            {0, 3, 9, 1}, 
            {2, 0, 6, 4}, 
            {1, 5, 3, 1} };

        class Position {
            private int row;
            private int col;
            private int coins;
            public Position(int r, int c, int coin) {
                row = r;
                col = c;
                coins = coin + inputMatrix[r][c];
            }
            public void setRow(int row) {
                this.row = row;
            }
            public void setCol(int col) {
                this.col = col;
            }
            public int getRow() {
                return row;
            }
            public int getCol() {
                return col;
            }
            public void addCoins(int amount) {
                coins += amount;
            }
            public int getCoins() {
                return coins;
            }
        }

        Queue<Position> q = new LinkedList<>();
        
        Position start = new Position(0,0,0);
        q.add(start);
        int maxCoins = 0;

        while(q.size() > 0) {
            Position currentPos = q.remove();
            int row = currentPos.getRow();
            int col = currentPos.getCol();
            int coin = currentPos.getCoins();
            maxCoins = Math.max(maxCoins, coin);

            if(col + 1 < inputMatrix[row].length) {
                Position rightPos = new Position(row, col + 1, coin);
                q.add(rightPos);
            }
            if(row + 1 < inputMatrix.length) {
                Position downPos = new Position(row + 1, col, coin);
                q.add(downPos);
            }   
        }
        System.out.println(maxCoins);
    }
}