import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ParserCSV {
    String fileName;
    String sensorT;

    static double [] [] ArrayCSV;

    public ParserCSV(String fileName, String sensorT) {
    this.fileName = fileName;
    this.sensorT = sensorT;
    }


    public String Parse()
    {

        String fileName = this.fileName;
        String sensorName = sensorT;

        String currentDirectory = System.getProperty("user.dir");
        File file = new File(currentDirectory + "\\files\\" + fileName);


        ArrayList<String> dateTimes = new ArrayList();
        ArrayList<String> sensorTypes = new ArrayList();
        ArrayList<String> values = new ArrayList();

        // GET
        try {
            BufferedReader reader = new BufferedReader( new FileReader( file.getAbsolutePath() ) );

            // boolean isFirstLoop = true;
            String line;
            while ((line = reader.readLine()) != null) {
                // if (isFirstLoop) { isFirstLoop = false; continue; }
                String[] data = line.split(";");
                String dateTime = data[0];
                String sensorType = data[3];
                String value = data[4];

                dateTimes.add(dateTime);
                sensorTypes.add(sensorType);
                values.add(value);
            }


        } catch(IOException e) { e.printStackTrace(); }

        // PRINT
        String s ="";
        for (int i=0; i<dateTimes.size(); i++) {
            s+="[" +
                    "\""+dateTimes.get(i)+ "\", " +
                    "\""+sensorTypes.get(i)+ "\", " +
                    "\""+values.get(i)+ "\"" +
                    "],";
        }
        return s;
    }




}


