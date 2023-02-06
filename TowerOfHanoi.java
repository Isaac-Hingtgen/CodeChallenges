/**
 * The Tower of Hanoi is a puzzle game with three rods and n disks, each a different size.
 * All the disks start off on the first rod in a stack. They are ordered by size, with the largest disk on the bottom and the smallest one at the top.
 * The goal of this puzzle is to move all the disks from the first rod to the last rod while following these rules:
 * 
 * You can only move one disk at a time.
 * A move consists of taking the uppermost disk from one of the stacks and placing it on top of another stack.
 * You cannot place a larger disk on top of a smaller disk.
 * Write a function that prints out all the steps necessary to complete the Tower of Hanoi. You should assume that the rods are numbered, 
 * with the first rod being 1, the second (auxiliary) rod being 2, and the last (goal) rod being 3.
 * 
 * For example, with n = 3, we can do this in 7 moves:
 * 
 * Move 1 to 2
 * Move 3 to 2
 * Move 1 to 3
 * Move 2 to 1
 * Move 2 to 3
 * Move 1 to 3
 * Move 1 to 3
 */


public class TowerOfHanoi {
    private int numDiscs;
    private int target;             // rod that 2 smallest discs should be moved to 
    private int lead;               // rod where 2 discs smallest disc originate
    private int intermediate;       // other rod
    private int requiredSteps;
    private int currentStep;
    public static void main(String [] args) {
        TowerOfHanoi myTowerOfHanoi = new TowerOfHanoi(5);
        myTowerOfHanoi.printSteps();
    }
    public TowerOfHanoi(int discs) {
        numDiscs = discs;
        requiredSteps = calcNumberOfRequiredSteps(discs);
        lead = 0;
        target = discs % 2 == 0 ? 2 : 1;      // initialize target to the 2nd or 3rd rod depending on number of discs
        intermediate = target == 2 ? 1 : 2;
    }
    public void printSteps() {
        int start = 0;
        printStepRecursive(start);
    }
    public void printStepRecursive(int shiftCounter) {
        lead = (lead + shiftCounter) % 3;                   //
        target = (target + shiftCounter) % 3;               // Shift all three to the right
        intermediate = (intermediate + shiftCounter) % 3;   //
        if(numDiscs == 1) {
            moveDisc(lead, intermediate);
        }
        if(currentStep == requiredSteps) {
            System.out.println("finished");
            return;
        }
        if(shiftCounter != 0) {
            moveDisc(intermediate, target); 
        }

        moveDisc(lead, intermediate);
        moveDisc(lead, target);
        moveDisc(intermediate, target);
        
        printStepRecursive(shiftCounter + 1);
    }
    public void moveDisc(int from, int to) {
        System.out.printf("Move %d to %d\n", from + 1, to + 1);
        currentStep += 1;
    }
    public int calcNumberOfRequiredSteps(int discs) {
        if(discs == 1) {
            return 1;
        }
        return 2 * calcNumberOfRequiredSteps(discs - 1) + 1;
    }
}
