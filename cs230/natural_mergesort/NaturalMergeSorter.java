package natural_mergesort;

public class NaturalMergeSorter {
    public int getSortedRunLength(int[] array, int arrayLength, int startIndex) {
        /*
         * The method returns the number of array elements sorted in ascending order, starting at
         * startIndex and ending either at the end of the sorted run, or the end of the array,
         * whichever comes first. The method returns 0 if startIndex is out of bounds.
         */
        if (startIndex >= arrayLength) {
            return 0;
        }
        int countSorted = 1;
        int curr = startIndex;
        while (curr + 1 < arrayLength && array[curr] <= array[curr + 1]) {
            countSorted += 1;
            curr += 1;
        }
        return countSorted;

    }

    public void naturalMergeSort(int[] array, int arrayLength) {
        String doc =
                """
                        * 1. Start at index i=0
                        * 2. Get the length of the first sorted run, starting at i
                        *  - Return if the first run's length equals the array length
                        *  - If the first run ends at the array's end, reassign i=0 and repeat step 2
                        * 3. Get the length of the second sorted run, starting immediately after the first
                        * 4. Merge the two runs with the provided merge() method
                        * 5. Reassign i with the first index after the second run, or 0 if the second run ends at the array's end
                        * Go to step 2
                        */
                        """;

        while (getSortedRunLength(array, arrayLength, 0) < arrayLength) {
            for (int i = 0; i < arrayLength;) {
                /*
                 * for (int j = 0; j < arrayLength; j += 1) { System.out.printf("%d ", array[i]); }
                 * System.out.println();
                 */

                int leftLen = getSortedRunLength(array, arrayLength, i);
                int rightLen = getSortedRunLength(array, arrayLength, i + leftLen);
                if (rightLen > 0) {
                    merge(array, i, i + leftLen - 1, i + leftLen + rightLen - 1);
                    i = rightLen + 1;
                } else {
                    break;
                }
            }
        }
        return;
    }

    public void merge(int[] numbers, int leftFirst, int leftLast, int rightLast) {
        int mergedSize = rightLast - leftFirst + 1;
        int[] mergedNumbers = new int[mergedSize];
        int mergePos = 0;
        int leftPos = leftFirst;
        int rightPos = leftLast + 1;

        // Add smallest element from left or right partition to merged numbers
        while (leftPos <= leftLast && rightPos <= rightLast) {
            if (numbers[leftPos] <= numbers[rightPos]) {
                mergedNumbers[mergePos] = numbers[leftPos];
                leftPos++;
            } else {
                mergedNumbers[mergePos] = numbers[rightPos];
                rightPos++;
            }
            mergePos++;
        }

        // If left partition isn't empty, add remaining elements to mergedNumbers
        while (leftPos <= leftLast) {
            mergedNumbers[mergePos] = numbers[leftPos];
            leftPos++;
            mergePos++;
        }

        // If right partition isn't empty, add remaining elements to mergedNumbers
        while (rightPos <= rightLast) {
            mergedNumbers[mergePos] = numbers[rightPos];
            rightPos++;
            mergePos++;
        }

        // Copy merged numbers back to numbers
        for (mergePos = 0; mergePos < mergedSize; mergePos++) {
            numbers[leftFirst + mergePos] = mergedNumbers[mergePos];
        }

        // Free temporary array
        mergedNumbers = null;
    }
}
