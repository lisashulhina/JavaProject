import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class CSVReaderAndValidation {

    /**
     * reads CSV file and returns list of items from it
     *
     * @param filePath file absolute path
     * @return list of Items
     * @throws IOException thrown if file not found
     */
    public ArrayList<Item> readCSV(String filePath) throws IOException {
        ArrayList<Item> list = new ArrayList<>();

        //count lines
        int fileLines = lineCounter(filePath);

        // open CVS file reader
        CSVReader csvReader = new CSVReader(new FileReader(filePath));

        // creating list of string for header
        String[] header = csvReader.readNext();
        // trimming and lowering each element  of the list
        header = stringArrayTrimmingLowerCasing(header);

        for (int i = 0; i < fileLines - 1; i++) {

            // creating list of strings for each line
            String[] line = csvReader.readNext();

            // trimming and lowering each element of the list
            line = stringArrayTrimmingLowerCasing(line);

            //adding elements to the list of items
            addToList(list, line, header, i);
        }
        return list;
    }

    /**
     * This function adds Item elements to the list
     *
     * @param list   list to which we add element
     * @param line   line from file we need to add to list
     * @param header list of headers
     * @param i      iterator for record number
     */
    public void addToList(ArrayList<Item> list, String[] line, String[] header, int i) {
        try {
            list.add(
                    new Item(Integer.parseInt(Arrays.asList(line).get(Arrays.asList(header).indexOf("item_number".toLowerCase(Locale.ROOT)))),
                            Integer.parseInt(Arrays.asList(line).get(Arrays.asList(header).indexOf("quantity".toLowerCase(Locale.ROOT)))),
                            Integer.parseInt(Arrays.asList(line).get(Arrays.asList(header).indexOf("bin_num".toLowerCase(Locale.ROOT)))),
                            Boolean.parseBoolean(Arrays.asList(line).get(Arrays.asList(header).indexOf("in_stock".toLowerCase(Locale.ROOT))))
                            , Arrays.asList(line).get(Arrays.asList(header).indexOf("name".toLowerCase(Locale.ROOT)))
                            , Double.parseDouble(Arrays.asList(line).get(Arrays.asList(header).indexOf("price".toLowerCase(Locale.ROOT))))));
        } catch (Exception e) {
            System.out.println("Record " + (i + 1) + " is not in valid format and it was dropped from list.");
            if (line.length != 6) {
                System.out.println("Expected number of record in line: 6\nGiven number of record in line: " + line.length + "\n");
            } else {
                System.out.println("Error occurred. Probably of input mismatching. Message: " + e.getMessage() + "\n");
            }

            Scanner sc = new Scanner(System.in);
            System.out.println("Would you like to continue?");
            System.out.println("N/No for no (exits the program to let you make changes to the file), any other to continue.");
            String wantToContinue = sc.nextLine();
            if (wantToContinue.toLowerCase(Locale.ROOT).equals("no") || wantToContinue.toLowerCase(Locale.ROOT).equals("n")) {
                System.exit(0);
            }
        }

    }

    /**
     * counts number of lines in file
     *
     * @param filePath file absolute path
     * @return number of lines in file
     * @throws IOException thrown if file not found
     */
    public int lineCounter(String filePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        int fileLines = 0;
        while ((bufferedReader.readLine()) != null) {
            fileLines++;
        }
        return fileLines;
    }

    /**
     * trims and lowers each string in string array
     *
     * @param arr input array
     */
    public String[] stringArrayTrimmingLowerCasing(String[] arr) {
        for (int j = 0; j < arr.length; j++) {
            arr[j] = arr[j].trim().toLowerCase(Locale.ROOT);
        }
        return arr;
    }
}
