
/**
 * You are given an M by N matrix consisting of booleans that represents a board. 
 * Each True boolean represents a wall. Each False boolean represents a tile you can walk on.
 * 
 * Given this matrix, a start coordinate, and an end coordinate, return the minimum number of steps 
 * required to reach the end coordinate from the start. If there is no possible path, then return null. 
 * You can move up, left, down, and right. You cannot move through walls. 
 * You cannot wrap around the edges of the board.
 */


import java.util.LinkedList;


public class Google2 {

    public static int [] adjacent = {0, 1, 0, -1, 0};

    public static void main(String [] args) {
        boolean [][] board = {  {false, false, false, false},
                                {true , true , true , false},
                                {false, false, false, false},
                                {false, false, false, false}};
       System.out.print(BFS(board, 0, 3, 2, 0));
    }

    public static Integer BFS(boolean [][] wall, int xi, int yi, int xf, int yf) {
        LinkedList<Integer> x = new LinkedList<Integer>();
        LinkedList<Integer> y = new LinkedList<Integer>();
        int count = 0;
        int col = xi;
        int row = yi;

        x.add(col);
        y.add(row);
        wall[row][col] = true;

        while(x.size() != 0 && y.size() != 0){

            for(int h = 0; h < x.size(); h++) {
                col = x.poll();
                row = y.poll();
            
                for(int i = 0; i < adjacent.length - 1; i++) {
                    int j = adjacent[i];
                    int k = adjacent[i+1];
                    
                    if(0 > row + j || row + j >= wall.length || 0 > col + k || col + k >= wall.length) {
                        continue;
                    }

                    if(wall[row + j][col + k] == false) {
                        wall[row + j][col + k] = true;
                        x.add(col + k);
                        y.add(row + j);
                    }
                }
            }
            count++;
            if(col == xf && row == yf) {
                return count;
            }
        }
        return null;
    }
}