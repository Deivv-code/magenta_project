import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataReader {
    private Date datetime;
    private double value;
    private Type sensortype;

    public DataReader(Date datetime, double value, Type sensortype) {
        this.datetime = datetime;
        this.value = value;
        this.sensortype = sensortype;

    }

    public Date getDatetime() {
        return datetime;
    }

    public double getValue() {
        return value;
    }

    public Type getSensortype() {
        return sensortype;
    }





}
