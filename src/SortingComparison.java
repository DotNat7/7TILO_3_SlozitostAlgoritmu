public class SortingComparison {
    static class SortMetrics {
        long comparisons = 0;
        long startTime;
        long endTime;

        void reset() {
            comparisons = 0;
            startTime = 0;
            endTime = 0;
        }

        void printResults(String algorithmName, int arraySize) {
            long duration = endTime - startTime;
            System.out.println("\n" + algorithmName + ":");
            System.out.println("  Velikost pole: " + arraySize);
            System.out.println("  Počet porovnání: " + comparisons);
            System.out.println("  Čas: " + duration + " ms");
        }
    }
}
