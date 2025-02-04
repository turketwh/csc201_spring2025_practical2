public class InsertionSorter {

    private int numberOfComparisons;
    private int numberOfArrayWrites;

    public InsertionSorter() {
        resetComparisonCount();
        resetWritesCount();
    }

    private void resetComparisonCount() {
        numberOfComparisons = 0;
    }

    private void resetWritesCount() {
        numberOfArrayWrites = 0;
    }

    private boolean lessThan(int value1, int value2) {
        numberOfComparisons += 1;
        return value1 < value2;
    }

    public void sort(int[] data) {
        resetComparisonCount();
        resetWritesCount();
        if ((data != null) && (data.length > 0)) {
            int temp;
            int i;
            int j;
            for (i = 1; i < data.length; i++) { // Insert ith record
                for (j = i; (j > 0) && lessThan(data[j], data[j-1]); j--) {
                    temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                    numberOfArrayWrites += 2;
                }
            }
        }
    }

    public int getNumberOfComparisons() {
        return numberOfComparisons;
    }

    public int getNumberOfArrayWrites() {
        return numberOfArrayWrites;
    }
}
