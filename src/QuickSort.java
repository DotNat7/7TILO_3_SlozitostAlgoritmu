public class QuickSort {

    static void sort(Comparable[] arr, SortingComparison.SortMetrics metrics) {
        metrics.reset();
        metrics.startTime = System.currentTimeMillis();
        quicksortHelper(arr, 0, arr.length - 1, metrics);
        metrics.endTime = System.currentTimeMillis();
    }

    private static void quicksortHelper(
            Comparable[] arr, int low, int high, SortingComparison.SortMetrics metrics) {

        if (low < high) {
            int pi = partition(arr, low, high, metrics);
            quicksortHelper(arr, low, pi - 1, metrics);
            quicksortHelper(arr, pi + 1, high, metrics);
        }
    }

    private static int partition(
            Comparable[] arr, int low, int high, SortingComparison.SortMetrics metrics) {

        Comparable pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            metrics.comparisons++;

            if (compareMixed(arr[j], pivot) <= 0) {
                i++;

                Comparable temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Comparable temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
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