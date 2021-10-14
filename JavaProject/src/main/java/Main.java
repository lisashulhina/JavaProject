import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            try {
                ArrayList<Item> list;

                // reads user input
                System.out.println("\nPlease enter absolute file path on your own computer for file for what you want to proceed:");
                String inputFilePath = sc.nextLine();

                // starts counting time
                Instant start = Instant.now();

                // reads file
                CSVReaderAndValidation csvReaderAndValidation = new CSVReaderAndValidation();
                list = csvReaderAndValidation.readCSV(inputFilePath);

                // prints original list
                System.out.println("Original list:");
                printArrayItemNumber(list);
                // printArrayItem(list); // if you want each item attribute to be printed uncomment this code

                // does QuickSort
                QuickSort obj = new QuickSort();
                obj.sort(list);

                // prints sorted list
                System.out.println("\nSorted list:");
                printArrayItemNumber(list);
                // printArrayItem(list); // if you want each item attribute to be printed uncomment this code

                // prints time for one complete process
                Instant finish = Instant.now();
                long timeElapsed = Duration.between(start, finish).toMillis();
                System.out.println("\nTime spent: " +timeElapsed + " milliseconds.");

                // asking if more than 1 file wanted to be proceed
                System.out.println("\nDo you want to input another file? ");
                flag = tryAgain(sc, flag);

            } catch (IOException e) {
                System.out.println("Error occurred. Message: " + e.getMessage());
                System.out.println("Do you want to try to input again?");

                flag = tryAgain(sc, flag);
            }

        }
    }

    /**
     * asks the user if he/she wants to continue and returns the answer as flag
     *
     * @param sc   scanner for user answer
     * @param flag to stop or continue the loop
     * @return flag to stop or continue the loop
     */
    static boolean tryAgain(Scanner sc, boolean flag) {
        System.out.println("N/No for no, any other to continue.");
        String wantToContinue = sc.nextLine();
        if (wantToContinue.toLowerCase(Locale.ROOT).equals("no") || wantToContinue.toLowerCase(Locale.ROOT).equals("n")) {
            flag = false;
        }
        return flag;
    }


    /**
     * prints an ItemNumber of each element of ArrayList of Items
     *
     * @param arr array to be printed
     */
    static void printArrayItemNumber(ArrayList<Item> arr) {
        for (Item item : arr) {
            System.out.print(item.getItemNumber() + " ");
        }
    }

    /**
     * prints an ItemNumber of each element of ArrayList of Items
     *
     * @param arr array to be printed
     */
    static void printArrayItem(ArrayList<Item> arr) {
        for (Item item : arr) {
            System.out.print(item + "\n");
        }
    }

}