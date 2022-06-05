import javax.naming.LimitExceededException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String fileName = args[0];

        ParserCSV parser = new ParserCSV(fileName);

        ArrayList<Double> values = parser.getAverage("RH");

        ArrayList<Double> valuesT = parser.getAverage("T");
        ArrayList <Double> valuesRH = parser.getAverage("RH");
        // process dateTimes
        ArrayList<String> dateTimes = parser.fetch(0);
        ArrayList<String> Alldates = new ArrayList<>();
        ArrayList<String> date = new ArrayList<>();

        for (String data : dateTimes) {
            Alldates.add(data.split(" ")[0]);
        } //remove hours
        for (int i = 1; i < Alldates.size(); i++) { // delete the same dates
            if (i + 1 < Alldates.size() && !(Alldates.get(i).equals(Alldates.get(i + 1)))) {
                date.add(Alldates.get(i));
            }
        }
        date.add(Alldates.get(Alldates.size() - 1));

       System.out.println("start");
        int a = parser.LimitExceeded("PM2.5");
        System.out.println("ez");
        System.out.println(a);

        // print(date, values);

       // printTRH(date, valuesT,valuesRH );


    }

    public static void print(ArrayList<String> date, ArrayList<Double> values) {
        String string = "";
        for (int i = 0; i < date.size(); i++) {
            string = "[" +
                    "\"" + date.get(i) + "\"" + "," +
                    values.get(i) +
                    "], ";
            System.out.println(string);
        }


    }

    public static void printTRH(ArrayList<String> date, ArrayList<Double> valuesT, ArrayList<Double> valuesRH) {
        String string = "";

        for (int i = 0; i < date.size(); i++) {
            string = "[" +
                    "\"" + date.get(i) +  "\"" + "," +

                     valuesT.get(i) +  "," +  valuesRH.get(i) +
                    "], ";
            System.out.println(string);

        }
    }
}