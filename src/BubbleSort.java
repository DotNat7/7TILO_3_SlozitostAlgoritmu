public class BubbleSort {
    static void sort(Comparable[] arr, SortingComparison.SortMetrics metrics) {
        metrics.reset();
        metrics.startTime = System.currentTimeMillis();

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                metrics.comparisons++;

                if (compareMixed(arr[j], arr[j + 1]) > 0) {
                    Comparable temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        metrics.endTime = System.currentTimeMillis();
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