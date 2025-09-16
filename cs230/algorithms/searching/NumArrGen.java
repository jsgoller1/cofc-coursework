package algorithms.searching;

import java.util.Random;
import java.util.Arrays;

public class NumArrGen {
    public Integer[] generate(int size) {
        Random rand = new Random();

        // Size and bound will be equal; the array will contain no empty space
        Integer nums[] = new Integer[size];
        for (int i = 0; i < size; i++) {
            nums[i] = rand.nextInt(100);
        }
        Arrays.sort(nums);
        return nums;
    }

    public void display(Integer[] ints) {
        for (int i = 0; i < ints.length; i++) {
            System.out.printf("%s ", ints[i]);
        }
        System.out.println();
    }
}
