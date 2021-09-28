import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Item> list = new ArrayList<Item>();
        CSVReaderAndValidation csvReaderAndValidation = new CSVReaderAndValidation();
        list = csvReaderAndValidation.readCSV("/Users/liza/IdeaProjects/JavaProject/src/main/java/Items.csv");

        printArray(list);

        QuickSort obj = new QuickSort();
        obj.sort(list);

        printArray(list);

    }

    /* A utility function to print an ArrayList of Items */
    static void printArray(ArrayList<Item> arr)
    {
        for (Item item : arr){
            System.out.print(item.getItemNumber() +" ");
        }
        System.out.println();
    }


}