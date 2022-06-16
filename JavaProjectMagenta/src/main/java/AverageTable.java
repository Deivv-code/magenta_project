import java.util.Date;

public class AverageTable {
    private  Date date;
    private double average;

    private Type sensorType;

    public AverageTable(Date date, double average) {
        this.date = date;
        this.average = average;
    }

    public AverageTable(Date date, double average, Type sensorType) {
        this.date = date;
        this.average = average;
        this.sensorType = sensorType;
    }

    public AverageTable() {

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAverage() {
        return average;
    }

    public Type getSensorType() {
        return sensorType;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public void setSensorType(Type sensorType) {
        this.sensorType = sensorType;
    }
}
