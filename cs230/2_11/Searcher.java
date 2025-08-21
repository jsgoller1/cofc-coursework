import java.util.*;

public class Searcher<T> {
	// Returns the index of the key in the sorted array, or -1 if the
	// key is not found.
	public static <T> int binarySearch(T[] array, int arraySize, T key, Comparator<T> comparer) {
		int lo = 0;
		int hi = array.length - 1;
		int mid = -1;

		while (lo <= hi) {
			// IMPORTANT: if lo + hi is sufficiently large, it will overflow INT_MAX.
			// To calculate their midpoint, we can do an alternative calculation.
			mid = lo + ((hi - lo) / 2);
			int comparison = comparer.compare(key, array[mid]);
			if (comparison == 0) {
				return mid;
			} else if (comparison < 0) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return -1;
	}
}
