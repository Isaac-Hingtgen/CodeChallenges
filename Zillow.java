/**
 * You are given a 2-d matrix where each cell represents number of coins in that cell. 
 * Assuming we start at matrix[0][0], and can only move right or down, 
 * find the maximum number of coins you can collect by the bottom right corner.
 */

import java.util.*;

public class Zillow {
    
    public static void main(String[] argv) {
        int[][] inputMatrix = { 
            {0, 3, 9, 0}, 
            {2, 0, 6, 1}, 
            {2, 5, 3, 1},
            {7, 3, 2, 4}, 
            {2, 4, 0, 3}, 
            {3, 8, 4, 1} }; // (0 -> 3 -> 9 -> 6 -> 3 -> 2 -> 4 -> 3 -> 1) Expected: 31

        Queue<Position> q = new LinkedList<>();
        
        Position.setInputMatrix(inputMatrix);
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
        System.out.println("The most coins that can be gathered is : " + maxCoins);
    }
    static class Position {
        private int row;
        private int col;
        private int coins;
        private static int[][] inputMatrix;
        public Position(int r, int c, int coin) {
            row = r;
            col = c;
            coins = coin + inputMatrix[r][c];
        }
        public static void setInputMatrix(int[][] matrix) {
            inputMatrix = matrix;
        }
        public int getRow() {
            return row;
        }
        public int getCol() {
            return col;
        }
        public int getCoins() {
            return coins;
        }
    }
}