//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public static void main(String[] args) {
    System.out.println("\n");
    System.out.println(" DATASET 1: Smíšená data (čísla + řetězce) ");
    System.out.println("══════════════════════════════════════════");

    Comparable[] dataset1 = (Comparable[]) Manager.parseDataset1();
    SortingComparison.SortMetrics metrics = new SortingComparison.SortMetrics();

    Comparable[] arr1 = Manager.copyArray(dataset1);
    BubbleSort.sort(arr1, metrics);
    metrics.printResults("Bubble Sort", dataset1.length);

    arr1 = Manager.copyArray(dataset1);
    QuickSort.sort(arr1, metrics);
    metrics.printResults("Quicksort", dataset1.length);

    arr1 = Manager.copyArray(dataset1);
    MergeSort.sort(arr1, metrics);
    metrics.printResults("Merge Sort", dataset1.length);

    System.out.println("\n");
    System.out.println(" DATASET 2: Velká desetinná čísla ");
    System.out.println("═════════════════════════════════");

    Double[] dataset2 = Manager.parseDataset2();

    Double[] arr2 = Manager.copyArray(dataset2);
    BubbleSort.sort(arr2, metrics);
    metrics.printResults("Bubble Sort", dataset2.length);

    arr2 = Manager.copyArray(dataset2);
    QuickSort.sort(arr2, metrics);
    metrics.printResults("Quicksort", dataset2.length);

    arr2 = Manager.copyArray(dataset2);
    MergeSort.sort(arr2, metrics);
    metrics.printResults("Merge Sort", dataset2.length);

    System.out.println("\n");
    System.out.println(" DATASET 3: Osobní číslo P25243");
    System.out.println("═══════════════════════════════");

    Comparable[] dataset3 = Manager.parseDataset3();

    Comparable[] arr3 = Manager.copyArray(dataset3);
    BubbleSort.sort(arr3, metrics);
    metrics.printResults("Bubble Sort", dataset3.length);

    arr3 = Manager.copyArray(dataset3);
    QuickSort.sort(arr3, metrics);
    metrics.printResults("Quicksort", dataset3.length);

    arr3 = Manager.copyArray(dataset3);
    MergeSort.sort(arr3, metrics);
    metrics.printResults("Merge Sort", dataset3.length);
}

