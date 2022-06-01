import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 0 || args.length == 1) {
            System.out.println("Devi scrivere due parametri: ");
            return;
        }
        String file_name = args[0];
        String sensor_name = args[1];
        System.out.println(args);



        //double sum = 0;
        //int count = 0;


    /*    try {
            in = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Iterable<CSVRecord> records;
        try {
            records = CSVFormat.EXCEL.parse(in);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (CSVRecord record : records) {
            String datetime = record.get("datetime");
            String latitude = record.get("latitude");
            String longitude = record.get("longitude");
            String sensor_type = record.get("sensor_type");
            Long value = Long.parseLong(record.get("value"));

        }*/

    }
}
