import java.util.ArrayList;

public class ReaderCSV {
    ParserCSV a = new ParserCSV("air_quality_data.csv");

    public ReaderCSV()
    {
        ArrayList <String> sensorNames = a.fetch(3);
        ArrayList <String> values = a.fetch(4);
        ArrayList <String>DateTime = a.fetch(0);

    }
    //use this class to not use too much times fetch.

}
