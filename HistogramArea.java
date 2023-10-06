//This problem was asked by Square.
//You are given a histogram consisting of rectangles of different heights.
//These heights are represented in an input list,
//such that [1, 3, 2, 5] corresponds to the following diagram:
//x
//x
//x   x
//x x x
//x x x x
//Determine the area of the largest rectangle that can be formed only from the bars of the histogram.
//For the diagram above, for example, this would be six, representing the 2 x 3 area at the bottom right.


public class HistogramArea {
    private static int [] histogram = {1,3,2,5};
    public static void main(String args[]) {
        System.out.println(getLargestArea());
    }
    public static int getLargestArea(){
        int max = 0;
        for(int bar : histogram) {
            if(bar > max) max = bar;
        }
        return getLargestArea(1, max);
    }
    private static int getLargestArea(int level, int max) {
        if(level > max) return 0;
        int start = 0;
        int area = 0;
        for(int end = 0; end < histogram.length; end++) {
            if(histogram[end] < level || end == histogram.length - 1) {
                area = Math.max(area, (end - start + 1) * level);
                start = end + 1;
            }
        }
        return Math.max(area, getLargestArea(level + 1, max));
    }
}
