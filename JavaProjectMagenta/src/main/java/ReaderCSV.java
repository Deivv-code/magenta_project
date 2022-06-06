import java.util.ArrayList;

public class ReaderCSV {
    ParserCSV a = new ParserCSV("air_quality_data.csv");
    ArrayList <String> sensorNames =new ArrayList<>();
    ArrayList <String> values = new ArrayList<>();

    ArrayList <String> dateTime = new ArrayList<>();
    public ReaderCSV(ParserCSV a)

    {
        this.a = a;
        sensorNames = a.fetch(3);
        values = a.fetch(4);
        dateTime = a.fetch(0);

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
