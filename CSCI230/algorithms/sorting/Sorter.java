package algorithms.sorting;

abstract class Sorter<T extends Comparable<T>> {

    // Uses aux memory
    abstract T[] sort(T[] arr);

    // in-place
    abstract void sortInPlace(T[] arr);
}
