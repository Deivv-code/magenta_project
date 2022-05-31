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
        
        String currentDirectory = System.getProperty("user.dir");
        System.out.println(currentDirectory + "\\" + file_name);
        String filePath = currentDirectory + "\\files\\" + file_name;
        BufferedReader in = null;
        String line ="";

        //double sum = 0;
        //int count = 0;
        try {
            in = new BufferedReader(new FileReader(filePath));

            while((line = in.readLine() )!= null)
            {
                String[] row = line.split(",");
                /*double v = Double.parseDouble(row[0]);
                sum = sum + v;
                count++;
                */
                for(String index : row)
                {
                    System.out.printf("%10s", index);
                }
                System.out.println();
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
               // System.out.println(sum/count);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


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
