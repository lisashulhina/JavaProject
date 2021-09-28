import java.util.ArrayList;

// Java program for implementation of QuickSort
class QuickSort {
    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    private int partition(ArrayList<Item> arr, int low, int high) {
        int pivot = arr.get(high).getItemNumber();
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr.get(j).getItemNumber() <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                Item temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        Item temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1;
    }

    /**
     * public function that call recursive sort,
     * to avoid user static input of 0 as low and arr.size() - 1 as high
     *
     * @param arr ArrayList to be passed to sortCall function
     */
    public void sort(ArrayList<Item> arr) {
        sortCall(arr, 0, arr.size() - 1);
    }

    /**
     * The main function that implements QuickSort()
     *
     * @param arr  ArrayList to be sorted
     * @param low  Starting index
     * @param high Ending index
     */
    private void sortCall(ArrayList<Item> arr, int low, int high) {
        if (low < high) {
            /* pi is partitioning index, arr.get(pi) is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sortCall(arr, low, pi - 1);
            sortCall(arr, pi + 1, high);
        }
    }
}
