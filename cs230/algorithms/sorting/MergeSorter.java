package algorithms.sorting;

import java.util.Arrays;


public class MergeSorter {

    private Integer[] merge(Integer[] left, Integer[] right) {
        int l = 0;
        int r = 0;

        Integer[] merged = new Integer[left.length + right.length];
        int i = 0;

        while (l < left.length && r < right.length) {
            // If left[l] <= right[r]
            if (left[l].compareTo(right[r]) < 1) {
                merged[i++] = left[l++];
            } else {
                merged[i++] = right[r++];
            }
        }

        while (l < left.length) {
            merged[i++] = left[l++];
        }

        while (r < right.length) {
            merged[i++] = right[r++];

        }

        return merged;
    }

    public Integer[] sort(Integer[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int midpoint = arr.length / 2;
        Integer[] left = Arrays.copyOfRange(arr, 0, midpoint);
        Integer[] right = Arrays.copyOfRange(arr, midpoint, arr.length);

        Integer[] sortedLeft = sort(left);
        Integer[] sortedRight = sort(right);

        Integer[] merged = merge(sortedLeft, sortedRight);

        return merged;
    };

    public void sortInPlace(Integer[] arr, int l, int r) {
        if (r - l < 2) {
            return;
        }

        int mid = (l + r) / 2;
        sortInPlace(arr, l, mid);
        sortInPlace(arr, mid, r);

        mergeInPlace(arr, l, mid, r);

        return;
    };

    public void mergeInPlace(Integer[] arr, int l, int m, int r) {
        // Not truly in-place. Linear time in-place merging is hard!
        int leftStart = l;
        int leftEnd = m;
        int rightStart = m;
        int rightEnd = r;

        Integer merged[] = new Integer[r - l];
        int i = 0;

        while (leftStart < leftEnd && rightStart < rightEnd) {
            if (arr[leftStart] < arr[rightStart]) {
                merged[i++] = arr[leftStart++];
            } else {
                merged[i++] = arr[rightStart++];
            }
        }
        while (leftStart < leftEnd) {
            merged[i++] = arr[leftStart++];
        }
        while (rightStart < rightEnd) {
            merged[i++] = arr[rightStart++];
        }

        for (int j = 0; j < merged.length; j++) {
            arr[l++] = merged[j];
        }
    }
}
