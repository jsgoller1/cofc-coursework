package sorting_algos;

public class Sorter {
    public static void main(String[] args) {
        StringArrGen strings_gen = new StringArrGen();
        String[] strings = strings_gen.generate(10);
        strings_gen.display(strings);
        bubbleSort(strings);
        strings_gen.display(strings);

        NumArrGen num_gen = new NumArrGen();
        Integer[] ints = num_gen.generate(10);
        num_gen.display((ints));
        bubbleSort(ints);
        num_gen.display(ints);
    }

    public static <T extends Comparable<T>> void bubbleSort(T[] items) {
        int term = items.length;
        for (int i = term; i >= 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (items[j].compareTo(items[j + 1]) > 0) {
                    T temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }
        }
    }

    public static <T extends Comparable<T>> void merge(T[] items) {}

    public static <T extends Comparable<T>> void mergesort(T[] items) {}

    public static <T extends Comparable<T>> void insertionSort(T[] items) {}

    public static <T extends Comparable<T>> void quicksortHoare(T[] items) {}

    public static <T extends Comparable<T>> void quicksortLomuto(T[] items) {}

    public static <T extends Comparable<T>> void radixSort(T[] items) {}

    public static <T extends Comparable<T>> void selectionSort(T[] items) {}

    public static <T extends Comparable<T>> void shellSort(T[] items) {}


}

/*
 * 
 * 
 * 58, 26, 55, 93, 98, 57, 70 26, 58, 55, 93, 98, 57, 70 (1 swap) 26, 55, 58. 93, 98, 57, 70 (1
 * swap) 26, 55, 57, 58, 93, 98, 70 (3 swaps)
 * 
 */
