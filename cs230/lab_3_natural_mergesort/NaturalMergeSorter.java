public class NaturalMergeSorter {
    public int mergeCalls = 0;

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
        while (getSortedRunLength(array, arrayLength, 0) < arrayLength) {
            for (int i = 0; i < arrayLength;) {
                int leftLen = getSortedRunLength(array, arrayLength, i);
                int rightLen = getSortedRunLength(array, arrayLength, i + leftLen);
                if (rightLen > 0) {
                    System.out.printf(
                            "merge()\n\ti=%d, leftLen=%d, rightLen=%d\n\ti + leftLen - 1=%d\n\ti + leftLen + rightLen - 1=%d\n",
                            i, leftLen, rightLen, i + leftLen - 1, i + leftLen + rightLen - 1);
                    merge(array, i, i + leftLen - 1, i + leftLen + rightLen - 1);
                    i = i + leftLen + rightLen;
                    mergeCalls++;

                    System.out.printf("\tPost-merge:\n\t");
                    for (int k = 0; k < arrayLength; k++) {
                        System.out.printf(" %d", array[k]);
                    }
                    System.out.println();
                } else {
                    break;
                }
            }
        }
        System.out.printf("Merge calls: %d\n", mergeCalls);
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
