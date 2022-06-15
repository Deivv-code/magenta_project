import java.util.Date;

public class AverageTable {
    private Date date;
    private double average;

    public AverageTable(Date date, double average) {
        this.date = date;
        this.average = average;
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

    public void setAverage(double average) {
        this.average = average;
    }
}
