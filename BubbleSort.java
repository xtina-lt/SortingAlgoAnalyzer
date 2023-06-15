/* Christina Torres
* Spring 2023
* CMSC 451 Project 1
*/
public class BubbleSort extends AbstractSort {    

    public BubbleSort(int[] arr){
        super(arr);
        start();
        System.out.println("Bubble Sorting****************");
        getUnSorted();
        bubbleSort(arr);
        getSorted();
        try {
            isSorted();
        } catch (UnsortedArrayException e) {
            System.out.println(e.getMessage());
        }
        getCount();
        end();
    }

    private int[] bubbleSort(int[] arr) {
        increment();;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            increment();;
            for (int j = 0; j < n - i - 1; j++) {
                increment();
                // swap if left is smaller than right arr[j + 1] 
                if (arr[j] > arr[j + 1]) {
                    increment();
                    int temp = arr[j];
                    increment();
                    arr[j] = arr[j + 1];
                    increment();
                    arr[j + 1] = temp;
                }
            }
        }
        return setSorted(arr);
    }
}

