/* Christina Torres
* Spring 2023
* CMSC 451 Project 1
*/
import java.util.Random;

public class AbstractSort {
    private long start;
    private long end;
    private int count;
    private int[] unsorted;
    private int[] sorted;

    public AbstractSort(int[] unsorted){
        this.unsorted = unsorted;
    }

    public void start(){
        this.start = System.nanoTime();
    }

    public void end(){
        end = System.nanoTime();
        end = end - start;
        System.out.printf("Completed in %d seconds :)\n", end);
    }

    public long getEnd(){
        return end;
    }

    public void increment(){
        count++;
    }

    public int getCount(){
        System.out.printf("Took %d counts :)\n", count);
        return count;
    }

    public int[] getSorted() {
        System.out.print("Sorted: ");
        for (int num : sorted) System.out.print(num + " ");
        System.out.println();
        return sorted;
    }

    public int[] getUnSorted() {
        System.out.print("Unorted: ");
        for (int num : unsorted) System.out.print(num + " ");
        System.out.println();
        return unsorted;
    }

    public boolean isSorted() throws UnsortedArrayException{
        boolean result = true;
        for (int i=0; i < sorted.length-1; i++) if (sorted[i] > sorted[i+1]) result = false;
        if (!result)  throw new UnsortedArrayException("Ohhh noo!! Array not sorted!! Try again!!");
        return result;
    }

    public int[] setSorted(int[] e){
        return this.sorted = e;
    }
    @Override
    public String toString() {
        String result = "";
        for (int num : unsorted) result += (num + " ");
        result += " | ";

        for (int num : sorted) result += (num + " ");
        result += " | ";

        result += " \t" + count;

        result += " | \t" + end +"\n";
        return result;
    }
}
