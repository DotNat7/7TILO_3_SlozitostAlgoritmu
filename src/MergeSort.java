import java.util.Arrays;

public class MergeSort {

    static void sort(Comparable[] arr, SortingComparison.SortMetrics metrics) {
        metrics.reset();
        metrics.startTime = System.currentTimeMillis();
        Comparable[] temp = Arrays.copyOf(arr, arr.length);
        mergeSortHelper(arr, temp, 0, arr.length - 1, metrics);
        metrics.endTime = System.currentTimeMillis();
    }

    private static void mergeSortHelper(Comparable[] arr, Comparable[] temp, int left, int right, SortingComparison.SortMetrics metrics) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortHelper(arr, temp, left, mid, metrics);
            mergeSortHelper(arr, temp, mid + 1, right, metrics);
            merge(arr, temp, left, mid, right, metrics);
        }
    }

    private static void merge(Comparable[] arr, Comparable[] temp, int left, int mid, int right, SortingComparison.SortMetrics metrics) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            metrics.comparisons++;
            if (compareMixed(temp[i], temp[j]) <= 0) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            arr[k++] = temp[i++];
        }
    }

    private static int compareMixed(Comparable a, Comparable b) {
        boolean aNum = a instanceof Integer;
        boolean bNum = b instanceof Integer;

        if (aNum && bNum) {
            return ((Integer) a).compareTo((Integer) b);
        }

        if (!aNum && !bNum) {
            return a.toString().compareTo(b.toString());
        }

        return aNum ? -1 : 1;
    }
}