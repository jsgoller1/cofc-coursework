package algorithms.sorting;

public class Sorting {
    public static void main(String[] args) {
        StringArrGen strings_gen = new StringArrGen();
        NumArrGen num_gen = new NumArrGen();

        System.out.println(("Bubblesort"));
        String[] strings = strings_gen.generate(10);
        strings_gen.display(strings);
        bubbleSort(strings);
        strings_gen.display(strings);
        System.out.println(("================="));

        MergeSorter mergesorter = new MergeSorter();

        System.out.println(("Mergesort - aux space"));
        Integer[] ints = num_gen.generate(10);
        num_gen.display(ints);
        Integer[] mergesorted = mergesorter.sort(ints);
        num_gen.display(mergesorted);
        System.out.println(("================="));

        System.out.println(("Mergesort - in place"));
        Integer[] ints4 = num_gen.generate(10);
        num_gen.display(ints4);
        mergesorter.sortInPlace(ints4, 0, ints4.length);
        num_gen.display(ints4);
        System.out.println(("================="));

        System.out.println(("QuickSort"));
        Integer[] ints2 = num_gen.generate(10);
        num_gen.display(ints2);
        QuickSort2 qs = new QuickSort2();
        qs.quicksort(ints2, 0, ints2.length - 1);
        num_gen.display(ints2);
        System.out.println(("================="));

        System.out.println(("SelectionSort"));
        Integer[] ints3 = num_gen.generate(10);
        num_gen.display(ints3);
        SelectionSorter ss = new SelectionSorter();
        ss.sort(ints3);
        num_gen.display(ints3);
        System.out.println(("================="));

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
}
