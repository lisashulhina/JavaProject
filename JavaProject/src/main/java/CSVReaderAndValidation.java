import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

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
        stringArrayTrimmingLowerCasing(header);

        for (int i = 0; i < fileLines - 1; i++) {

            // creating list of string for each line
            String[] line = csvReader.readNext();
            // trimming and lowering each element  of the list
            stringArrayTrimmingLowerCasing(line);

            //adding elements to the list of items
            list.add(new Item(Integer.parseInt(Arrays.asList(line).get(Arrays.asList(header).indexOf("itemNumber".toLowerCase(Locale.ROOT)))),
                    Integer.parseInt(Arrays.asList(line).get(Arrays.asList(header).indexOf("quantity".toLowerCase(Locale.ROOT)))),
                    Integer.parseInt(Arrays.asList(line).get(Arrays.asList(header).indexOf("binNumber".toLowerCase(Locale.ROOT)))),
                    Boolean.parseBoolean(Arrays.asList(line).get(Arrays.asList(header).indexOf("inStock".toLowerCase(Locale.ROOT))))
                    , Arrays.asList(line).get(Arrays.asList(header).indexOf("name".toLowerCase(Locale.ROOT)))
                    , Double.parseDouble(Arrays.asList(line).get(Arrays.asList(header).indexOf("price".toLowerCase(Locale.ROOT))))));
        }
        return list;
    }

    /**
     * counts number of lines in file
     *
     * @param filePath file absolute path
     * @return number of lines in file
     * @throws IOException thrown if file not found
     */
    static int lineCounter(String filePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        int fileLines = 0;
        while ((bufferedReader.readLine()) != null) {
            fileLines++;
        }
        return fileLines;
    }

    /**
     * trimps and lowers each string in string array
     *
     * @param arr input array
     */
    static void stringArrayTrimmingLowerCasing(String[] arr) {
        for (int j = 0; j < arr.length; j++) {
            arr[j] = arr[j].trim().toLowerCase(Locale.ROOT);
        }
    }
}
