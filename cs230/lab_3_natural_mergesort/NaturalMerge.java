import java.io.PrintWriter;
import java.util.Arrays;

public class NaturalMerge {
    public static void main(String[] args) {
        // Test case array: A completely sorted array
        int[] arr1 = {15, 23, 23, 23, 31, 64, 77, 87, 88, 91};
        int arr1Length = arr1.length;

        // Test case array: Sorted run of 3 followed by sorted run of 6
        int[] arr2 = {64, 88, 91, 12, 21, 34, 43, 56, 65};
        int arr2Length = arr2.length;

        // Test case array: 5 elements in descending order, so 5 runs of length 1
        int[] arr3 = {-10, -20, -30, -40, -50};
        int arr3Length = arr3.length;

        // Test case array: 8 equal elements, so 1 run of 8
        int[] arr4 = {-99, -99, -99, -99, -99, -99, -99, -99};
        int arr4Length = arr4.length;

        // Test case array: 11 equal elements, so 1 run of 11.
        // According to submission, merge() should only be called 4 times

        int[] arrJ1 = {17, 58, 96, 24, 88, 70, 23, 64, 74, 81, 55};
        int arrJ1Length = arrJ1.length;

        // Test cases:
        RunLengthTestCase[] testCases = {
                // First test case uses an out-of-bounds starting index. Remaining test
                // cases do not.
                /*
                 * / new RunLengthTestCase(arr1, arr1Length, arr1Length, 0), new
                 * RunLengthTestCase(arr1, arr1Length, 0, arr1Length), new RunLengthTestCase(arr1,
                 * arr1Length, 3, arr1Length - 3), new RunLengthTestCase(arr2, arr2Length, 0, 3),
                 * new RunLengthTestCase(arr2, arr2Length, 2, 1), new RunLengthTestCase(arr2,
                 * arr2Length, 3, 6), new RunLengthTestCase(arr3, arr3Length, 0, 1), new
                 * RunLengthTestCase(arr3, arr3Length, 3, 1), new RunLengthTestCase(arr4,
                 * arr4Length, 0, arr4Length), new RunLengthTestCase(arr4, arr4Length, 4, arr4Length
                 * - 4), new RunLengthTestCase(arr4, arr4Length, 5, arr4Length - 5),
                 */
                // new RunLengthTestCase(arrJ1, arrJ1Length, 0, 3)};
        };

        // Execute each test case
        PrintWriter testFeedback = new PrintWriter(System.out);
        int testCasesLength = testCases.length;
        for (int i = 0; i < testCasesLength; i++) {
            RunLengthTestCase testCase = testCases[i];

            // Execute the test case, using System.out to write messages
            testCase.execute(testFeedback);
        }
        testFeedback.flush();

        int[] arrLenTest1 = {17, 58, 96, 24, 88, 70, 23, 64, 74, 81, 55};
        runSortingTest(arrLenTest1, 4);
        int[] arrLenTest2 = {89, 34, 144, 39088169, 377, 13, 433494437, 10946, 832040, 233,
                165580141, 3524578, 24157817, 17711, 610, 317811, 1597, 1346269, 987, 4181, 21,
                6765, 1, 5702887, 2584, 75025, 514229, 46368, 102334155, 63245986, 121393,
                267914296, 1134903170, 2, 9227465, 14930352, 28657, 8, 2178309, 1, 5, 701408733, 3,
                55, 196418};
        // runSortingTest(arrLenTest2);
        int[] arrLenTest3 = {87, 64, 53, 92, 81, 88, 70, 12, 45, 96, 72};
        runSortingTest(arrLenTest3, 6);

    }


    public static void runSortingTest(int[] testArr, int mergeCalls) {
        // Test case array for sorting
        int[] arr5 = testArr;
        int arr5Length = testArr.length;
        int[] arr5Copy = new int[arr5Length];
        for (int i = 0; i < arr5Length; i++) {
            arr5Copy[i] = arr5[i];
        }

        System.out.printf("Init:\n\t");
        for (int k = 0; k < testArr.length; k++) {
            System.out.printf(" %d", testArr[k]);
        }
        System.out.println();

        NaturalMergeSorter sorter = new NaturalMergeSorter();
        sorter.naturalMergeSort(arr5Copy, arr5Length);
        System.out.print("\n");
        System.out.print(
                (IsArraySorted.isSorted(arr5Copy, arr5Length) ? "Sorting: PASS" : "Sorting: FAIL"));
        System.out.print("\n");
        System.out.printf((sorter.mergeCalls == mergeCalls ? "Merge calls: PASS: %d\n"
                : "Merge calls: FAIL: %d\n"), mergeCalls);
        System.out.print(": naturalMergeSort()");

        System.out.print(": naturalMergeSort()");
        System.out.print("   Array before calling naturalMergeSort(): " + Arrays.toString(arr5));
        System.out.print("\n");
        System.out
                .print("   Array after calling naturalMergeSort():  " + Arrays.toString(arr5Copy));
        System.out.print("\n");
    }
}
