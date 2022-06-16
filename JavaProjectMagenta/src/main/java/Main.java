import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.OptionalDouble;

public class Main {

    public static void main(String[] args) {
        String fileName = args[0];

        ParserCSV parser = new ParserCSV(fileName);

        ReaderCSV a = new ReaderCSV(parser);
        ArrayList<Double> values = parser.getAverage("RH");

        ArrayList<Double> valuesT = parser.getAverage("T");
        ArrayList <Double> valuesRH = parser.getAverage("RH");




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






        ArrayList<DataReader> listD = a.fetch();

      /*  ArrayList<Double> list = parser.getAverage(Type.T,listD);
        for (int i = 0; i< list.size(); i++)
        {
            System.out.println(list.get(i));
        }
     */
        
        printJSON(listD);

        printJSONTRH(listD, parser);

      printAverageJSON(parser,Type.T,listD);



       // System.out.println(parser.OneAverage(Type.T,a));


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

  public static void printJSONTRH(ArrayList <DataReader> listD, ParserCSV parser)
    {
        ArrayList <DataReader> listOne = ParserCSV.JSONSensor(listD,Type.T);

        ArrayList <DataReader> listTwo = ParserCSV.JSONSensor(listD,Type.RH);

        ArrayList <Double> averages1 = parser.getAverage(Type.T,listD);
        ArrayList <Double> averages2 = parser.getAverage(Type.RH, listD);

        ArrayList<Date> listDate1 = new ArrayList<>();
        ArrayList<Date> listDate2 = new ArrayList<>();

        ArrayList <AverageTable> listOfAll1 = new ArrayList<>();
        ArrayList <AverageTable> listOfAll2 = new ArrayList<>();



        for (int i = 0; i< listOne.size();i++)
        {
            listDate1.add(listOne.get(i).getDatetime());
        }
        for (int i = 0; i< listTwo.size();i++)
        {
            listDate2.add(listTwo.get(i).getDatetime());
        }

        for (int j = 0 ; j < listDate1.size(); j++)
        {
            for (int i = 0; i< averages1.size();i++)
            {
                AverageTable at = new AverageTable();
                at.setDate(listDate1.get(j));
                at.setAverage(averages1.get(i));
                at.setSensorType(Type.T);
                listOfAll1.add(at);

            }
        }

        for (int j = 0; j < listDate2.size(); j++)
        {
            for (int i = 0; i < averages2.size(); i++)
            {
                AverageTable at = new AverageTable();
                at.setDate(listDate2.get(j));
                at.setAverage(averages2.get(i));
                at.setSensorType(Type.RH);
                listOfAll2.add(at);
            }
        }

        ArrayList <ArrayList> listOfAll = new ArrayList<>();
        listOfAll.add(listOfAll1);
        listOfAll.add(listOfAll2);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("target/listRHT.json"),listOfAll);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    //refactor this method
    public static void printAverageJSON(ParserCSV parser, Type T, ArrayList <DataReader> listD)
    {
        ReaderCSV a = new ReaderCSV(parser);
        ArrayList <Date> listDate = parser.DateConverter(a);
        ArrayList <Double> averages =  parser.getAverage(T, listD);
        ArrayList <AverageTable> listOfAll = new ArrayList<>();
        int limit = parser.LimitExceeded(T,a);


        for (int j = 0; j< listDate.size(); j++)
            {

               for (int i = 0; i < averages.size(); i++)
               {
                   AverageTable at = new AverageTable();
                   at.setDate(listDate.get(j));
                   at.setAverage(averages.get(i));
                   at.setSensorType(T);
                   at.setLimitExceed(limit);
                   listOfAll.add(at);
               }

            }

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("target/listAverage.json"),listOfAll);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}