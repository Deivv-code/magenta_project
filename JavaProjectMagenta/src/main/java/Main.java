import javax.naming.LimitExceededException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String fileName = args[0];

        ParserCSV parser = new ParserCSV(fileName);

        ReaderCSV a = new ReaderCSV(parser);
        ArrayList<Double> values = parser.getAverage("T");

        ArrayList<Double> valuesT = parser.getAverage("T");
        ArrayList <Double> valuesRH = parser.getAverage("RH");
        // process dateTimes


        ArrayList<String> dateTimes = a.getDateTime();
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


        int b = parser.LimitExceeded("RH");

        System.out.println(b);

        // print(date, values);

       // printTRH(date, valuesT,valuesRH );

        //printDate(date);

       // double c = parser.AnnualAverage("T");
       // System.out.println(c);
    }

    public static void print(ArrayList<String> date, ArrayList<Double> values) {
        String string = "";
        for (int i = 0; i < date.size(); i++) {
            string = "[" +
                    "\"" + date.get(i) + "\"" + ","  +
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
    public static void printDate(ArrayList <String> date)
    {
        String a = "";
        for (int i = 0; i<date.size();i++)
        {
             a = "[" + "\"" + date.get(i) + "\"" + "]";
            System.out.println(a);
        }

    }

}