package algorithms.sorting;

public class QuickSort2 {
    public void quicksort(Integer[] arr, int l, int r) {
        if (r - l < 1) {
            return;
        }

        int pivot = partition(arr, l, r);
        quicksort(arr, l, pivot - 1);
        quicksort(arr, pivot + 1, r);
    }

    public int partition(Integer[] arr, int l, int r) {
        int bound = 0;
        int pivot = arr[r];
        for (int i = 0; i < r; i++) {
            if (arr[i] < pivot) {
                swap(arr, bound, i);
                bound++;
            }
        }
        swap(arr, bound, r);
        return bound;

    }

    public void swap(Integer arr[], int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
