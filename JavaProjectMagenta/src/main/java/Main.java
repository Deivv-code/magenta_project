import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.io.Console;
import java.io.File;
import java.io.IOException;
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
        for (int i = 1; i < Alldates.size(); i++) {
            if (i + 1 < Alldates.size() && !(Alldates.get(i).equals(Alldates.get(i + 1)))) {
                date.add(Alldates.get(i));

            }
        }
        date.add(Alldates.get(Alldates.size() - 1));


   /*    ArrayList < OptionalDouble > average = new ArrayList<>();
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

        ArrayList<DataReader> listD = a.fetch();

        printJSON(listD);



     //   printAverageJSON(parser,Type.PM10,listD);

        System.out.println(parser.OneAverage(Type.T,a));
       //printDateJSON(date);
      //  printTRHJSON(date, valuesT,valuesRH );


       // double c = parser.AnnualAverage("T");
       // System.out.println(c);
    }


    //Eliminate the normal print and keep only the JSON print
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

    public static void printJSON(ArrayList<DataReader> listD)
    {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("target/list.json"),listD);

        } catch (IOException e) {
            throw new RuntimeException(e);
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

  public static void PrintJSONTRH(ArrayList <DataReader> listD)
    {
        ArrayList <DataReader> listOne = ParserCSV.JSONSensor(listD,Type.T);

        ArrayList <DataReader> listTwo = ParserCSV.JSONSensor(listD,Type.RH);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("target/listRHT.json"),listOne);
            mapper.writeValue(new File("target/listRHT.json"),listTwo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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


    public static void printAverageJSON(ParserCSV parser, Type T, ArrayList <DataReader> listD)
    {
        ArrayList <Double> average =  parser.getAverage(T, listD);

        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File("target/listAverage.json"),average);
            mapper.writeValue(new File("target/listAverage.json"),listD);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
 /*   public static void printJSONLimitExceed(Type T, ParserCSV parser)
    {
        int Exceed = parser.LimitExceeded(T);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("target/LimitExceed.json"),Exceed);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

*/

}