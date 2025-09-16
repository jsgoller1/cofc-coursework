package algorithms.searching;

import java.util.Random;
import algorithms.searching.NumArrGen;

public class Searching {
    public static void main(String[] args) {
        NumArrGen ng = new NumArrGen();
        Integer nums[] = ng.generate(100);
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();
        LinearSearch ls = new LinearSearch();
        BinarySearch bs = new BinarySearch();
        Random rand = new Random();
        int key = rand.nextInt(100);

        int bs_out = bs.search(nums, key);
        int ls_out = ls.search(nums, key);
        if (nums[bs_out] != nums[ls_out]) {
            throw new AssertionError(key + ":" + bs_out + " != " + ls_out);
        } else {
            System.out.printf("Linear search (%d) and Binary search (%d) agree on %d\n", ls_out,
                    bs_out, key);
        }
    }

}
