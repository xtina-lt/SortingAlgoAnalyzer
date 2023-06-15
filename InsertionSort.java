/* Christina Torres
* Spring 2023
* CMSC 451 Project 1
*/
public class InsertionSort extends AbstractSort{   
    public InsertionSort(int[] arr){
        super(arr);
        start();
        System.out.println("Insertion Sorting****************");
        getUnSorted();
        insertionSort(arr);
        getSorted();
        try {
            isSorted();
        } catch (UnsortedArrayException e) {
            System.out.println(e.getMessage());
        }
        getCount();
        end();
    }
    // mutators
    private int[] insertionSort(int[] arr) {
        increment();
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            increment();
            int key = arr[i];
            increment();
            int j = i - 1;
            increment();
            while (j >= 0 && arr[j] > key) {
                increment();
                arr[j + 1] = arr[j];
                increment();
                j--;
            }
            arr[j + 1] = key;
            increment();
        }
        return setSorted(arr);
    }


    
}

