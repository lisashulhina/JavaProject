import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class CSVReaderAndValidation {

    public ArrayList<Item> readCSV(String filePath) throws IOException {
        ArrayList<Item> list = new ArrayList<>();
        int fileLines = lineCounter(filePath);
        CSVReader csvReader = new CSVReader(new FileReader(filePath));
        String[] header = csvReader.readNext();
        stringArrayTrimmingLowerCasing(header);
        for (int i = 0; i < fileLines - 1; i++) {
            String[] line = csvReader.readNext();
            stringArrayTrimmingLowerCasing(line);
            list.add(new Item(Integer.parseInt(Arrays.asList(line).get(Arrays.asList(header).indexOf("itemNumber".toLowerCase(Locale.ROOT)))),
                    Integer.parseInt(Arrays.asList(line).get(Arrays.asList(header).indexOf("quantity".toLowerCase(Locale.ROOT)))),
                    Integer.parseInt(Arrays.asList(line).get(Arrays.asList(header).indexOf("binNumber".toLowerCase(Locale.ROOT)))),
                    Boolean.parseBoolean(Arrays.asList(line).get(Arrays.asList(header).indexOf("inStock".toLowerCase(Locale.ROOT))))
                    , Arrays.asList(line).get(Arrays.asList(header).indexOf("name".toLowerCase(Locale.ROOT)))
                    , Double.parseDouble(Arrays.asList(line).get(Arrays.asList(header).indexOf("price".toLowerCase(Locale.ROOT))))));
        }
        return list;
    }

    static int lineCounter(String filePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        int fileLines = 0;
        while ((bufferedReader.readLine()) != null) {
            fileLines++;
        }
        return fileLines;
    }

    static void stringArrayTrimmingLowerCasing(String[] arr) {
        for (int j = 0; j < arr.length; j++) {
            arr[j] = arr[j].trim().toLowerCase(Locale.ROOT);
        }
    }
}
