import java.util.ArrayList;
import java.util.Date;

public class AverageTable {
   private ArrayList <Date> date;
    private ArrayList <Double> average;

    public AverageTable(ArrayList<Date> date, ArrayList<Double> average) {
        this.date = date;
        this.average = average;
    }

   public void addDate(Date a)
   {
       date.add(a);
   }
   public void addAverage(double a)
   {
       average.add(a);
   }

    public AverageTable() {

    }


}
