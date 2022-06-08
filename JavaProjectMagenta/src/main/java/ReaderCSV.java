import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderCSV {
    ParserCSV a = new ParserCSV("air_quality_data.csv");
    ArrayList <String> sensorNames =new ArrayList<>();
    ArrayList <String> values = new ArrayList<>();

    ArrayList <String> dateTime = new ArrayList<>();
    public ReaderCSV(ParserCSV a)

    {

        sensorNames = fetch(3);
        values = fetch(4);
        dateTime = fetch(0);

    }
    public ReaderCSV()

    {

        sensorNames = fetch(3);
        values = fetch(4);
        dateTime = fetch(0);

    }

    public ArrayList<String> fetch(int _index) {
        ArrayList<String> values = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(a.getFile().getAbsolutePath()));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                String item = data[_index];
                values.add(item);
            }
        } catch (IOException e) { e.printStackTrace(); }

        return values;


    }

    //use this class to not use too much times fetch.

    public ArrayList <String> getSensorNames()
    {
        return sensorNames;
    }

    public ArrayList <String> getValues()
    {
        return values;
    }

    public ArrayList <String> getDateTime()
    {
        return dateTime;
    }
}
