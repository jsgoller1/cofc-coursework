package algorithms.sorting;

public class QuickSorter {

    public void sort(Integer[] array, int left, int right) {
        /*
         * Problem: sort an array of integers - paritioning array into two subarrays such that ls is
         * lt pivot and rs is gte pivot - recurse on left and right partitions
         */
        if (right - left < 1) {
            // A subarray of less than 1 ints is already sorted:
            // []: sorted by default
            return;
        }

        int middle = partition(array, left, right);
        sort(array, left, middle - 1);
        sort(array, middle + 1, right);
    }

    private int partition(Integer[] arr, int left, int right) {
        // Lomuto's partitioning strategy
        // Rightmost val (arr[r]) is pivot
        // Bound is initially l; everything less than bound is less than pivot.
        // everything right of bound is gte pivot
        // i = l to start
        // if arr[i] >= pivot, great. i++
        // but if arr[i] < pivot, swap it with the bound. bound++, and i++
        // when i = r, stop. swap bound and r.
        // then return bound
        int pivot = arr[right];
        int bound = 0;
        for (int i = 0; i < right; i++) {
            if (arr[i] < pivot) {
                swap(arr, i, bound);
                bound++;
            }
        }
        swap(arr, bound, right);
        return bound;
    }


    public void swap(Integer[] arr, int l, int r) {
        int temp = arr[r];
        arr[r] = arr[l];
        arr[l] = temp;
    }
}
