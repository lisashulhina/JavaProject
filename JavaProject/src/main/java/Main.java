import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Item> list = new ArrayList<>();
        CSVReaderAndValidation csvReaderAndValidation = new CSVReaderAndValidation();
        try {
            list = csvReaderAndValidation.readCSV("/Users/liza/IdeaProjects/JavaProject2/JavaProject/src/main/java/Items.csv");
        } catch (IOException e) {
            System.out.println("Error occurred. Message: " + e.getMessage());
        }

        printArray(list);

        QuickSort obj = new QuickSort();
        obj.sort(list);

        printArray(list);

    }

    /* A utility function to print an ArrayList of Items */
    static void printArray(ArrayList<Item> arr) {
        for (Item item : arr) {
            System.out.print(item.getItemNumber() + " ");
        }
        System.out.println();
    }


}