/* Christina Torres
* Spring 2023
* CMSC 451 Project 1
*/
import java.awt.Color;
import java.io.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Program1 {
    public static int[] getRandom(int size){
        // initialize new random and new array
        Random random = new Random();
        int[] array = new int[size];
        //                                        inclusive 0-100 exclusive
        for (int i = 0; i < size; i++) array[i] = random.nextInt(100);
        return array;
    }

    public Program1() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select 2 Files to Write Data :)");
        // Set file filter to only allow text files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        fileChooser.setFileFilter(filter);
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // first file
            java.io.File bubbleFile = fileChooser.getSelectedFile();
            // ask for next file
            int secondUserSelection = fileChooser.showSaveDialog(null);
            if (secondUserSelection == JFileChooser.APPROVE_OPTION) {
                // get the second file
                java.io.File insertionFile = fileChooser.getSelectedFile();
                try {
                    int size = 0;
                    String bubbleString = "";
                    String insetionString = "";
                    // create 12 different sizes
                    for (int loop = 0; loop < 12; loop++){
                        // produce 40 data sets
                        int num=40;
                        long bubbleTime=0;
                        long insertionTime=0;
                        int bubbleCount =0;
                        int insertionCount = 0;
                        for (int n=0; n<num; n++){
                            int[] x = getRandom(5);
                            BubbleSort b = new BubbleSort(x);
                            InsertionSort i = new InsertionSort(x);
                            // add to time - bubble
                            bubbleTime += b.getEnd();
                            // add to count
                            bubbleCount += b.getCount();
                            // add to time - insertion
                            insertionTime += i.getEnd();
                            // add to count
                            insertionCount += i.getCount();
                            // add total to size
                            size += num;
                        }
                        // averate times
                        // num, total time, average time
                        bubbleString += String.format("%d,%d,%d,", size, bubbleTime, bubbleTime / num);
                        insetionString += String.format("%d,%d,%d,", size, insertionTime, insertionTime / num);
                        //counts,average counts
                        bubbleString += String.format("%d,%d\n", bubbleCount, bubbleCount / num);
                        insetionString += String.format("%d,%d\n", insertionCount, insertionCount / num);
                    }
                    // Write data to the first file - bibble
                    magic(bubbleFile, bubbleString);
                    // Write data to the second file - insertion
                    magic(insertionFile, insetionString);
                    System.out.println("Successfull data :)");
                } catch (IOException e) {
                    System.out.println("Oopsie! Try again");
                    e.printStackTrace();
                }
            } else if (secondUserSelection == JFileChooser.CANCEL_OPTION) {
                System.out.println("Oopsie. No first file :(");
            }
        } else if (userSelection == JFileChooser.CANCEL_OPTION) {
            System.out.println("Oopsie. No second file :(");
        }
    }

    private static void magic(java.io.File f, String e) throws IOException {
        FileWriter fileWriter = new FileWriter(f);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(e);
        bufferedWriter.close();
    }

    public static void main(String[] args) {
        new Program1();
    }

}

