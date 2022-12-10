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






    // public static void main(String [] args) {
    //    char [] arr = {'G', 'B', 'R', 'R', 'B', 'R', 'G'};
    //     int numBs = 0;

    //    for (int i = 0; i < arr.length; i++) {
    //         if(arr[i] == 'R') {
    //             push(arr, i);
    //         }
    //         if(arr[i] == 'B') {
    //             append(arr, i);
    //             i--;
    //             numBs++;
    //         }
    //         if(arr.length - numBs <= i) {
    //             break;
    //         }
    //         String str = Arrays.toString(arr);
    //     System.out.print(str);
    //    }

        
    // }

    // public static void push(char [] arr, int index) {
    //     char temp = arr[index];
    //     shiftRight(arr, index);
    //     arr[0] = temp;
    // }

    // public static void shiftRight(char [] arr, int index) {
    //     if(index <= 0) return;
    //     arr[index] = arr[index - 1];
    //     shiftRight(arr, index - 1);
    // }

    // public static void append(char [] arr, int index) {
    //     char temp = arr[index];
    //     shiftLeft(arr, index);
    //     arr[arr.length - 1] = temp;
    // }

    // public static void shiftLeft(char [] arr, int index) {
    //     if(index >= arr.length - 1) return;
    //     arr[index] = arr[index + 1];
    //     shiftLeft(arr, index + 1);
    // }
}
