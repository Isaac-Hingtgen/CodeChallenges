/*
 * Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the array 
 * so that all the Rs come first, the Gs come second, and the Bs come last. You can only swap elements of the array.
 * 
 * Do this in linear time and in-place.
 */

// import java.util.Arrays;

public class Google3 {
    public static void main (String [] args) {
        char [] arr = {'G', 'B', 'R', 'R', 'B', 'R', 'G'};
        int R = 0;
        int B = 0;
        int G = 0;
        for (char c : arr) {
            if(c == 'R') R++;
            if(c == 'B') B++;
            if(c == 'G') G++;
        }
        int i = 0;
        while (R > 0) {
            arr[i] = 'R';
            R--;
            i++;
        }
        while (G > 0) {
            arr[i] = 'G';
            G--;
            i++;
        }
        while (B > 0) {
            arr[i] = 'B';
            B--;
            i++;
        } 

        System.out.print(arr);
    }




    // public static void main (String [] args) {
    //     char [] arr = {'G', 'B', 'R', 'R', 'B', 'R', 'G', 'G', 'R', 'R', 'R', 'B', 'G', 'G'};
    //     sort(arr, 0, arr.length - 1);
        
    //     System.out.print(arr);
    // }

    // public static int partition(char[] chs, int head, int tail) {
    //     int pivot = tail;
    //     for(int i = head; i < tail; i++) {
    //         if(chs[i] > chs[pivot]) {
    //             swap(chs, head, i);
    //             head++;
    //         }
    //     }
    //     swap(chs, head, pivot);
    //     return head;
    // }
    // public static void sort(char[] chars, int start, int end) {
    //     if(start >= end) { return; }
    //     int p = partition(chars, start, end);
   
    //     sort(chars, start, p - 1); 
    //     sort(chars, p + 1, end);
    // }

    // public static void swap(char[] chars, int i1, int i2) {
    //     char temp = chars[i1];
    //     chars[i1] = chars[i2];
    //     chars[i2] = temp;
    // }

    
}
