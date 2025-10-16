package algorithms.searching;

public class LinearSearch {
    public int search(Integer[] arr, Integer key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
