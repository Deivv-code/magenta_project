import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ParserCSV {
    private String file_name;

    public ParserCSV(String file_name) {
        this.file_name = file_name;
    }

    String currentDirectory = System.getProperty("user.dir");
    String filePath = currentDirectory + "\\files\\" + file_name;

    BufferedReader in = null;
    String line = "";

    public ArrayList CSVIntoArray(String file_name) {
        ArrayList list = new ArrayList();
        try {
            in = new BufferedReader(new FileReader(filePath));

            while ((line = in.readLine()) != null) {
                String[] row = line.split(",");

                for (String index : row) {
                    System.out.printf("%10s", index);
                }
                System.out.println();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                // System.out.println(sum/count);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

}


