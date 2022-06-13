import org.json.JSONArray;

import javax.naming.LimitExceededException;
import java.util.ArrayList;
import java.util.OptionalDouble;

public class Main {

    public static void main(String[] args) {
        String fileName = args[0];

        ParserCSV parser = new ParserCSV(fileName);

        ReaderCSV a = new ReaderCSV(parser);
        ArrayList<Double> values = parser.getAverage("RH");

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


     /*   ArrayList < OptionalDouble > average = new ArrayList<>();
        average = parser.getAverage(Type.PM10);

        for (int i = 0; i< average.size(); i++)
        {
            System.out.println(average.get(i));
        }
*/

       // double c = parser.OneAverage("PM10");
       // System.out.println(c);


        // int b = parser.LimitExceeded("PM10");

      //  System.out.println(b);
       //  print(date, values, parser,"RH");

      // printTRH(date, valuesT,valuesRH );

        printJSON(date,values,parser,"RH");

       //printDateJSON(date);
      //  printTRHJSON(date, valuesT,valuesRH );
       // printDate(date);

       // double c = parser.AnnualAverage("T");
       // System.out.println(c);
    }

   public static void print(ArrayList<String> date, ArrayList<Double> values, ParserCSV parser,String sAverage) {
        String string = "";

        for (int i = 0; i < date.size(); i++) {
            string = "[" +
                    "\"" +  date.get(i)  + "\"" + ","  +
                   values.get(i) + "," + parser.OneAverage(sAverage) +
                    "], ";

            System.out.println(string);
        }


    }


    public static void printJSON(ArrayList<String> date, ArrayList<Double> values, ParserCSV parser,String sAverage)
    {
        JSONArray list = new JSONArray();
        for (int i=0;i<date.size();i++)
        {
            list.put(date.get(i));
            list.put(values.get(i));
            list.put(parser.OneAverage(sAverage));

        }
        System.out.println(list);
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
    public static void printTRHJSON(ArrayList<String> date, ArrayList<Double> valuesT, ArrayList<Double> valuesRH)
    {
        JSONArray list = new JSONArray();
        for (int i=0;i<date.size();i++)
        {
            list.put(date.get(i));
            list.put(valuesT.get(i));
            list.put(valuesRH.get(i));
        }
        System.out.println(list);
    }
    public static void printDate(ArrayList <String> date)
    {
        String a = "";
        for (int i = 0; i<date.size();i++)
        {
             a = "[" + "\"" + date.get(i) + "\"" + "]" +",";
            System.out.println(a);
        }

    }

    public static void printDateJSON(ArrayList <String> date)
    {
        JSONArray list = new JSONArray();
        for (int i=0;i<date.size();i++)
        {
            list.put(date.get(i));
        }
        System.out.println(list);
    }


}