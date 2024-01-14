package backend.assignment.util;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.FileReader;
import java.io.IOException;

public class CsvUtil {
    private CsvUtil(){
        throw new IllegalStateException("Util Class");
    }

    public static CSVParser getCSVContent(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        return CSVFormat.DEFAULT.parse(fileReader);
    }
}
